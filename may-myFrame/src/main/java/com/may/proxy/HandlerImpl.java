package com.may.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;

import com.may.connectPool.ConnectPool;
import com.may.jdbcUtil.JdbcUtil;

public class HandlerImpl implements MyHandler {
	
	private Object target;
	
	public HandlerImpl(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		JdbcUtil jdbc = JdbcUtil.newInstance();
		Connection connection = ConnectPool.getConnect();
		connection.setAutoCommit(false);
		jdbc.setConnection(connection);
		Object obj = null;
		try{
			obj = method.invoke(target, args);
			
		} catch(Throwable e) {
			
			connection.rollback();
			
			throw new Throwable();
		} finally {
			connection.commit();
		}
		
		
		return obj;
	}

}
