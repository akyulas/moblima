package com.moblima.Model.MovieSystem;

import java.io.Serializable;

/**
 * This class represents the reviews in the movie system.
 */
public class Review implements Serializable{

    /**
     * The username of the moviegoer giving the review.
     */
    private final String user;
    /**
     * The rating given by the moviegoer giving the review.
     */
    private final double rating;
    /**
     * The comment given by the moviegoer giving the review.
     */
    private final String comment;

    /**
     * The constructor the review class.
     * @param user The username of the moviegoer giving the review.
     * @param rating The rating given by the moviegoer giving the review.
     * @param comment The comment given by the moviegoer giving the review.
     */
    public Review(String user, double rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    /**
     * Give the caller the username of the reviewer
     * @return The username of the reviewer.
     */
    public String getUser() {
        return user;
    }

    /**
     * Give the caller the rating given by the reviewer.
     * @return The rating given by the reviewer.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Give the caller the comment given the reviewer.
     * @return The comment given by the reviewer.
     */
    public String getComment() {
        return comment;
    }

}
