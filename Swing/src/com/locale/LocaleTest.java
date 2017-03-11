package com.locale;

import java.text.Collator;
import java.util.Locale;

public class LocaleTest {
	
	public static void main(String[] args) {
		
		Locale[] locales  =Collator.getAvailableLocales();
		
		for (Locale locale : locales) {
			System.out.println(locale.getCountry() + "-->" + locale.getLanguage());
		}
		
	}

}
