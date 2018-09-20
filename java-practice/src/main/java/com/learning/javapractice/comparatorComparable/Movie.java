package com.learning.javapractice.comparatorComparable;

public class Movie implements Comparable<Movie> {

	private String name;
	private int year;
	private double rating;

	public Movie() {

	}

	public Movie(String name, double rating, int year) {
		super();
		this.name = name;
		this.rating = rating;
		this.year = year;

	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", year=" + year + ", rating=" + rating + "]";
	}

	// used to sort movies by year
	public int compareTo(Movie m) {
		return this.year - m.year;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public double getRating() {
		return rating;
	}

}
