package com.springBoot.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
	
	@GetMapping("/")//@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		
		return "index";
	}

}
