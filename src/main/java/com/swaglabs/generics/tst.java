package com.swaglabs.generics;

import java.util.Random;

import org.apache.poi.util.SystemOutLogger;

public class tst {
	
	public static String getRandomNumber(int i) {   // method to generate random postalcode
		int j =0;
		String randomstring = "1234567890";
		String string = "";
		Random rnd = new Random();
		while (j < i) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomstring.length());
			string= string+(randomstring.charAt(index));
			j++;
		}
		return string;

		
	}
	
	public static String getRandomString(int i) {   // method to generate random postalcode
		int j =0;
		String randomstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String string = "";
		Random rnd = new Random();
		while (j < i) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomstring.length());
			string= string+(randomstring.charAt(index));
			j++;
		}
		return string;

	}

	public static void main(String[] args) {

        Random rnd = new Random();
System.out.println(getRandomNumber(5));
System.out.println(getRandomNumber(5));
System.out.println(getRandomString(5));
System.out.println(getRandomString(5));
		
	}

}
