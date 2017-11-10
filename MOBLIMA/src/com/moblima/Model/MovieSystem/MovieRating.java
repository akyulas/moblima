package com.moblima.Model.MovieSystem;

public enum MovieRating {
    PG(0), R18(18), PG13(0), NC16(16), R21(21);
	
	private final int minimum_Age;
	
	private MovieRating(int age) {
		minimum_Age = age;
	}
	
	public int getMinimumAge() {
		return minimum_Age;
	}
}
