package com.font;

import java.awt.GraphicsEnvironment;

public class SystemSupportFontFamily {
	
	
	public static void main(String[] args) {
		String[] fontNames  =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for (String string : fontNames) {
			System.out.println(string);
		}
		
	}

}
