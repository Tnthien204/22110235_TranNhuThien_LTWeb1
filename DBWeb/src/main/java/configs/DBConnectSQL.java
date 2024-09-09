package configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DBConnectSQL {
	private final String serverName = "LAPTOP-VS4HU7M2";
	private final String dbName = "CongTy";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "12345";
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
			if (instance == null || instance.trim().isEmpty())
				url ="jdbc:sqlserver://" + serverName +";databaseName=" + dbName;
			conn = DriverManager.getConnection(url, userID, password);
			if(conn !=  null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				return conn;
				}			
			} catch (SQLDataException ex) {
				ex.printStackTrace();
			} /*
				 * finally { try { if(conn != null && !conn.isClosed()) { conn.close(); } }
				 * catch (SQLException ex) { ex.printStackTrace(); } }
				 */
			return conn;	
	}
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}