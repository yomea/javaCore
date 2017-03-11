package com.may.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

	private String rootPath = "";

	private FileInputStream in = null;

	private ByteArrayOutputStream out = null;

	public MyClassLoader() {
	};

	public MyClassLoader(String rootPath) {
		this.rootPath = rootPath;
		//System.out.println(rootPath);
	}

	public Class<?> findClass(String name) throws ClassNotFoundException {

		Class<?> clazz = null;
		String path = "";
		try {
			path = rootPath + name.replaceAll("\\.", "/") + ".class";
			//System.out.println(path);

			File file = new File(path);

			if (!file.exists()) {
				throw new ClassNotFoundException("所加载的类没有找到");
			}

			in = new FileInputStream(file);

			out = new ByteArrayOutputStream();

			byte[] buff = new byte[1024];

			int len = 0;

			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}

			buff = out.toByteArray();

			clazz = this.defineClass(name, buff, 0, buff.length);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return clazz;
	}

	/*public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader classLoader = new MyClassLoader(MyClassLoader.class.getResource("/").getPath());
		Class<?> clazz = classLoader
				.findClass("com.may.annotation.Autowire");
		System.out.println(clazz.getSimpleName());
	}*/

}
