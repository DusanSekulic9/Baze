package model;

import javax.swing.tree.DefaultTreeModel;

public class DataBaseModel extends DefaultTreeModel{

	private static final long serialVersionUID = 8132163890940557194L;

	public DataBaseModel() {
		super(new DataBaseNode("BP_TIM2", null));
	}

}
