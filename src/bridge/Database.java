package bridge;

import java.util.List;

import data.Row;
import nodes.DBNode;


public interface Database {

	DBNode loadResource();

    List<Row> readDataFromTable(String tableName);
}
