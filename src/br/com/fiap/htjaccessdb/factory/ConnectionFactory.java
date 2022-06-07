package br.com.fiap.htjaccessdb.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String USERNAME = "RM92508";
	private static final String PASSWORD = "060697";
	private static final String DATABASE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	//"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92508", "060697"


	public static Connection createConnection() throws SQLException, Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		return connection; 
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Connection con = createConnection();
		
		if(con!=null) {
			System.out.println("Connected");
			con.close();
		}
	}
	
	
	
	}
