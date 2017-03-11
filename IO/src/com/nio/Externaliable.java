package com.nio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
/**
 * Externaliable序列化
 * @author may
 *
 */
public class Externaliable {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		User user = new User("hong", 23);

		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(user);

		oos.close();

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

		ObjectInputStream ois = new ObjectInputStream(bis);

		User u = (User) ois.readObject();

		ois.close();
		/**
		 * writeExternal
		 *  readExternal 
		 *  User [username=youth, age=22]
		 */
		
		TimeUnit.SECONDS.sleep(1);
		System.out.println(u);
	}

}
