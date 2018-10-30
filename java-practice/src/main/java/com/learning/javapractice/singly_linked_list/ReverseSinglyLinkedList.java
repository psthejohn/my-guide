package com.learning.javapractice.singly_linked_list;

public class ReverseSinglyLinkedList<T> {

	private Node<T> head;

	public void add(T element) {
		Node<T> node = new Node<T>();
		node.setValue(element);
		System.out.println("Adding : " + element);
		Node<T> temp = head;
		while (true) {
			if (temp == null) {
				head = node;
				break;
			} else if (temp.getNextRef() == null) {
				temp.setNextRef(node);
				break;
			} else {
				temp = temp.getNextRef();
			}
		}
	}

	public void traverse() {
		Node<T> temp = head;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp.getValue() + "\t");
			temp = temp.getNextRef();
		}
	}

	public void reverse() {

		System.out.println("\nreversing the linked list\n");
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		while (current != null) {
			next = current.getNextRef();
			current.setNextRef(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}
}
