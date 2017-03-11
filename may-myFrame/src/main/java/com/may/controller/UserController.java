package com.may.controller;

import com.may.annotation.Autowire;
import com.may.annotation.Controller;
import com.may.annotation.RequestMapper;
import com.may.annotation.RespondBody;
import com.may.service.UserService;
import com.may.test.User;

@Controller
@RequestMapper("/user")
public class UserController {
	
	@Autowire
	private UserService userService;

	@RequestMapper("/insert")
	@RespondBody
	public User insert() {
		userService.insert();
		//return "/WEB-INF/jsp/index.jsp";
		return new User(1, "admin", "youth");
	}
	
	@RequestMapper("/update")
	public String update() {
		
		return "/WEB-INF/jsp/index.jsp";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
