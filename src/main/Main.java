package main;

public class Main {
	public static void main(String[] args) {
		AppCore.getInstance();
		MainFrame prozor = MainFrame.getInstance();
		prozor.setVisible(true);
	}
}
