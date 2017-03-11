package com.may.beanScale;

import java.util.ArrayList;
import java.util.List;

import com.may.classloader.MyClassLoader;
import com.may.fileUtil.FileUtil;

public class BeanScale {
	
	@SuppressWarnings("unused")
	private static final String CLASSPATH = BeanScale.class.getResource("/").getPath();
	
	
	
	public static List<Class<?>> scaleBean(String path, String basePackage) throws ClassNotFoundException {
		
		List<String> list = null;
		
		List<Class<?>> clazzs = new ArrayList<>();
		
		list = FileUtil.getFiles(path, basePackage);
		
		MyClassLoader classLoader = new MyClassLoader(path);
		
		for (String string : list) {
			
			int startPos = string.indexOf(path) + path.length();
			int endPos = string.indexOf(".class");
			string = string.substring(startPos, endPos).replaceAll("\\\\", ".");
			//System.out.println(string);
			clazzs.add(classLoader.findClass(string));
		}
		
		return clazzs;
	}
	
public static List<Class<?>> scaleBean(String path, String basePackage, ClassLoader classLoader) throws ClassNotFoundException {
		
		List<String> list = null;
		
		List<Class<?>> clazzs = new ArrayList<>();
		
		list = FileUtil.getFiles(path, basePackage);
		
	//	MyClassLoader classLoader = new MyClassLoader(path);
	//	classLoader.loadClass(name)
		
		for (String string : list) {
			
			int startPos = string.indexOf(path) + path.length();
			int endPos = string.indexOf(".class");
			string = string.substring(startPos, endPos).replaceAll("\\\\", ".");
			//System.out.println(string);
			clazzs.add(classLoader.loadClass(string));
		}
		
		return clazzs;
	}
	
	/*public static void main(String[] args) throws ClassNotFoundException {
		List<Class<?>> clazzs = BeanScale.scaleBean("","com.may.controller");
		
		System.out.println(clazzs.size());
		
		for (Class<?> class1 : clazzs) {
			System.out.println(class1.getSimpleName());
		}
	}
	*/

}
