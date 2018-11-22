package com.learning.javapractice.hashcodeequals;

public class HashCode_Equals {
	int id;
	String name;

	public HashCode_Equals(int id, String n) {
		this.id = id;
		this.name = n;
	}

	public static void main(String[] args) {
		HashCode_Equals t1 = new HashCode_Equals(1, "abc");
		HashCode_Equals t2 = new HashCode_Equals(1, "");
		HashCode_Equals t3 = new HashCode_Equals(2, "");

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
		HashcodeEquals t = (HashcodeEquals) o;
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
