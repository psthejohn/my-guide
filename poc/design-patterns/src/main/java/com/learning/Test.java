package com.learning;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		System.out.println(longestUniqueString("ajsgfsgfhask"));
	}

	public static String longestUniqueString(String s) {
		char[] ch = s.toCharArray();
		Set hs = new HashSet<>();
		int j = 0;
		int c = 0;
		int d = 0;
		for (int i = 0; i < ch.length; i++) {
			System.out.println(ch[i]);
			hs.add(ch[i]);
			if (hs.size() < 4) {
				c = c + 1;
				System.out.println("good to go");
			} else {
				System.out.println(c);
				c = 0;
				hs = new HashSet<>();
				j = j + 1;
				i = j;
				System.out.println("");
			}
		}
		return "";
	}
}
