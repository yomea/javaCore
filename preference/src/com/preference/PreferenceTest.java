package com.preference;

import java.util.prefs.Preferences;

/**
 * 偏好
 * @author may
 *
 */
public class PreferenceTest {

	public static void main(String[] args) {

		Preferences preference = Preferences.userNodeForPackage(PreferenceTest.class);// User
																						// Preference
																						// Node:
																						// /com/preference

		// Preferences preference1 =
		// Preferences.systemNodeForPackage(PreferenceTest.class);//System
		// Preference Node: /com/preference

		preference.put("hello", "world");

		int count = preference.getInt("count", 0);

		if (count == 0) {

			count++;

		}

		preference.putInt("count", count);

		System.out.println(preference.get("hello", null));

		System.out.println(preference.getInt("count", 0));

		/**
		 * world
		 *  1
		 */

	}

}
