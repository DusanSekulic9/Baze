package main;

import model.DataBaseModel;

public class AppCore {
	
	private static DataBaseModel dataBaseModel;
	
	public AppCore() {
		getScheme();
	}

	private void getScheme() {
		dataBaseModel = new DataBaseModel();
	}
	
	public static DataBaseModel getDataBaseModel() {
		return dataBaseModel;
	}
}
