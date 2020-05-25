package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Akcija extends AbstractAction {

	public Icon ucitajIkonicu(String name) {
		return new ImageIcon(name);
	}

	public void setInvisble() {
		setEnabled(false);
	}

	public void setVisible() {
		setEnabled(true);
	}



}
