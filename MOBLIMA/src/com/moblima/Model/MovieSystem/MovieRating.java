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
	R18(3),
	/**
	 * PG13
	 */
	PG13(0),
	/**
	 * NC16
	 */
	NC16(2),
	/**
	 * R21
	 */
	R21(4);

	/**
	 * The minimum age group that a movie goer needs to belong to book to see this movie.
	 */
	private final int minimum_AgeGroup;

	/**
	 * The constructor of the movie rating class.
	 * @param ageGroup The minimum age group of the movie goer.
	 */
	private MovieRating(int ageGroup) {
		minimum_AgeGroup = ageGroup;
	}

	/**
	 * Get the minimum age group the movie goer has to belong to book the movie.
	 * @return The minimum age group the movie goer has to belong to book the movie.
	 */
	public int getMinimumAgeGroup() {
		return minimum_AgeGroup;
	}
}
