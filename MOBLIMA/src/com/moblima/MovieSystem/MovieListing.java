package com.moblima.MovieSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MovieListing implements Serializable{

    private HashMap<Timetable, Movie> movieListings;

    public MovieListing() {
        movieListings = new HashMap<Timetable, Movie>();
    }

    public HashMap<Timetable, Movie> getMovieListings() {
        return movieListings;
    }

    public void addMovie(Timetable timetable, Movie movie) {
        for (Timetable timings: movieListings.keySet()) {
            if (timings.timingClash(timetable)) {
                System.out.println("Sorry! There is a timetable clash. Please choose another time or change the timetable.");
                return;
            }
        }
        movieListings.put(timetable, movie);
    }

    public void removeMovie(Movie movie) {
        if (movieListings.containsValue(movie)) {
            Iterator iterator = movieListings.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry)iterator.next();
                if (pair.getValue().equals(movie)) {
                    movieListings.remove(pair.getKey());
                }
            }
        }
    }

    public boolean containsMovie(Movie movie) {
        if (movieListings.containsValue(movie)) {
            return true;
        }
        return false;
    }

}
