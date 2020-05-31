package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import view.MainFrame;

public class UpdateAction extends Akcija{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
		
	}

	public UpdateAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ucitajIkonicu("src/update.png"));
		putValue(NAME, "Exit");
		putValue(SHORT_DESCRIPTION, "Exit");
	}
	
	

}
