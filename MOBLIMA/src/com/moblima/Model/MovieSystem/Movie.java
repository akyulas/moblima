package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable{

    private String name;
    private StatusType status;
    private String synopsis;
    private String director;
    private ArrayList<String> casts;
    private double rating;
    private MovieType movieType;
    private MovieRating movieRating;
    private ArrayList<Review> reviews;
    private ArrayList<Cinema> cinemas;
    private int ticketSales;

    public Movie(String name, StatusType status, String synopsis, String director, MovieType movieType, MovieRating movieRating, ArrayList<String> casts , ArrayList<Review> reviews) {
        this.name = name;
        this.status = status;
        this.synopsis = synopsis;
        this.casts = casts;
        this.director = director;
        this.rating = getRatingFromReviews(reviews);
        this.movieType = movieType;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.cinemas = new ArrayList<Cinema>();
        this.ticketSales = 0;
    }

    public String getName() {
        return name;
    }

    public StatusType getStatus() {
        return status;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public ArrayList<String> getCasts() {
        return casts;
    }

    public double getRating() {
        if (reviews.size() == 0)
            return -1;
        return rating;
    }

    public String getDirector() {
        return this.director;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public int getNumberOfReviews() {
        return reviews.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setCast(ArrayList<String> casts) {
        this.casts = casts;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public void addCast(String cast) {
        casts.add(cast);
    }

    public void removeCast(String cast) {
        if (casts.contains(cast))
            casts.remove(cast);
    }

    public void addReview(Review review) {
        double tempTotalRatings = rating * reviews.size();
        double tempRating = review.getRating();
        reviews.add(review);
        rating = (tempTotalRatings + tempRating) / reviews.size();
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void removeRating(Review review) {
        double tempTotalRatings = rating * reviews.size();
        double tempRating = review.getRating();
        if (reviews.contains(review)) {
            reviews.remove(review);
        }
        int size = reviews.size();
        if (size == 0) {
            rating = 0;
        } else {
            rating = (tempTotalRatings - tempRating) / size;
        }
    }

    public void removeCinema(Cinema cinema) {
        if (cinemas.contains(cinema)) {
            cinemas.remove(cinema);
        }
    }

    public void increaseTicketSales() {
        ticketSales++;
    }

    public void decreaseTicketSales() {
        ticketSales--;
    }
    
    public String toString() {
    	return name + "," + status;
    }

    public double getRatingFromReviews(ArrayList<Review> reviews) {
        double total = 0.0;
        for (Review review: reviews) {
            total += review.getRating();
        }
        return total / (double)reviews.size();
    }

}
