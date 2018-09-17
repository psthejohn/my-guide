package com.learning.javapractice.hashcodeequals;

public class Test {

	public static void main(String[] args) {
		HashcodeEquals heq = new HashcodeEquals("abc", 1);
		HashcodeEquals heq1 = new HashcodeEquals("abc", 1);
		System.out.println(heq1.hashCode());
		System.out.println(heq.hashCode());

		if (heq.hashCode() == heq1.hashCode()) {
			if (heq.equals(heq1)) {
				System.out.println("both are equal");
			} else {
				System.out.println("both are not equal");
			}
		} else {
			System.out.println("both are not equal");
		}

	}
}
