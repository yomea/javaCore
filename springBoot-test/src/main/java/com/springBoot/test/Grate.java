package com.springBoot.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="grate")
public class Grate {
	
	private String g1;
	
	private String g2;

	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}

	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}
	
	
	
}
