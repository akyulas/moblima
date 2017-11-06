package com.moblima.Model.BookingSystem;

import com.moblima.Model.MovieSystem.Cinema;
import com.moblima.Model.MovieSystem.Movie;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ticket implements Serializable{

    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startTiming;

    public Ticket(Movie movie, Cinema cinema, LocalDateTime startTiming) {
        this.movie = movie;
        this.cinema = cinema;
        this.startTiming = startTiming;
    }

}
