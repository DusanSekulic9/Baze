package model;

import enums.AttributeType;
import nodes.DBNode;
import nodes.DBNodeComposite;

public class Attribute extends DBNodeComposite{
	
	private AttributeType attributeType;
	private int length;

	public Attribute(String name, DBNode parent) {
		super(name, parent);
	}
	
	public Attribute(String name, DBNode parent, AttributeType attributeType, int length) {
		super(name,parent);
		this.attributeType = attributeType;
		this.length = length;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public int getLength() {
		return length;
	}
	
	
	

}
