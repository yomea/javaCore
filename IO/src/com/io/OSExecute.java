package com.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecute {

	public static void command(String command) throws IOException {
		Process process = new ProcessBuilder(command.split(" ")).start();

		BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
		
		BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream(), "utf-8"));
		
		String str = "";
		
		while((str = result.readLine()) != null) {
			System.out.println(str);
			
		}
		
		while((str = err.readLine()) != null) {
			System.err.println(str);
			
		}

	}
	
	public static void main(String[] args) throws IOException {
		command("CMD /C javap com.io.OSExecute");
	}

}
