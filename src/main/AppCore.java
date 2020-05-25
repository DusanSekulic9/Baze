package main;

import javax.swing.table.TableModel;

import bridge.Database;
import bridge.DatabaseImplementation;
import bridge.MSSQLRepository;
import bridge.settings.Settings;
import bridge.settings.SettingsImplementation;
import data.Constants;
import model.InformationResource;

public class AppCore {
	private static AppCore instance;
	private Database database;
	private Settings settings;
	private InformationResource ir;

	private AppCore() {
		this.settings = initSettings();
		this.database = new DatabaseImplementation(new MSSQLRepository(this.settings));
		loadResource();
	}

	private Settings initSettings() {
		Settings settingsImplementation = new SettingsImplementation();
		settingsImplementation.addParameter("mssql_ip", Constants.MSSQL_IP);
		settingsImplementation.addParameter("mssql_database", Constants.MSSQL_DATABASE);
		settingsImplementation.addParameter("mssql_username", Constants.MSSQL_USERNAME);
		settingsImplementation.addParameter("mssql_password", Constants.MSSQL_PASSWORD);
		return settingsImplementation;
	}
	
	public static AppCore getInstance() {
		if(instance == null) {
			instance = new AppCore();
		}
		return instance;
	}

	public void loadResource() {
		this.ir = (InformationResource) this.database.loadResource();
		//this.notifySubscribers(new Notification(NotificationCode.RESOURCE_LOADED, ir));
	}

	public void readDataFromTable(String fromTable) {

		//tableModel.setRows(this.database.readDataFromTable(fromTable));

		// Zasto ova linija moze da ostane zakomentarisana?
		// this.notifySubscribers(new Notification(NotificationCode.DATA_UPDATED,
		// this.getTableModel()));
	}
	
	public InformationResource getIr() {
		return ir;
	}

}
