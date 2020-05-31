package view;

import javax.swing.JTree;

import listeners.TreeListener;


public class Tree extends JTree  {

	public Tree() {
		
		//addTreeSelectionListener(new WorkspaceTreeController());
	    //setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new TreeNodeRenderer());
	    setEditable(true);
	    addMouseListener(new TreeListener());
	}

	
	


	
}
