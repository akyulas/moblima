package com.moblima.Controller;

import com.moblima.Model.MovieSystem.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CineplexManager implements Serializable {

    private ArrayList<Cineplex> cineplexes;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/cineplex.dat";

    public CineplexManager() {
        cineplexes = new ArrayList<Cineplex>();
    }
    
    public ArrayList<Cineplex> getCineplexes() {
    	return cineplexes;
    }

    public ArrayList<MovieListing> getMovieList(String movieName) {
        ArrayList<MovieListing> temp = new ArrayList<MovieListing>();
        String tempString = movieName.toLowerCase();
        for (Cineplex cineplex: cineplexes) {
            for (MovieListing movieListing: cineplex.getMovieListing()) {
                String tempMovieName = movieListing.getMovie().getName().toLowerCase();
                if (tempMovieName.contains(tempString)) {
                    temp.add(movieListing);
                }
            }
        }
        return temp;
    }
        
    public Cineplex searchForCineplex(String ciniplexName) {
    	for (Cineplex cineplex: cineplexes) {
    		if (cineplex.getName().equals(ciniplexName))
    			return cineplex;
    	}
    	return null;
    }
    
    public Cinema searchForCinema(String cinemaName) {
    	for (Cineplex cineplex: cineplexes) {
    		for (Cinema cinema: cineplex.getCinemas()) {
    			if (cinema.getCode().equals(cinemaName)) {
    				return cinema;
    			}
    		}
    	}
    	return null;
    }

    public boolean addMovieListing(Cineplex cineplex, Cinema cinema, Movie movie, LocalDateTime startingTime, LocalDateTime endingTime) {
        if (startingTime.toLocalDate().isAfter(movie.getEndOfShowingDate()))
            return false;
        cineplex.addMovieListing(movie, cinema, startingTime, endingTime);
        return true;
    }
    

}
