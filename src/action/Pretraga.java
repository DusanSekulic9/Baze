package action;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import main.MainFrame;
import view.PretragaGui;

public class Pretraga  extends Akcija{

	@Override
	public void actionPerformed(ActionEvent e) {
		//MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
		if(MainFrame.getInstance().getTaboviGore().getSelectedComponent().getName() == null) {
			return;
		}
		PretragaGui drugiProzor = new PretragaGui(MainFrame.getInstance().getTaboviGore().getSelectedComponent().getName());
		drugiProzor.inicijalizacija();
		drugiProzor.dodaj(new JPanel());
		drugiProzor.setVisible(true);
	}

	public Pretraga() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, ucitajIkonicu("src/search.png"));
		putValue(NAME, "Pretraga");
		putValue(SHORT_DESCRIPTION, "Pretraga");
	}
	
	

}
