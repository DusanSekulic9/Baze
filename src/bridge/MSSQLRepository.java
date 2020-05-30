package bridge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bridge.settings.Settings;
import data.Constants;
import data.Row;
import enums.AttributeType;
import enums.ConstraintType;
import model.Attribute;
import model.AttributeConstraint;
import model.Entity;
import model.InformationResource;
import nodes.DBNode;
import nodes.DBNodeComposite;

public class MSSQLRepository implements Repository{
	
	private Settings settings;
    private Connection connection;

	public MSSQLRepository(Settings settings) {
		this.settings = settings;
	}
	
	private void initConnection() throws SQLException, ClassNotFoundException{
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String ip = (String) settings.getParameter("mssql_ip");
        String database = (String) settings.getParameter("mssql_database");
        String username = (String) settings.getParameter("mssql_username");
        String password = (String) settings.getParameter("mssql_password");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:jtds:sqlserver://"+ip+"/"+database,username,password);
    }

    private void closeConnection(){
        try{
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            connection = null;
        }
    }
    
    @Override
    public DBNode getShcema() {

        try{
            this.initConnection();

            DatabaseMetaData metaData = connection.getMetaData();
            InformationResource ir = new InformationResource(Constants.MSSQL_DATABASE);

            String tableType[] = {"TABLE"};
            ResultSet tables = metaData.getTables(connection.getCatalog(), null, null, tableType);

            while (tables.next()){

                String tableName = tables.getString("TABLE_NAME");
                if(tableName.contains("trace")) {
                	continue;
                }
                Entity newTable = new Entity(tableName, ir);
                ir.addNode(newTable);

                //Koje atribute imaja ova tabela?

                ResultSet columns = metaData.getColumns(connection.getCatalog(), null, tableName, null);

                while (columns.next()){

                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    String isNullable = columns.getString("IS_NULLABLE");
                    String hasDefault = columns.getString("COLUMN_DEF");
                    int columnSize = Integer.parseInt(columns.getString("COLUMN_SIZE"));
                    Attribute attribute = new Attribute(columnName, newTable, AttributeType.valueOf(columnType.toUpperCase()), columnSize, isNullable);
                    if(hasDefault != null) {
                    	attribute.addNode(new AttributeConstraint("IS_DEFAULT", attribute, ConstraintType.DEFAULT_VALUE));
                    }
                    newTable.addNode(attribute);
                    //domain value
                }
                
                //TODO Ogranicenja nad kolonama? Relacije?
                ResultSet primaryKeys = metaData.getPrimaryKeys(connection.getCatalog(), null, tableName);
                while(primaryKeys.next()) {
                	String name = primaryKeys.getString("COLUMN_NAME");
                	for(DBNode node : newTable.getChildren()) {
                		if(name.equalsIgnoreCase(node.getName())) {
                			DBNodeComposite nc = (DBNodeComposite) node;
                			nc.addNode(new AttributeConstraint("PRIMARY_KEY", nc, ConstraintType.PRIMARY_KEY));
                		}
                	}
                }
            }
            for(DBNode table : ir.getChildren()) {
            	ResultSet foreignKeys = metaData.getImportedKeys(connection.getCatalog(), null, table.getName());
            	while(foreignKeys.next()) {
            		String fkTableName = foreignKeys.getString("FKTABLE_NAME");
            		String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
            		String pkTableName = foreignKeys.getString("PKTABLE_NAME");
            		String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
            		Entity tabela = (Entity) table;
            		Attribute attribute1 = null;
            		for(DBNode child : tabela.getChildren()) {
            			if(child.getName().equalsIgnoreCase(fkColumnName)) {
            				attribute1 = (Attribute) child;
            				break;
            			}
            		}
            		System.out.println(attribute1);
            		Entity tabela2 = null;
            		for(DBNode table2 : ir.getChildren()) {
            			if(table2.getName().equalsIgnoreCase(pkTableName)) {
            				tabela2 = (Entity) table2;
            				break;
            			}
            		}
            		System.out.println(tabela2);
            		Attribute attribute2 = null;
            		for(DBNode child : tabela2.getChildren()) {
            			if(child.getName().equalsIgnoreCase(pkColumnName)) {
            				attribute2 = (Attribute) child;
            				break;
            			}
            		}
            		System.out.println(attribute2);
            		attribute1.getRelations().add(attribute2);
            		attribute2.getRelations().add(attribute1);
            		attribute1.addNode(new AttributeConstraint("FOREIGN_KEY", attribute1, ConstraintType.FOREIGN_KEY));
            		
            		
            	}
            }
            return ir;
           

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return null;
    }

    @Override
    public List<Row> get(String from) {

        List<Row> rows = new ArrayList<>();


        try{
            this.initConnection();

            String query = "SELECT * FROM " + from;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){

                Row row = new Row();
                row.setName(from);

                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                for (int i = 1; i<=resultSetMetaData.getColumnCount(); i++){
                    row.addField(resultSetMetaData.getColumnName(i), rs.getString(i));
                }
                rows.add(row);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return rows;
    }

}
