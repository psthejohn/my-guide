package com.learning.javapractice.testing;

import static org.hamcrest.CoreMatchers.instanceOf;

public class HashEquals {

	private String name;
	private int age;
	private int id;

	public HashEquals() {

	}

	public HashEquals(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public int hashCode() {
		return this.id;
	}

	public boolean equals(Object obj) {

		if (this == obj) {
			System.out.println("this == obj");
			return true;
		}
		if (!(obj instanceof HashEquals)) {
			System.out.println("obj instanceof HashEquals");
			return false;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			System.out.println("obj == null || obj.getClass() != this.getClass()");
			return false;
		}

		HashEquals heq = (HashEquals) obj;
		if (heq.getAge() == this.getAge() && heq.getId() == this.getId() && heq.getName() == this.getName()) {
			System.out.println("this is true 2");
			return true;
		}
		return false;
	}
}
