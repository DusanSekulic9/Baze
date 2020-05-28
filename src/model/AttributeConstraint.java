package model;

import enums.ConstraintType;
import nodes.DBNode;

public class AttributeConstraint extends DBNode{
	
	private ConstraintType constraintType;

	public AttributeConstraint(String name, DBNode parent, ConstraintType constraintType) {
		super(name, parent);
		this.constraintType = constraintType;
	}
	
	public ConstraintType getConstraintType() {
		return constraintType;
	}

}
