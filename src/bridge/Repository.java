package bridge;

import java.util.List;

import data.Row;
import nodes.DBNode;

public interface Repository {

	DBNode getShcema();

	List<Row> get(String tableName);
	
	List<Row> search(String tableName);
}
