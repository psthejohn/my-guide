package com.learning.singleton;

public class TestLogger {
	public static void main(String[] args) {
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		// we will get diff outputs for both objects
		System.out.println(log1.hashCode());
		System.out.println(log2.hashCode());

	}
}
