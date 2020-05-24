package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {
	
	private static MainFrame instance;
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
		
		JDesktopPane dekstop = new JDesktopPane();
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
		
		JPanel treePanel = new JPanel();
		JPanel tabelePanel = new JPanel();
		JPanel novi = new JPanel();
		
		JTabbedPane tabovi = new JTabbedPane();
		tabelePanel.add(tabovi);
		novi.add(new Label("dadada"));
		tabovi.add(novi);
		var tableUpScroll = new JScrollPane();
		var tableDownScrooll = new JScrollPane();
		JSplitPane splitTable = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabovi, tableDownScrooll);

		JSplitPane splitGui = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, splitTable);
		this.add(splitGui, BorderLayout.CENTER);
		splitGui.setDividerLocation(320);
		splitGui.setDividerLocation(250);

	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.dodajElemente();

		}
		return instance;
	}
}
