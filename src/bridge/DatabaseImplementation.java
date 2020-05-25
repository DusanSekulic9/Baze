package bridge;

import java.util.List;

import data.Row;
import nodes.DBNode;

public class DatabaseImplementation implements Database{

	private Repository repository;
	
	public DatabaseImplementation(Repository repository) {
		this.repository = repository;
	}
	
	@Override
	public DBNode loadResource() {
		return repository.getShcema();
	}

	@Override
	public List<Row> readDataFromTable(String tableName) {
		return repository.get(tableName);
	}
	
	public Repository getRepository() {
		return repository;
	}

}
