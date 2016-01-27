package br.com.programafidelidade.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/programafidelidade?autoReconnect=true&useSSL=false", "root", "l1p3s4l3s");
		} catch (SQLException e) {
			
			throw new RuntimeException(e); 
		}
	}

}
