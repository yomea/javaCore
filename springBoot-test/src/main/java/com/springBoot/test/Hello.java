package com.springBoot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller @ResponseBody
public class Hello {
	
	@Autowired(required=false)
	private Grate grate;
	
	//@Value(value="${grate}")
	private String _grate;
	
	@RequestMapping(value="/Chinese", method=RequestMethod.GET)
	public String sayHello_1() {
		
		
		return grate.getG1() + "-->" + grate.getG2();
	}
	
	
	@RequestMapping(value="/English", method=RequestMethod.GET)
	public String sayHello_2() {
		
		
		return _grate;
	}

}
