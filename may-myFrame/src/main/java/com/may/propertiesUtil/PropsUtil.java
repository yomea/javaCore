package com.may.propertiesUtil;

import java.io.IOException;
import java.util.Properties;

public class PropsUtil {
	
	private static Properties props;
	
	static {
		props = new Properties();
		
		try {
			props.load(PropsUtil.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getValue(String key) {
		String value = props.getProperty(key);
		return value;
	}
	

}
