package bridge;

import java.util.ArrayList;
import java.util.List;

import data.Row;
import model.Attribute;
import model.Entity;
import nodes.DBNode;

public interface Repository {

	DBNode getShcema();

	List<Row> get(String tableName);
	
	List<Row> search(Entity entity, ArrayList<Attribute> at, ArrayList<String> oper, ArrayList<String> znak, ArrayList<String> param);
}
