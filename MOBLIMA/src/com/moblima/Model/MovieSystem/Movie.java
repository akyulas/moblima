package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents the movie in the movie system.
 */
public class Movie implements Serializable{

    /**
     * The name of the movie.
     */
    private String name;

    /**
     * The status of the movie.
     */
    private StatusType status;

    /**
     * The synopsis of the movie.
     */
    private String synopsis;

    /**
     * The director of the movie.
     */
    private String director;

    /**
     * The casts of the movie.
     */
    private ArrayList<String> casts;

    /**
     * The total rating of all the reviews for the movie.
     */
    private double totalRating;

    /**
     * The movie type of the movie.
     */
    private MovieType movieType;

    /**
     * The movie rating of the movie.
     */
    private MovieRating movieRating;

    /**
     * The reviews of the movie.
     */
    private ArrayList<Review> reviews;

    /**
     * The amount of ticket sold for the movie.
     */
    private int ticketSales;

    /**
     * The final date the movie will be shown.
     */
    private LocalDate endOfShowingDate;

    /**
     * The construction of the movie class.
     * @param name The name of the movie.
     * @param status The status of the movie.
     * @param synopsis The synopsis of the movie.
     * @param director The director of the movie.
     * @param movieType The movie type of the movie.
     * @param movieRating The movie rating of the movie.
     * @param casts The casts of the movie.
     * @param reviews The reviews of the movie.
     * @param endOfShowingDate The final date the movie will be shown.
     */
    public Movie(String name, StatusType status, String synopsis, String director, MovieType movieType, MovieRating movieRating, ArrayList<String> casts , ArrayList<Review> reviews, LocalDate endOfShowingDate) {
        this.name = name;
        this.status = status;
        this.synopsis = synopsis;
        this.casts = casts;
        this.director = director;
        this.totalRating = getRatingFromReviews(reviews);
        this.movieType = movieType;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.ticketSales = 0;
        this.endOfShowingDate = endOfShowingDate;
    }

    /**
     * The construction of the movie class.
     * @param name The name of the movie.
     * @param status The status of the movie.
     * @param synopsis The synopsis of the movie.
     * @param director The director of the movie.
     * @param movieType The movie type of the movie.
     * @param movieRating The movie rating of the movie.
     * @param casts The casts of the movie.
     * @param endOfShowingDate The final date the movie will be shown.
     */
    public Movie(String name, StatusType status, String synopsis, String director, MovieType movieType, MovieRating movieRating, ArrayList<String> casts , LocalDate endOfShowingDate) {
        this.name = name;
        this.status = status;
        this.synopsis = synopsis;
        this.casts = casts;
        this.director = director;
        this.totalRating = 0;
        this.movieType = movieType;
        this.movieRating = movieRating;
        this.reviews = new ArrayList<Review>();
        this.ticketSales = 0;
        this.endOfShowingDate = endOfShowingDate;
    }

    /**
     * Give the caller the name of the movie.
     * @return The name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Give the caller the status of the movie.
     * @return The status of the movie.
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Give the caller the synopsis of the movie.
     * @return The synopsis of the moive.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Give the caller the casts of the movie.
     * @return The casts of the movie.
     */
    public ArrayList<String> getCasts() {
        return casts;
    }

    /**
     * Give the caller the ratings of the movie.
     * @return The ratings of the movie.
     */
    public double getRating() {
        if (reviews.size() == 0)
            return -1;
        return totalRating / reviews.size();
    }

    /**
     * Give the caller the director of the movie.
     * @return The director of the movie.
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * Give the caller the movie type of the movie.
     * @return The movie type of the movie.
     */
    public MovieType getMovieType() {
        return movieType;
    }

    /**
     * Give the caller the reviews for the movie.
     * @return The reviews for the movie.
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    /**
     * Give the caller the number of reviews added for the movie.
     * @return The number of reviews added for the movie.
     */
    public int getNumberOfReviews() {
        return reviews.size();
    }

    /**
     * Give the caller the number of tickets sold for the movie.
     * @return The number of tickets sold for the movie.
     */
    public int getNumberOfTicketsSold() {
    	return ticketSales;
    }

    /**
     * Give the caller the movie rating of the movie.
     * @return The movie rating of the movie.
     */
    public MovieRating getMovieRating() {
    	return movieRating;
    }

    /**
     * Give the caller the final date the movie will be shown.
     * @return The final date the movie will be shown.
     */
    public LocalDate getEndOfShowingDate() {
        return endOfShowingDate;
    }

    /**
     * Set the name of the movie with the given name.
     * @param name The name of the movie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the status of the movie with the given status.
     * @param status The status of the movie.
     */
    public void setStatus(StatusType status) {
        this.status = status;
    }

    /**
     * Set the director of the movie with the given director.
     * @param directorName The director of the movie.
     */
    public void setDirector(String directorName) {
        this.director = directorName;
    }

    /**
     * Set the movie rating of the movie with the given movie rating.
     * @param movieRating The movie rating of the movie.
     */
    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    /**
     * Set the synopsis of the movie with the given synopsis.
     * @param synopsis The synopsis of the movie.
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Set the casts of the movie with the given casts.
     * @param casts The casts of the movie.
     */
    public void setCast(ArrayList<String> casts) {
        this.casts = casts;
    }

    /**
     * Set the final date the movie will be shown with the given final date.
     * @param time The final date the movie will be shown.
     */
    public void setEndOfShowingDate(LocalDate time) {
        this.endOfShowingDate = time;
    }

    /**
     * Adding a review to a movie.
     * @param review The review to be added.
     */
    public void addReview(Review review) {
        totalRating += review.getRating();
        reviews.add(review);
    }

    /**
     * Used to find out if a moviegoer has already added a review for the movie.
     * @param moviegoer The username of the moviegoer.
     * @return True if the user has already added a review. False if the user have not added a review.
     */
    public boolean hasMoviegoerAddedReview(String moviegoer) {
    	for (Review review: reviews) {
    		if (review.getUser().equals(moviegoer)) {
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Increase the number of tickets sold by 1.
     */
    public void increaseTicketSales() {
        ticketSales++;
    }

    /**
     * Remove the movie from the movie pool by changing the status to end of showing.
     */
    public void removeByChangingStatus() {
        setStatus(StatusType.END_OF_SHOWING);
    }

    /**
     * Get the total ratings from the number of reviews added.
     * @param reviews The reviews given for a movie.
     * @return The total ratings.
     */
    public double getRatingFromReviews(ArrayList<Review> reviews) {
        double total = 0.0;
        for (Review review: reviews) {
            total += review.getRating();
        }
        return total;
    }

    /**
     * The toString of the class.
     * @return The toString of the class.
     */
    public String toString() {
    	return name + "," + status;
    }



}
