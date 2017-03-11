package com.may.service.impl;

import com.may.annotation.Autowire;
import com.may.annotation.Service;
import com.may.annotation.Transaction;
import com.may.dao.UserDao;
import com.may.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowire
	private UserDao userDao = null;

	@Transaction
	@Override
	public void insert() {
		System.out.println("insert");
		
	}

	@Override
	public int update() {
		System.out.println("update");
		return 0;
		
		
	}

}
