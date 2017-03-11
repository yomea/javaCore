package com._enum;

enum Color {RED, BLACK, YELLO, GREEN}

public class EnumTest {
	
	public static void main(String[] args) {
		
		for (Color color : Color.values()) {
			System.out.println(color + "-->" + color.ordinal());
			System.out.println(color.getDeclaringClass());
		}
		
	}
	

}
