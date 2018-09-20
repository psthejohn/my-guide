package com.learning.javapractice.comparatorComparable;

import java.util.ArrayList;
import java.util.Collections;

public class TestComparator {

	public static void main(String[] args) {

		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		// Sort by rating : (1) Create an object of ratingCompare
		// (2) Call Collections.sort
		// (3) Print Sorted list

		System.out.println("start sorting by rating");
		RatingCompare rc = new RatingCompare();
		Collections.sort(list, rc);
		System.out.println("after compare " + list);

		System.out.println("started sort by name");
		NameCompare nc = new NameCompare();
		Collections.sort(list, nc);
		System.out.println("list after sorting by name " + list);
		
	}
}
