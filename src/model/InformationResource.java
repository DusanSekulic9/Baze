package model;

import nodes.DBNode;
import nodes.DBNodeComposite;

public class InformationResource extends DBNodeComposite{

	public InformationResource(String name, DBNode parent) {
		super(name, parent);
	}
	
	public InformationResource(String name) {
		super(name);
	}
	
}
