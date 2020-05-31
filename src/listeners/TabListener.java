package listeners;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.ScrollPane;
import gui.TableModel;
import main.AppCore;
import main.MainFrame;

public class TabListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ScrollPane scroll = (ScrollPane) MainFrame.getInstance().getTaboviGore().getSelectedComponent();
		
		MainFrame.getInstance().updateUp(AppCore.getInstance().getIr().getEntity(scroll.getName()));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
