package com.servlet_ajax.service.impl;

import java.util.List;

import com.servlet_ajax.dao.UserDao;
import com.servlet_ajax.dao.impl.UserDaoImpl;
import com.servlet_ajax.entity.User;
import com.servlet_ajax.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> search(String keyword) {
		
		return userDao.search(keyword);
	}

}
