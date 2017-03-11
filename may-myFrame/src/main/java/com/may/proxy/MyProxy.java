package com.may.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MyProxy {

	private static final String CL = "\r\t";
	
	private static final Map<String, String>basic = new HashMap<>();
	
	static {
		basic.put("int", "0");
		
		basic.put("byte", "0");
		
		basic.put("short", "0");
		
		basic.put("long", "0L");
		
		basic.put("float", "0.0f");
		
		basic.put("double", "0.0d");
		
		basic.put("char", "'0'");
		
	}

	public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, MyHandler handler) {
		Object obj = null;
		StringBuilder str = new StringBuilder("package com.may.temp;" + CL + "import java.lang.reflect.Method;" + CL
				+ "import com.may.proxy.MyHandler; " + CL + " public class $proxy implements ");
		StringBuilder methodStr = new StringBuilder();
		FileWriter writer = null;
		URLClassLoader url = null;
		
		

		for (Class<?> clazz : interfaces) {
			String interfaceName = clazz.getName();
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				
				StringBuilder parameterStr = new StringBuilder();
				methodStr.append("@Override" + CL + "public ");
				methodStr.append(method.getReturnType().getName() + " " + method.getName() + "(");
				int arg = 0;
				// int start = methodStr.length() - 1;

				for (Class<?> c : method.getParameterTypes()) {
					methodStr.append(c.getName() + " arg" + arg + ",");
					arg++;

				}
				if (arg > 0) {
					if (methodStr.length() > 0) {
						methodStr.deleteCharAt(methodStr.length() - 1);

					}

				}
				for (int i = 0; i < arg; i++) {
					parameterStr.append("arg" + i + ",");

				}
				if (parameterStr.length() > 0) {
					parameterStr.deleteCharAt(parameterStr.length() - 1);

				}
				// int end = methodStr.length() - 1;
				methodStr.append(")" + " {" + CL);

	//			System.out.println(method.getReturnType().getName());
				
				methodStr.append(method.getReturnType().getName().equals("void") ? ""
						: method.getReturnType() + " returnValue = " + basic.get(method.getReturnType().getName()) + ";" + CL);

				methodStr.append("Method[] methods = " + interfaceName + ".class.getDeclaredMethods();" + CL);

				methodStr.append("Method m = null;" + CL);

				methodStr.append("for(Method method : methods) {" + CL);

				methodStr.append("if(method.toString().equals(\"" + method.toString() + "\")) {");

				methodStr.append("m = method;" + CL + "}" + CL + "}" + CL);
				methodStr.append("try {" + CL);
				methodStr.append((method.getReturnType().getName().equals("void") ? ""
						: "returnValue = ")
								+ (method.getReturnType().getName().equals("void") ? ""
										: "(" + method.getReturnType().getName() + ")")
								+ "this.handler.invoke(this, m, new Object[] {" + parameterStr + "});" + CL);
				methodStr.append("} catch(Throwable e) {" + CL);
				methodStr.append("e.printStackTrace();}" + CL);
				methodStr.append((method.getReturnType().getName().equals("void") ? "" : "return returnValue;"));
				methodStr.append("}" + CL);
			}
			str.append(interfaceName + ",");
		}
		if (str.length() > 0) {
			str.deleteCharAt(str.length() - 1);

		}

		str.append("{" + CL);

		str.append("private MyHandler handler;" + CL);

		str.append("public $proxy (MyHandler handler) { " + CL);

		str.append("this.handler = handler;" + CL + "}");

		str.append(CL + methodStr + CL + "}");
		try {
			File file = new File(MyProxy.class.getResource("/").getPath() + "com/may/temp/", "$proxy.java");

			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} else {
				file.deleteOnExit();

			}


			writer = new FileWriter(file);

			writer.write(str.toString());
			writer.flush();

			// System.out.println(MyProxy.class.getResource("/").getPath());

			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			// System.out.println(compiler);
			StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> units = fileMgr.getJavaFileObjects(file);
			CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
			t.call();

			fileMgr.close();

			// load to 内存,定义加载路径
	//		URL[] urls = new URL[] { new URL(MyProxy.class.getResource("/").toString()) };// 读取文件应当使用file文件协议
		//	url = new URLClassLoader(urls);

	//		System.err.println(url.getURLs()[0]);
	//		Class<?> c = url.loadClass("com.may.temp.$proxy");
			
			Class<?> c = loader.loadClass("com.may.temp.$proxy");

			obj = c.getConstructor(MyHandler.class).newInstance(handler);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return obj;
	}
	
	/*public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		System.out.println(double.class);
	}*/

}
