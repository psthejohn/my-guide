package com.learning.javapractice.hashcodeequals;

public class HashcodeEquals {
	public String name;
	public int id;

	public HashcodeEquals() {

	}

	public HashcodeEquals(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// checking if both the object references are referring to the same object.
		if (this == obj) {
			return true;
		}
		// it checks if the argument is of the type HashcodeEquals
		// by comparing the classes
		// of the passed argument and this object.

		if (!(obj instanceof HashcodeEquals)) {
			return false;
		}

		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		HashcodeEquals heq = (HashcodeEquals) obj;
		// comparing the state of argument with
		// the state of 'this' Object.
		if (heq.name == this.name && heq.id == this.id) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// We are returning the HashcodeEquals id as a hashcode value.
		// we can also return some other calculated value or may
		// be memory address of the Object on which it is invoked.
		// it depends on how we implement hashCode() method.
		return this.id;
	}

	@Override
	public String toString() {
		return "HashcodeEquals [name=" + name + ", id=" + id + "]";
	}

}
