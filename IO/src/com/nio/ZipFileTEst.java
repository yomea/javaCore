package com.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.concurrent.SynchronousQueue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipFileTEst {
	
	
	public static void main(String[] args) throws Exception {
		
		
		FileOutputStream out = new FileOutputStream("src/test.zip");
		
		ZipOutputStream zipOut = new ZipOutputStream(out, Charset.forName("utf-8"));
		
		BufferedOutputStream bout = new BufferedOutputStream(zipOut);
		
		File hello = new File("src/hello.txt");
		
		File world = new File("src/world.txt");
		
		File[] files = new File[]{hello, world};
		
		FileInputStream in_1 = new FileInputStream(hello);
		
		FileInputStream in_2 = new FileInputStream(world);
		
		BufferedInputStream bin_1 = new BufferedInputStream(in_1);
		
		BufferedInputStream bin_2 = new BufferedInputStream(in_2);
		
		
		BufferedInputStream[] bis = new BufferedInputStream[]{bin_1, bin_2};
		zipOut.setComment("test zip");
		
		byte[] buff = new byte[1024];
		
		int i = 0;
		
		for (BufferedInputStream b : bis) {
			zipOut.putNextEntry(new ZipEntry(files[i++].getName()));
			while((b.read(buff)) != -1) {
				
				bout.write(buff);
				
				bout.flush();
				
			}
			
			
		}
		
		ZipFile zipFile = new ZipFile(new File("src/test.zip"));
		
		Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
		
		while(zipEntries.hasMoreElements()) {
			
			ZipEntry zipEntry = zipEntries.nextElement();
			
			InputStream inputStream = zipFile.getInputStream(zipEntry);
			
			byte[] b = new byte[1024];
			
			while((inputStream.read(b)) != -1) {
				
				System.out.println(new String(b));
			}
			
		}
		
		
		bout.close();
		bin_1.close();
		bin_2.close();
		//...
		
	}
	

}
