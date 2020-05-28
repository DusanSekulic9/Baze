package model;

import enums.AttributeType;
import enums.ConstraintType;
import nodes.DBNode;
import nodes.DBNodeComposite;

public class Attribute extends DBNodeComposite{
	
	private AttributeType attributeType;
	private int length;
	private Attribute relation;

	public Attribute(String name, DBNode parent) {
		super(name, parent);
	}
	
	public Attribute(String name, DBNode parent, AttributeType attributeType, int length, String isNullable) {
		super(name,parent);
		this.attributeType = attributeType;
		this.length = length;
		if(isNullable.equalsIgnoreCase("no")) {
			this.addNode(new AttributeConstraint("NOT_NULL", this, ConstraintType.NOT_NULL));
		}
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public int getLength() {
		return length;
	}
	
	public Attribute getRelation() {
		return relation;
	}
	
	public void setRelation(Attribute relation) {
		this.relation = relation;
	}
	
	
	

}
