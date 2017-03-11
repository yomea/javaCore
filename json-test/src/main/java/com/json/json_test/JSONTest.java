package com.json.json_test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) throws Exception {

		/*
		 * JSONTest.jsonObject(); createByMap();
		 */
	}

	public static void createByFile() throws URISyntaxException, JSONException, IOException {
		File file = new File(JSONTest.class.getResource("/User.json").toURI());

		JSONObject jo = new JSONObject(FileUtils.readFileToString(file));

		System.out.println(jo);
		System.out.println(jo.getString("username"));
		System.out.println(jo.getString("age"));

	}

	public static void jsonObject() throws JSONException {

		JSONObject jo = new JSONObject();

		Object obj = null;

		jo.put("username", "youth");

		jo.put("age", 23);

		List<String> hobbys = new ArrayList<String>();

		hobbys.add("java");

		hobbys.add("javaScript");

		hobbys.add("jsp");

		jo.put("hobby", hobbys);

		jo.put("has_girlfriend", obj);// 为null值得不会加进去

		// {"age":23,"username":"youth","hobby":["java","javaScript","jsp"]}
		System.out.println(jo.toString());

	}
	
	
	
	public static void createByMap() throws JSONException {

		Map<String, Object> jo = new HashMap<String, Object>();

		Object obj = null;

		jo.put("username", "youth");

		jo.put("age", 23);

		List<String> hobbys = new ArrayList<String>();

		hobbys.add("java");

		hobbys.add("javaScript");

		hobbys.add("jsp");

		jo.put("hobby", hobbys);

		jo.put("has_girlfriend", obj);

		System.out.println(new JSONObject(jo));

		System.out.println(new JSONObject(jo).getJSONArray("hobby"));

		System.out.println((new JSONObject(jo).isNull("Nickname")));

	}

}
