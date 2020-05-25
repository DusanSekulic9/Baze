package nodes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;


public abstract class DBNodeComposite extends DBNode{

	private List<DBNode> children;
	
	public DBNodeComposite(String name, DBNode parent) {
		super(name,parent);
		this.children = new ArrayList<DBNode>();
	}
	
	public DBNodeComposite(String name) {
		super(name);
		this.children = new ArrayList<DBNode>();
	}
	
	@Override
	public boolean getAllowsChildren() {
		return true;
	}
	
	@Override
	public TreeNode getChildAt(int arg0) {
		return children.get(arg0);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return children.indexOf(arg0);
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	public List<DBNode> getChildren() {
		return children;
	}
	
	public void addNode(DBNode node) {
		this.children.add(node);
		//notify?
	}
	
}
