package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
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

		JTable tblUp = new JTable();
		JTable tblDown = new JTable();

		JPanel treePanel = new JPanel();
		JPanel tabelePanel = new JPanel();

		var tableUpScroll = new JScrollPane();
		var tableDownScrooll = new JScrollPane();
		JSplitPane splitTable = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableUpScroll, tableDownScrooll);

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
