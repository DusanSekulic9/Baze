package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import action.SveAkcije;
import gui.TableModel;
import listeners.TabListener;
import model.Attribute;
import model.DataBaseModel;
import model.Entity;
import nodes.DBNode;
import observer.Notification;
import observer.NotificationCode;
import observer.Subscriber;

public class MainFrame extends JFrame implements Subscriber{

	private static MainFrame instance;
	private Tree workspaceTree;
	private SveAkcije akcije;
	private ToolBar tBar;
	private ArrayList<JTable> tblUp = new ArrayList<JTable>();
	private ArrayList<JTable> tblDown = new ArrayList<JTable>();

	private JTabbedPane taboviGore = new JTabbedPane();
	private JTabbedPane taboviDole = new JTabbedPane();

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
		// this.treeModel = new TreeModel();
		workspaceTree.setModel(new DataBaseModel());
		taboviGore.addMouseListener(new TabListener());

//		Object[] columns = new Object[] { "Dosije", "Ime", "Prezime" };

//		Object[][] data = { { "ra1/2011", "Petar", "Petroviæ" }, { "ra1/2011", "Lazar", "Laziæ" },
//				{ "ra2/2011", "Milan", "Kovaèeviæ" }, { "ra3/2011", "Ana", "Petroviæ" },
//				{ "ra4/2011", "Bojan", "Bakiæ" }, { "ra5/2011", "Dragan", "Kovaèeviæ" },
//				{ "ra6/2011", "Ivan", "Iviæ" } };

		
		JScrollPane treeScroll = new JScrollPane(workspaceTree);

		JScrollPane tableUpScroll = new JScrollPane();
		JScrollPane tableDownScrooll = new JScrollPane();
		//taboviGore.addTab(, tableUpScroll);
		//taboviDole.addTab("prvi tab", tableDownScrooll);
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
		Notification not = (Notification) notification;
		if(not.getCode().equals(NotificationCode.RESOURCE_LOADED)) {
			
		}else if(not.getCode().equals(NotificationCode.SHOW)) {
			Entity entity = (Entity) not.getData();
			String name = entity.getName();
			if(taboviGore.indexOfTab(name) == -1) {
				JTable table = new JTable();
				TableModel tableModel = new TableModel();
				tableModel.setName(name);
				AppCore.getInstance().getTableModels().add(tableModel);
				table.setModel(tableModel);
				taboviGore.addTab(name, table);
				AppCore.getInstance().readDataFromTable(tableModel.getName());
			}else {
				taboviGore.setSelectedIndex(taboviGore.indexOfTab(name));
			}
			updateDown(entity);
		}
	}

	public void updateDown(Entity entity) {
		deleteOld();
		makeNewTabsDown(entity);
		taboviGore.setSelectedIndex(taboviGore.indexOfTab(entity.getName()));
	}

	private void makeNewTabsDown(Entity entity) {
		ArrayList<Attribute> attributesOfEntityWithRelation = new ArrayList<Attribute>();
		ArrayList<Attribute> relations = new ArrayList<Attribute>();
		for(DBNode node : entity.getChildren()) {
			Attribute at = (Attribute) node;
			if(!at.getRelations().isEmpty()) {
				attributesOfEntityWithRelation.add((Attribute) node);
			}
		}
		for(Attribute at : attributesOfEntityWithRelation) {
			relations.addAll(at.getRelations());
		}
		for(Attribute at : relations) {
			Entity e = (Entity) at.getParent();
			if(taboviDole.indexOfTab(e.getName()) == -1) {
				JTable table = new JTable();
				TableModel tableModel = new TableModel();
				AppCore.getInstance().getTableModels().add(tableModel);
				tableModel.setName(e.getName());
				table.setModel(tableModel);
				taboviDole.addTab(e.getName(), table);
				AppCore.getInstance().readDataFromTable(tableModel.getName());
			}
		}
		
	}

	private void deleteOld() {
		for(Component c :taboviDole.getComponents()) {
			JTable table = (JTable) c;
			AppCore.getInstance().getTableModels().remove(table.getModel());
			tblDown.remove(table);
		}
		taboviDole.removeAll();
	}

	public JTabbedPane getTaboviGore() {
		return taboviGore;
	}

	public void setTaboviGore(JTabbedPane taboviGore) {
		this.taboviGore = taboviGore;
	}

	public JTabbedPane getTaboviDole() {
		return taboviDole;
	}

	public void setTaboviDole(JTabbedPane taboviDole) {
		this.taboviDole = taboviDole;
	}

	public ArrayList<JTable> getTblUp() {
		return tblUp;
	}

	public void setTblUp(ArrayList<JTable> tblUp) {
		this.tblUp = tblUp;
	}

	public ArrayList<JTable> getTblDown() {
		return tblDown;
	}

	public void setTblDown(ArrayList<JTable> tblDown) {
		this.tblDown = tblDown;
	}

	
	
	
	
	
}
