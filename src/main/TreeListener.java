package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Entity;

public class TreeListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		var o = MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();

		if (o instanceof Entity && e.getClickCount() == 2) {
			AppCore.getInstance().readDataFromTable(((Entity) o).getName());
			
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
