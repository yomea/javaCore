package com.servlet_ajax.dao;

import java.util.List;

import com.servlet_ajax.entity.User;

public interface UserDao {
	
	List<User> search(String keyword);

}
