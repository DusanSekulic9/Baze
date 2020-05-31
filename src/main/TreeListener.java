package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Entity;
import observer.Notification;
import observer.NotificationCode;

public class TreeListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			var o = MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
			if (o instanceof Entity) {
				Entity entity = (Entity) o;
				entity.show();
			}
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
