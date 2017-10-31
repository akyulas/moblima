package com.moblima.BookingSystem;

import com.moblima.MovieSystem.Cinema;
import com.moblima.MovieSystem.Movie;

import java.util.ArrayList;

public class MovieList {

    private Movie movie;
    private ArrayList<Cinema> cinemas;


    public MovieList(Movie movie) {
        this.movie = movie;
        cinemas = new ArrayList<Cinema>();
    }

    public MovieList(Movie movie, ArrayList<Cinema> cinemas) {
        this.movie = movie;
        this.cinemas = cinemas;
    }


    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void removeCinema(Cinema cinema) {
        cinemas.remove(cinema);
    }

}
