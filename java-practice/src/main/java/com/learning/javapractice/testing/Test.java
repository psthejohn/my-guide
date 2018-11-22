package com.learning.javapractice.testing;

public class Test {
	int id;
	String name;

	public Test(int id, String n) {
		this.id = id;
		this.name = n;
	}

	public static void main(String[] args) {
		Test t1 = new Test(1, "abc");
		Test t2 = new Test(1, "");
		Test t3 = new Test(2, "");

		// System.out.println(t1.equals(t2));
		System.out.println("t1 hashcode is " + t1.hashCode());
		System.out.println("t2 hashcode is " + t2.hashCode());
		System.out.println("t3 hashcode is " + t3.hashCode());
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (this.getClass() == o.getClass()) {
			return true;
		}
		Test t = (Test) o;
		return id == t.id && name.equals(t.name);
	}

	@Override
	public int hashCode() {
		// return (int)id * name.hashCode();
		int hash = 7;
		hash = 31 * hash + id;
		hash = 31 * hash + (name == null ? 0 : name.hashCode());
		return hash;
	}

}
