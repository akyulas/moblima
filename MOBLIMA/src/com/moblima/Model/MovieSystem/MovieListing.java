package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MovieListing implements Serializable{

    private Cineplex cineplex;
    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;

    public MovieListing(Cineplex cineplex, Movie movie, Cinema cinema, LocalDateTime startingTime, LocalDateTime endingTime) {
        this.cineplex = cineplex;
        this.movie = movie;
        this.cinema = cinema;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public Cineplex getCineplex() {
        return this.cineplex;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public LocalDateTime getStartingTime() {
        return this.startingTime;
    }

    public LocalDateTime getEndingTime() {
        return this.endingTime;
    }

}
