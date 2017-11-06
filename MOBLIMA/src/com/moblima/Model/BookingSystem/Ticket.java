package com.moblima.Model.BookingSystem;

import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.Model.MovieSystem.Cinema;
import com.moblima.Model.MovieSystem.Cineplex;
import com.moblima.Model.MovieSystem.Movie;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ticket implements Serializable{

    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startTiming;
    private Cineplex cineplex;
    private Moviegoer moviegoer;

    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, LocalDateTime startTiming, Moviegoer moviegoer) {
        this.movie = movie;
        this.cinema = cinema;
        this.startTiming = startTiming;
        this.cineplex = cineplex;
        this.moviegoer = moviegoer;
    }

}
