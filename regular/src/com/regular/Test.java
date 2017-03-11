package com.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String[] regex = { "^java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}", "s{0,3}" };
		String expression = "Java now has regular expressions";
		
		/*for (String string : regex) {
			Pattern pattern = Pattern.compile(string);
			Matcher matcher = pattern.matcher(expression);
			while(matcher.find()) {
				
				System.out.println(matcher.group(0));
				
			}
		}*/
		//Pattern pattern = Pattern.compile("\\w+\\s(java)$");
		Pattern pattern = Pattern.compile("hello java\\b");//hello java\\b\\s
		Matcher matcher = pattern.matcher("hello java ");
		/*while(matcher.find()) {
			
			System.out.println(matcher.group());
			
		}*/
		//false
		//true
		System.out.println(matcher.matches());//false//由于hello java 有个空格，所以不匹配，hello java\\b\\s才匹配
		System.out.println(matcher.lookingAt());//true//从头开始匹配，匹配第一个子串
		
	
	}

}
