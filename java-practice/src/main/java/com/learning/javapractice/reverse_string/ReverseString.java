package com.learning.javapractice.reverse_string;

import java.util.Scanner;

public class ReverseString {
	
	
	public ReverseString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String userInput = takeUserInput();
		String output = reverseString(userInput);
		System.out.println(output);
	}

	public static String takeUserInput() {
		System.out.println("Input a string");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		System.out.println("user input is " + inputString);
		sc.close();
		return inputString;
	}

	public static String reverseString(String userInput) {
		// char[] charArray = userInput.toCharArray();
		// System.out.println(userInput.length());
		String output = "";
		for (int i = userInput.length(); i > 0; i--) {
			output += userInput.charAt(i - 1);
		}
		return output;
	}
}
