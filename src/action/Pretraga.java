package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import main.MainFrame;
import view.PretragaGui;

public class Pretraga  extends Akcija{

	@Override
	public void actionPerformed(ActionEvent e) {
		//MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
		PretragaGui drugiProzor = new PretragaGui();
		drugiProzor.inicijalizacija();
		drugiProzor.dodaj();
		drugiProzor.setVisible(true);
	}

	public Pretraga() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ucitajIkonicu("src/search.png"));
		putValue(NAME, "Pretraga");
		putValue(SHORT_DESCRIPTION, "Pretraga");
	}
	
	

}
