package view;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Attribute;
import model.AttributeConstraint;
import model.InformationResource;
import model.Entity;

public class TreeNodeRenderer extends DefaultTreeCellRenderer {

	public TreeNodeRenderer() {

		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof InformationResource) {
			URL imageURL = getClass().getResource("images/tdiagram.gif");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof Attribute) {
			URL imageURL = getClass().getResource("images/tproject.gif");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof AttributeConstraint) {
			URL imageURL = getClass().getResource("images/tproject.gif");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof Entity) {
			URL imageURL = getClass().getResource("entity.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		}

		return this;
	}

}
