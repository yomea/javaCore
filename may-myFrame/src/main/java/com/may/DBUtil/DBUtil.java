package com.may.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.may.propertiesUtil.PropsUtil;

public class DBUtil {
	
	private static final String URL = PropsUtil.getValue("jdbc.url");
	private static final String USERNAME = PropsUtil.getValue("jdbc.username");
	private static final String PASSWORD = PropsUtil.getValue("jdbc.password");
	private static final String CLASSNAME = PropsUtil.getValue("jdbc.driverClassName");
	
	static {
		
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if(connection != null) {
				connection.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	

}
