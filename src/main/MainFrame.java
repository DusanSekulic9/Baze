package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import action.SveAkcije;
import gui.TableModel;
import model.DataBaseModel;
import observer.NotificationCode;
import observer.Subscriber;

public class MainFrame extends JFrame implements Subscriber,MouseListener {

	private static MainFrame instance;
	private Tree workspaceTree;
	private SveAkcije akcije;
	private ToolBar tBar;
	private JTable tblUp;
	private JTable tblDown;
	
	private MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setTitle("Tim 2");
		setLocationRelativeTo(null);

		setSize(1200, 750);
		setLocationRelativeTo(null);
	}

	public void dodajElemente() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		akcije = new SveAkcije();
		tBar = new ToolBar();
		tblUp = new JTable();
		tblDown = new JTable();
		tblUp.setModel(new TableModel());
		this.add(tBar, BorderLayout.NORTH);
		this.workspaceTree = new Tree();
		// this.treeModel = new TreeModel();
		workspaceTree.setModel(new DataBaseModel());

//		Object[] columns = new Object[] { "Dosije", "Ime", "Prezime" };

//		Object[][] data = { { "ra1/2011", "Petar", "Petroviæ" }, { "ra1/2011", "Lazar", "Laziæ" },
//				{ "ra2/2011", "Milan", "Kovaèeviæ" }, { "ra3/2011", "Ana", "Petroviæ" },
//				{ "ra4/2011", "Bojan", "Bakiæ" }, { "ra5/2011", "Dragan", "Kovaèeviæ" },
//				{ "ra6/2011", "Ivan", "Iviæ" } };

		
		JScrollPane treeScroll = new JScrollPane(workspaceTree);

		JTabbedPane taboviGore = new JTabbedPane();
		JTabbedPane taboviDole = new JTabbedPane();
		JScrollPane tableUpScroll = new JScrollPane(tblUp);
		JScrollPane tableDownScrooll = new JScrollPane(tblDown);
		taboviGore.addTab("prvi tab", tableUpScroll);
		taboviDole.addTab("prvi tab", tableDownScrooll);
		// panelZaTabove.add(tableUpScroll);

		JSplitPane splitTable = new JSplitPane(JSplitPane.VERTICAL_SPLIT, taboviGore, taboviDole);
		panel.add(tBar, BorderLayout.NORTH);
		panel.add(splitTable, BorderLayout.CENTER);
		JSplitPane splitGui = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, panel);
		this.add(splitGui, BorderLayout.CENTER);
		splitGui.setDividerLocation(320);
		splitGui.setDividerLocation(250);
		splitTable.setDividerLocation(350);

	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.dodajElemente();

		}
		return instance;
	}

	public Tree getWorkspaceTree() {
		return workspaceTree;
	}

	public void setWorkspaceTree(Tree workspaceTree) {
		this.workspaceTree = workspaceTree;
	}

	public SveAkcije getAkcije() {
		return akcije;
	}

	public void setAkcije(SveAkcije akcije) {
		this.akcije = akcije;
	}

	public ToolBar gettBar() {
		return tBar;
	}

	public void settBar(ToolBar tBar) {
		this.tBar = tBar;
	}

	@Override
	public void update(Object notification) {
//		if (notification.getCode() == NotificationCode.RESOURCE_LOADED){
		// System.out.println((InformationResource)notification.getData());
		// }

		// else{
		// jTable.setModel((TableModel) notification.getData());
		// }

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
