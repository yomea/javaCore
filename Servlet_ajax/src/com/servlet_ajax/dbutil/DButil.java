package com.servlet_ajax.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servlet_ajax.entity.User;


public class DButil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/springBoot?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		
		
		try {
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public static <T> List<T> result(String sql, List<Object> params, Class<T> bean) {
		
		Connection connection = getConnection();
		
		List<T> list = new ArrayList<T>();
		
		int count = 0;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			for (Object param : params) {
				pstmt.setObject(++count, param);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			java.sql.ResultSetMetaData rmd = rs.getMetaData();
			
			int columnCount = rmd.getColumnCount();
			
			while(rs.next()) {
				T obj = bean.newInstance();
				for(int i = 0; i< columnCount; i++) {
					
					java.lang.String columnName = rmd.getColumnName(i+1);
					
					java.lang.reflect.Field field = bean.getDeclaredField(columnName);
					
					field.setAccessible(true);
					
					field.set(obj, rs.getObject(columnName));
					
				}
				list.add(obj);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add("hello");
		List<User> users = result("select * from user where username like '%' ? '%'", list, User.class);
		
		System.out.println(users);
	}
	

}
