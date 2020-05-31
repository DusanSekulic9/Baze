package gui;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ScrollPane extends JScrollPane{

	private String name;
	
	public ScrollPane(JTable table) {
		super(table);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
	
}
