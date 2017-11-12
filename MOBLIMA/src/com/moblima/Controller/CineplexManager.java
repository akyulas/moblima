package com.moblima.Controller;

import com.moblima.Model.MovieSystem.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is the cineplex manager that stores the cineplexes and it is used to control
 * the cineplex processes.
 */
public class CineplexManager implements Serializable {

    /**
     * The cineplexes inside the system.
     */
    private ArrayList<Cineplex> cineplexes;

    /**
     * Construction of the cineplex manager.
     */
    public CineplexManager() {
        cineplexes = new ArrayList<Cineplex>();
    }

    /**
     * Return the cineplexes inside the system.
     * @return The cineplexes inside the system.
     */
    public ArrayList<Cineplex> getCineplexes() {
    	return cineplexes;
    }

    /**
     * Return the movie listings that have a similar movie name and those that
     * have an age limit that is lower than the user's age.
     * @param movieName The name of the movie being searched.
     * @param age The age of the user.
     * @return Movie listings that have a similar movie name and those that
     * have an age limit that are lower than the user's age.
     */
    public ArrayList<MovieListing> getMovieList(String movieName,int age) {
        ArrayList<MovieListing> temp = new ArrayList<MovieListing>();
        String tempString = movieName.toLowerCase();
        for (Cineplex cineplex: cineplexes) {
            for (MovieListing movieListing: cineplex.getMovieListing()) {
            	Movie movie = movieListing.getMovie();
            	int minimumAge = movie.getMovieRating().getMinimumAge();
            	boolean listableStatus = movie.getStatus().equals(StatusType.PREVIEW)  || movie.getStatus().equals(StatusType.NOW_SHOWING);
                String tempMovieName = movieListing.getMovie().getName().toLowerCase();
                if (tempMovieName.contains(tempString) && age > minimumAge && listableStatus) {
                    temp.add(movieListing);
                }
            }
        }
        return temp;
    }

    /**
     * Return the cineplex that has a similar name to the cineplex name given.
     * @param ciniplexName The name of the cineplex.
     * @return the cineplex that has a similar name to the cineplex name given.
     */
    public Cineplex searchForCineplex(String ciniplexName) {
    	for (Cineplex cineplex: cineplexes) {
    		if (cineplex.getName().equals(ciniplexName))
    			return cineplex;
    	}
    	return null;
    }

    /**
     * Return the cinema that has a similar name to the cinema name given.
     * @param cinemaName The name of the cinema.
     * @return the cinema that has a similar name to the cinema name given.
     */
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

    /**
     * Add a movie listing into a cineplex inside a system.
     * @param cineplex The cineplex where the movie listing will be added to.
     * @param cinema The cinema where the movie will be shown in.
     * @param movie The movie that will be shown.
     * @param startingTime The start time of the movie listing.
     * @param endingTime The end time of the movie listing.
     */
    public void addMovieListing(Cineplex cineplex, Cinema cinema, Movie movie, LocalDateTime startingTime, LocalDateTime endingTime) {
        cineplex.addMovieListing(movie, cinema, startingTime, endingTime);
    }


    /**
     * Return the cinemas that belong to the cineplex that was given by the caller.
     * @param cineplex The cineplex that will be used to return the cinemas.
     * @return The cinemas that belong to the cineplex.
     */
    public ArrayList<Cinema> getCinemas(Cineplex cineplex) {
        ArrayList<Cinema> cinemas = cineplex.getCinemas();
        return cinemas;
    }

    /**
     * Return all of the movies listed inside all the cineplexes.
     * @return All of the movies listed inside all the cineplexes.
     */
    public ArrayList<MovieListing> getAllMovieListings() {
        ArrayList<MovieListing> temp = new ArrayList<MovieListing>();
        for (Cineplex cineplex: cineplexes)
            temp.addAll(cineplex.getMovieListing());
        return temp;
    }

    /**
     * Remove a movie listing inside the system.
     * @param cineplex The cineplex from which the movie listing will be removed from.
     * @param movieListing The movie listing that is being removed.
     */
    public void removeMovieListing(Cineplex cineplex, MovieListing movieListing) {
        cineplex.getMovieListing().remove(movieListing);
    }

    /**
     * Remove all the old movie listings whose end time is before the current time.
     */
    public void removeOldMovieListings() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        for (Cineplex cineplex: cineplexes) {
            Iterator<MovieListing> iterator = cineplex.getMovieListing().iterator();
            while (iterator.hasNext())  {
                if (iterator.next().getEndingTime().isBefore(currentDateTime))
                    iterator.remove();
            }
        }
    }

}
