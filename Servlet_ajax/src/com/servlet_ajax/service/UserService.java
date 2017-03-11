package com.servlet_ajax.service;

import java.util.List;

import com.servlet_ajax.entity.User;

public interface UserService {
	
	List<User> search(String keyword);

}
