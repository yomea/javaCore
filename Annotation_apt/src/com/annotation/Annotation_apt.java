package com.annotation;

import java.util.Objects;

@ExtractInterface("IAnnotation_apt")
public class Annotation_apt {
	
	public void print() {
		
		System.out.println("Annotation_apt...");
		
		boolean flag = Objects.equals("hello", "hello");
		
		System.out.println(flag);
		
	}
	

}
