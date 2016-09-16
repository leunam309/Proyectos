package crudConnect.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	
	private static final String _URL_JDBC = "jdbc:oracle:thin:spa/1@localhost:1521:XE";
	private static Connection con = null;
	
	
	public static Connection conectar() throws ClassNotFoundException, SQLException {
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		/*
		 * El formato de la url debe ser:
		 * 
		 * jdbc:oracle:thin:USER/PASS@HOST:PORT:SID
		 * 
		 * Por ejemplo:
		 * 
		 * jdbc:oracle:thin:HR/1@localhost:1521:XE
		 */
		con = null;

		con = DriverManager.getConnection(_URL_JDBC);

		return con;
	}
	
	
	public static void desconectar() throws SQLException {
		con.close();
	}
	
	
	
	
}
