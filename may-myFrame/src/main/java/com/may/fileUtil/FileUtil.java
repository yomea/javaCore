package com.may.fileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件扫描助手
 * 
 * @author may
 *
 */
public class FileUtil {

	public static List<String> getFiles(String basePath, String className) throws ClassNotFoundException {
		String pathName = basePath + className.replaceAll("\\.", "/");
		//System.out.println(pathName);
		//System.exit(0);
		File file = new File(pathName);
		if (!file.exists()) {
			throw new ClassNotFoundException("文件类未找到，请确认你的配置");
		}
		List<String> files = new ArrayList<String>();
		scaleClassFile(file, files);
		return files;
	}

	public static void scaleClassFile(File file, List<String> filesPath) {

		if (file.isDirectory()) {
			File[] files =  file.listFiles();
			for (File file2 : files) {
				scaleClassFile(file2, filesPath);
			}
			
		} else if (file.isFile() && file.getAbsolutePath().endsWith(".class")) {
			filesPath.add(file.getAbsolutePath());
		}
	}

	/*public static void main(String[] args) throws ClassNotFoundException {
		List<String> files = FileUtil.getFiles(FileUtil.class.getResource("/").getPath(), "com.may");
		System.out.println(files.size());
		for (String string : files) {
			System.out.println(string);
		}
	}*/

}
