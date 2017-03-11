package com.nio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User implements Externalizable {
	
	private String username = "youth";
	
	private int age = 22;
	//必须存在无参构造器，且是public的，因为read的时候会自动new这个构造器，如果实现的是serialize就不需要
	public User() {
		
	}
	
	public User(String username, int age) {
		
		this.username = username;
		this.age = age;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		//System.out.println("writeExternal");
		out.writeObject(username);
		out.writeInt(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		//System.out.println("readExternal");
		//这里对应writeExternal的写入顺序拿出
		username = (String) in.readObject();
		age = in.readInt();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}
	
	

}
