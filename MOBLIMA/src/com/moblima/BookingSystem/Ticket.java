package com.moblima.BookingSystem;

import com.moblima.MovieSystem.Cinema;
import com.moblima.MovieSystem.Movie;
import java.time.LocalDateTime;

public class Ticket {

    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startTiming;

    public Ticket(Movie movie, Cinema cinema, LocalDateTime startTiming) {
        this.movie = movie;
        this.cinema = cinema;
        this.startTiming = startTiming;
    }

}
