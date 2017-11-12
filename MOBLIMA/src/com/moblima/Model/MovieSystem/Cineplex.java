package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class represents the cineplex inside the movie system.
 */
public class Cineplex implements Serializable{

    /**
     * Cinemas that belong to the cineplex.
     */
    private ArrayList<Cinema> cinemas;

    /**
     * The name of the cineplex.
     */
    private String name;

    /**
     * The movie listings of a cineplex.
     */
    private ArrayList<MovieListing> movieListings;

    /**
     * The construction of the cineplex class.
     * @param name The name of the cineplex.
     * @param cinema1Code The cinema code of the 1st cinema that belongs to the cineplex.
     * @param cinema1Class The cinema class type of the 1st cinema that belongs to the cineplex.
     * @param cinema2Code The cinema code of the 2nd cinema that belongs to the cineplex.
     * @param cinema2Class The cinema class type of the 2nd cinema that belongs to the cineplex.
     * @param cinema3Code The cinema code of the 3rd cinema that belongs to the cineplex.
     * @param cinema3Class The cinema class type of the 3rd cinema that belongs to the cineplex.
     */
    public Cineplex(String name, String cinema1Code, ClassType cinema1Class, String cinema2Code, ClassType cinema2Class, String cinema3Code, ClassType cinema3Class) {
        this.name = name;
        cinemas = new ArrayList<Cinema>();
        addCinema(new Cinema(cinema1Code, cinema1Class));
        addCinema(new Cinema(cinema2Code, cinema2Class));
        addCinema(new Cinema(cinema3Code, cinema3Class));
        movieListings = new  ArrayList<MovieListing>();
    }

    /**
     * Give the caller the name of the cineplex.
     * @return The name of the cineplex.
     */
    public String getName() {
        return name;
    }

    /**
     * Give the caller the cinemas that belong to the cineplex.
     * @return The cinemas that belong to the cineplex.
     */
    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    /**
     * Add a cinema into the cineplex.
     * @param cinema Cinema that is added to the cineplex.
     */
    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    /**
     * Give the caller the cinema with the given cinema code.
     * @param cinemaCode Cinema code of the cinema that the caller wants.
     * @return The cinema with the given cinema code.
     */
    public Cinema getCinema(String cinemaCode) {
        for (Cinema cinema: cinemas) {
            if (cinema.getCode().equals(cinemaCode))
                return cinema;
        }
        return null;
    }

    /**
     * Add a movie listing to a cineplex
     * @param movie The movie that will be shown at the cineplex
     * @param cinema The cinema that will be used to show the movie
     * @param startTiming The start timing of the time period when the movie will be shown.
     * @param endTiming The end timing of the time period when the movie will be shown.
     * @return True if the adding is successful. False if otherwise.
     */
    public boolean addMovieListing(Movie movie, Cinema cinema, LocalDateTime startTiming, LocalDateTime endTiming) {
        if (!cinema.checkIfOccupied(startTiming, endTiming)) {
            movieListings.add(new MovieListing(this, movie, cinema, startTiming, endTiming));
            return true;
        }
        return false;
    }

    /**
     * Give the caller the movie listings of the cineplex.
     * @return The movie listings of the cineplex.
     */
    public ArrayList<MovieListing> getMovieListing() {
        return movieListings;
    }
   

}
