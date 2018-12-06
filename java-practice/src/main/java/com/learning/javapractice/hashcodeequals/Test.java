package com.learning.javapractice.hashcodeequals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private final static Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		logger.info("inside the main");

		HashcodeEquals heq = new HashcodeEquals("abc", 1);
		logger.info("printing the value of heq " + heq);
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
