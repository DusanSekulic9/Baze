package model;

import javax.swing.tree.DefaultTreeModel;

import main.AppCore;

public class DataBaseModel extends DefaultTreeModel{

	private static final long serialVersionUID = 8132163890940557194L;

	public DataBaseModel() {
		super(AppCore.getInstance().getIr());
	}

}
