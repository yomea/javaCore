package com.servlet_ajax.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.servlet_ajax.dao.UserDao;
import com.servlet_ajax.dbutil.DButil;
import com.servlet_ajax.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> search(String keyword) {
		
		String sql = "select username from user where username like '%' ? '%'";
		
		List<Object> obj = new ArrayList<Object>();
		
		obj.add(keyword);
		
		java.util.List<User> users = DButil.result(sql, obj, User.class);
		return users;
	}

	public static void main(String[] args) {
		java.util.List<User> users = new UserDaoImpl().search("l");
		
		System.out.println(users);
	}
	
}
