package bridge;

import java.util.ArrayList;
import java.util.List;

import data.Row;
import model.Attribute;
import model.Entity;
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

	@Override
	public List<Row> search(Entity entity, ArrayList<Attribute> at, ArrayList<String> oper, ArrayList<String> znak,
			ArrayList<String> param) {
		return repository.search(entity, at, oper, znak, param);
	}

	

}
