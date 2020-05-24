package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import model.DataBaseModel;

public class MainFrame extends JFrame {
	
	private static MainFrame instance;
	private Tree workspaceTree;
	
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
		this.workspaceTree = new Tree();
		//this.treeModel = new TreeModel();
		workspaceTree.setModel(AppCore.getDataBaseModel());
		
		Object[] columns = new Object[] { "Dosije", "Ime", "Prezime" };

		Object[][] data = { { "ra1/2011", "Petar", "Petroviæ" },
				{ "ra1/2011", "Lazar", "Laziæ" },
				{ "ra2/2011", "Milan", "Kovaèeviæ" },
				{ "ra3/2011", "Ana", "Petroviæ" },
				{ "ra4/2011", "Bojan", "Bakiæ" },
				{ "ra5/2011", "Dragan", "Kovaèeviæ" },
				{ "ra6/2011", "Ivan", "Iviæ" } };
		
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

		JSplitPane splitGui = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, splitTable);
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
	
	
}
