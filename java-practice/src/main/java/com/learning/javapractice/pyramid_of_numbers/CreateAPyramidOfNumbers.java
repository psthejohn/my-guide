package com.learning.javapractice.pyramid_of_numbers;

import java.util.Scanner;

public class CreateAPyramidOfNumbers {

	public static void main(String[] args) {
		int num = takeUserInput();
		createPyramidOfNumbers(num);
	}

	public static int takeUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter any number");
		int num = sc.nextInt();
		sc.close();
		return num;
	}

	public static void createPyramidOfNumbers(int num) {

		int rowCount = 1;

		for (int i = num; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= rowCount; j++) {
				System.out.print(rowCount + " ");
			}
			System.out.println();
			rowCount++;
		}
	}
}
