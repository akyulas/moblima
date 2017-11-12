package com.moblima.Model.MovieSystem;

/**
 * This enum represents the movie rating of a movie in the movie system.
 */
public enum MovieRating {
	/**
	 * PG
	 */
    PG(0),
	/**
	 * R18
	 */
	R18(18),
	/**
	 * PG13
	 */
	PG13(0),
	/**
	 * NC16
	 */
	NC16(16),
	/**
	 * R21
	 */
	R21(21);

	/**
	 * The minimum age that a movie goer needs to be to book to see this movie.
	 */
	private final int minimum_Age;

	/**
	 * The constructor of the movie rating class.
	 * @param age The minimum age of the movie goer.
	 */
	private MovieRating(int age) {
		minimum_Age = age;
	}

	/**
	 * Get the minimum age the movie goer has to be to book the movie.
	 * @return The minimum age the movie goer has to be to book the movie.
	 */
	public int getMinimumAge() {
		return minimum_Age;
	}
}
