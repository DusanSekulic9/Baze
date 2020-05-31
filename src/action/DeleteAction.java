package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import view.MainFrame;

public class DeleteAction extends Akcija{

	@Override
	public void actionPerformed(ActionEvent e) {
		//MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
		
	}

	public DeleteAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ucitajIkonicu("src/delete.png"));
		putValue(NAME, "Exit");
		putValue(SHORT_DESCRIPTION, "Exit");
	}
	
	

}
