package nodes;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public abstract class DBNode implements TreeNode {

	private String name;
	private DBNode parent;
	
	public DBNode(String name, DBNode parent) {
		this.name = name;
		this.parent = parent;
	}
	
	@Override
	public Enumeration<? extends TreeNode> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return 0;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(DBNode parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
