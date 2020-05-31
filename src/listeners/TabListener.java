package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.TableModel;
import main.AppCore;
import main.MainFrame;

public class TabListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JTabbedPane tab = MainFrame.getInstance().getTaboviGore();
		JTable table = (JTable) tab.getSelectedComponent();
		TableModel tableModel = (TableModel) table.getModel();
		AppCore.getInstance().readDataFromTable(tableModel.getName());
		MainFrame.getInstance().updateDown(AppCore.getInstance().getIr().getEntity(tableModel.getName()));
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
