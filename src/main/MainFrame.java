package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import action.SveAkcije;
import model.DataBaseModel;

public class MainFrame extends JFrame {
	
	private static MainFrame instance;
	private Tree workspaceTree;
	private SveAkcije akcije;
	private ToolBar tBar;
	
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
		this.add(tBar, BorderLayout.NORTH);
		this.workspaceTree = new Tree();
		//this.treeModel = new TreeModel();
		workspaceTree.setModel(AppCore.getDataBaseModel());
		
		Object[] columns = new Object[] { "Dosije", "Ime", "Prezime" };

		Object[][] data = { { "ra1/2011", "Petar", "Petrovi�" },
				{ "ra1/2011", "Lazar", "Lazi�" },
				{ "ra2/2011", "Milan", "Kova�evi�" },
				{ "ra3/2011", "Ana", "Petrovi�" },
				{ "ra4/2011", "Bojan", "Baki�" },
				{ "ra5/2011", "Dragan", "Kova�evi�" },
				{ "ra6/2011", "Ivan", "Ivi�" } };
		
		JTable tblUp = new JTable(data, columns);
		JTable tblDown = new JTable(data, columns);
		JScrollPane treeScroll = new JScrollPane(workspaceTree);
		
		JTabbedPane taboviGore = new JTabbedPane();
		JTabbedPane taboviDole = new JTabbedPane();
		JScrollPane tableUpScroll = new JScrollPane(tblUp);
		JScrollPane tableDownScrooll = new JScrollPane(tblDown);
		taboviGore.addTab("prvi tab", tableUpScroll);
		taboviDole.addTab("prvi tab", tableDownScrooll);
		//panelZaTabove.add(tableUpScroll);
		
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
	
	
}
