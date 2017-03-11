package com.may.jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcUtil {
	
	//private static JdbcUtil JDBC= null;
	private Connection connection = null;
	
	private JdbcUtil() {
		/*if(JDBC != null) {
			throw new RuntimeException("重复实例化JdbcUtil");
		}*/
		
	}
	
	/*private static class JdbcUtilBuilder {
		
		private static JdbcUtil jdbc = new JdbcUtil();
		
	}*/
	
	
	
	public static JdbcUtil newInstance() {
		
		/*if(JDBC == null) {
			
			JDBC = JdbcUtilBuilder.jdbc;
		}*/
		
		
		return new JdbcUtil();
	}
	
	
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public int update(String sql, List<Object> args) throws SQLException {
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		for(int i = 0; i < args.size(); i++) {
			pstmt.setObject(i + 1, args.get(i));
			
		}
		
		pstmt.executeUpdate();
		
		
		
		
		return 0;
	}
	
	

}
