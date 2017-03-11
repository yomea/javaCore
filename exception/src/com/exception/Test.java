package com.exception;

import java.util.Arrays;

public class Test {

	public static void print(int a) throws MyException {
		if (a == 0) {
			throw new MyException("不能为零");

		} else {

			System.out.println("success!!");

		}

	}

	public static void main(String[] args) throws MyException {

		// print(0);

		String s = "1    1     1";
		/**
		 * [, , ]
		 * 3
		 */
		System.out.println(Arrays.toString(s.split("1")));
		System.out.println(s.split("1").length);

	}

}
