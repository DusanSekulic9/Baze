package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class Gui extends JFrame {
	
	private static Gui instance;
	private Gui() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setTitle("Tim");
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
	
	public static Gui getInstance() {
		if (instance == null) {
			instance = new Gui();
			instance.dodajElemente();

		}
		return instance;
	}
}
