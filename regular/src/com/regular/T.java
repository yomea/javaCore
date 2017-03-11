package com.regular;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T {
	
	public static void main(String[] args) {
		//多行匹配模（会把每行单独拿出来进行匹配）式,否则看成一个整的字符串，忽略大小写
		//(?m)(?i)
		Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE  | Pattern.MULTILINE);
		String s = "java has regex\njava has regex\n"
+ "JAVA has pretty good regular expressions\n" +
				"Regular expressions are in java";
		Matcher m = p.matcher(
				s
				);
		System.out.println(Arrays.toString(Pattern.compile("\\s").split(s)));
		StringBuffer sb = new StringBuffer("");
		while(m.find()) {
			//System.out.println(m.group());
			System.out.println("?????????????????????????????????????????????????????");
			System.out.println(m.start() + "-->" + m.end());
			//拼接所有路过的字符，参数二只是将匹配到的字符进行替换
			m.appendReplacement(sb, m.group().toUpperCase());
			
			System.out.println(sb.toString());
		}
		//m.reset();将当前检索的位置重置为零
		//m.reset(input)将当前用于检测的改为新的字符创
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		m.appendTail(sb);//将剩下的没有经过的字符拼接到sb中。
		//System.out.println(sb.toString());
	}

}
