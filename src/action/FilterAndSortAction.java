package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import view.MainFrame;

public class FilterAndSortAction extends Akcija{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
		
	}

	public FilterAndSortAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ucitajIkonicu("src/filter.png"));
		putValue(NAME, "Exit");
		putValue(SHORT_DESCRIPTION, "Exit");
	}
	
	

}