package gui;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import data.Row;
import view.MainFrame;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class TableModel extends DefaultTableModel {

	private List<Row> rows;
	private String name;

	private void updateModel() {

		int columnCount = rows.get(1).getFields().keySet().size();

		Vector columnVector = DefaultTableModel.convertToVector(rows.get(1).getFields().keySet().toArray());
		Vector dataVector = new Vector(columnCount);

		for (int i = 0; i < rows.size(); i++) {
			dataVector.add(DefaultTableModel.convertToVector(rows.get(i).getFields().values().toArray()));
		}
		setDataVector(dataVector, columnVector);
//		JTabbedPane tabG = MainFrame.getInstance().getTaboviGore();
//		String name = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent().toString();
//		if(tabG.indexOfTab(name) == -1) {
//			JPanel panel = new JPanel();
//			panel.add(MainFrame.getInstance().getTblUp());
//			tabG.addTab(name, panel);
//		}
//		tabG.setSelectedIndex(tabG.indexOfTab(name));
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
		updateModel();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
