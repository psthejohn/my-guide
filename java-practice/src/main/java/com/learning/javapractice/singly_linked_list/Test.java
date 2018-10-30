package com.learning.javapractice.singly_linked_list;

public class Test {

	public static void main(String args[]) {

		ReverseSinglyLinkedList<Integer> sl = new ReverseSinglyLinkedList<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		System.out.println();
		sl.traverse();
		System.out.println();
		sl.reverse();
		sl.traverse();
	}
}
