package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnect {

	public static Connection getConnection() throws SQLException {
		
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		return DriverManager.getConnection(jdbcURL);
	}
}
