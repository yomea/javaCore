package com.servlet_ajax.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet_ajax.entity.User;
import com.servlet_ajax.service.UserService;
import com.servlet_ajax.service.impl.UserServiceImpl;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = -9163609453220065009L;
	
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		
		Writer writer = resp.getWriter();
		
		if(keyword == null || keyword.trim().equals("")) {
			writer.write("{\"content\": null}");
			return ;
			
		}
		java.util.List<User> users = userService.search(keyword);
		
		if(users == null || users.size() == 0) {
			writer.write("{\"content\": null}");
			return ;
			
		}
		//{"content":["",""]}
		StringBuilder json = new StringBuilder("{\"content\":[");
		
		
		for (User user : users) {
			json.append("\"" + user.getUsername() + "\",");
		}
		json.deleteCharAt(json.length()-1);
		json.append("]}");
		System.out.println(json);
		writer.write(json.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
	

}
