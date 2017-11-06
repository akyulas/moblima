package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cineplex implements Serializable{

    private ArrayList<Cinema> cinemas;
    private String name;
    private ArrayList<MovieListing> movieListings;

    public Cineplex(String name) {
        this.name = name;
        cinemas = new ArrayList<Cinema>();
        movieListings = new  ArrayList<MovieListing>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public void setName() {
        this.name = name;
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void removeCinema(Cinema cinema) {
        if (cinemas.contains(cinema))
            cinemas.remove(cinema);
    }

    public boolean addMovie(Movie movie, Cinema cinema, LocalDateTime startTiming, LocalDateTime endTiming) {
        if (!cinema.checkIfOccupied(startTiming, endTiming)) {
            movieListings.add(new MovieListing(this, movie, cinema, startTiming, endTiming));
            return true;
        }
        return false;
    }

    public ArrayList<MovieListing> getMovieListing() {
        return movieListings;
    }
   

}
