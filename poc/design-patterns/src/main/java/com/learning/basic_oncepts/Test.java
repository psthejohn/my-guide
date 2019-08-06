package com.learning.basic_oncepts;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A c = new B();

		a.run();
		b.run();
		c.run();

	}
}
