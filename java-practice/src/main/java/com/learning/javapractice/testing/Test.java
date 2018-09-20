package com.learning.javapractice.testing;

public class Test {

	public static void main(String[] args) {

		HashEquals heq1 = new HashEquals("abc", 21, 1);
		HashEquals heq2 = new HashEquals("abc", 21, 1);

		System.out.println(heq1.hashCode() == heq2.hashCode());
		System.out.println(heq1.equals(heq2));
	}
}
