package com.may.controller;

import com.may.annotation.Controller;
import com.may.annotation.RequestMapper;

@Controller
@RequestMapper("/job")
public class JobController {
	
	@RequestMapper("/delete")
	public void delete() {
		
		
	}

}
