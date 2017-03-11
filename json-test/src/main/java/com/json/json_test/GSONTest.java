package com.json.json_test;

import java.io.File;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONTest {

	public static void main(String[] args) throws Exception {

		jsonToBean();
		// test_2();

	}

	public static void jsonToBean() throws Exception {
		File file = new File(GSONTest.class.getResource("/User.json").toURI());
		
		String json = FileUtils.readFileToString(file, "utf-8");
		
		Gson gson = new Gson();
		
		User user = gson.fromJson(json, User.class);
		
		System.out.println(json);
		
		System.out.println(user);
	}

	public static void test_1() {

		User user = new User();

		user.setUsername("youth");

		user.setWeight(105);

		user.setAge(23);

		GsonBuilder gb = new GsonBuilder();

		gb.setPrettyPrinting();// 将以缩进的方式进行格式化输出
		
		gb.setDateFormat("yyyy-MM-dd");//设置时间显示的格式

		// 设置字段名字生成的策略，当然可以使用注解@SerializedName("体重")设置
		gb.setFieldNamingStrategy(new FieldNamingStrategy() {

			public String translateName(Field arg0) {
				if (arg0.getName().equals("weight")) {

					return "体重";
				}
				return arg0.getName();
			}

		});

		Gson gson = gb.create();

		String json = gson.toJson(user);

		System.out.println(json);
	}

	public static void test_2() {

		User user = new User();

		user.setUsername("youth");

		user.setWeight(105);

		user.setAge(23);

		Gson gson = new Gson();

		String json = gson.toJson(user);

		System.out.println(json);
	}

}
