package main;

import view.MainFrame;

public class Main {
	public static void main(String[] args) {
		AppCore.getInstance();
		MainFrame prozor = MainFrame.getInstance();
		prozor.setVisible(true);
	}
}
