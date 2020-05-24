package main;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import model.DataBaseModel;

public class Tree extends JTree {

	public Tree() {
		
		//addTreeSelectionListener(new WorkspaceTreeController());
	    //setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new TreeNodeRenderer());
	    setEditable(true);
	}

	


	
}
