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
	
	public Entity getEntity(String name) {
		for(DBNode node : getChildren()) {
			if(node.getName().equalsIgnoreCase(name)) {
				return (Entity) node;
			}
		}
		return null;
	}
	
}
