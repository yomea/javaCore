package com.may.proxy;

public class H implements HHee {

	@Override
	public String hh(int a, int b) {
		System.out.println(a + "-->" + b);
		return a + "-->" + b;
	}

	@Override
	public String hh(String a) {
		System.out.println(a);
		return a;
	}
	

}
