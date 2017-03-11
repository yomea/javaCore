package com.may.connectPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.may.DBUtil.DBUtil;

public class ConnectPool {
	//初始化大小
	private static final int INI_SIZE = 10;
	//最大连接数
	private static final int MAX_SIZE = 15;
	//记录当前是否繁忙，繁忙时增加五个连接
	private static AtomicInteger count = new AtomicInteger(0);
	//是否为繁忙
	private static AtomicBoolean isAdd = new AtomicBoolean(false);
	
	
	
	private static final List<Connection> CONNECTS = Collections.synchronizedList(new ArrayList<Connection>());
	
	static {
		for(int i = 0; i < INI_SIZE; i++) {
			
			CONNECTS.add(DBUtil.getConnection());
			count.incrementAndGet();
		}
		
	}
	
	public static Connection getConnect() {
		Connection connection = null;
		if(CONNECTS.size() > 0) {
			connection = CONNECTS.remove(0);
		} else {
			if(count.get() <= 10) {
				isAdd.set(true);
				for(int i = 0; i < MAX_SIZE - INI_SIZE; i++) {
					
					CONNECTS.add(DBUtil.getConnection());
					count.incrementAndGet();
				}
				
				connection = CONNECTS.remove(0);
				
			} else {
				while(CONNECTS.size() < 1) {
					
					try {
						Thread.sleep(500);//等候500ms
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				connection = CONNECTS.remove(0);
			}
			
			
			
			
		}
		
		return connection;
	}
	
	public static void close(Connection connection) {
		
		CONNECTS.add(connection);
		
		if(isAdd.get()) {
			if(CONNECTS.size() > 8) {
				for(int i = 0; i < MAX_SIZE - INI_SIZE; i++) {
					
					CONNECTS.remove(0);
					count.decrementAndGet();
				}
				isAdd.set(Boolean.FALSE);
				
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		/*for (int i = 0; i < 14; i++) {
			ConnectPool.getConnect();
		}
		
	//	System.out.println(connection.getMetaData().getMaxTableNameLength());
		
		new Thread() {
			
			@Override
			public void run() {
				
			Connection connection = ConnectPool.getConnect();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("释放链接。。。");
			
			ConnectPool.close(connection);
			
			System.out.println("当前链接池还剩下"  + CONNECTS.size()  + "个链接、、、、、");
				
			};
			
		}.start();
		System.out.println("正在获取链接。。。");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		ConnectPool.getConnect();
		System.out.println("已经获取链接。。。");
		System.out.println("当前链接池还剩下"  + CONNECTS.size()  + "个链接");*/
		
		List<Connection> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			list.add(ConnectPool.getConnect());
		}
		
		for (int i = 0; i < 9; i++) {
			
			if(i == 8) {
				System.out.println("当前释放的链接数" + CONNECTS.size());
				
			}
			
			ConnectPool.close(list.remove(0));
			
			
		}
		System.out.println("当前释放的链接数" + CONNECTS.size());
		
		
		
	}
	
	

}
