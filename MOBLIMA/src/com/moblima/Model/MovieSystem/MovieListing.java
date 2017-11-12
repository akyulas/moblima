package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class represents the movie listing in the movie system.
 */
public class MovieListing implements Serializable{

    /**
     * The cineplex where the movie is shown.
     */
    private Cineplex cineplex;

    /**
     * The movie that is being shown.
     */
    private Movie movie;

    /**
     * The cinema where the movie is shown.
     */
    private Cinema cinema;

    /**
     * The start time of the movie listing.
     */
    private LocalDateTime startingTime;

    /**
     * The end time of the movie listing.
     */
    private LocalDateTime endingTime;

    /**
     * The seats that are available for booking for the movie listing.
     */
    private HashMap<String, Seat> seats;

    /**
     * The seat names of each seats in the cinema for the movie listing.
     */
    private ArrayList<String> seatNames;

    /**
     * The construction of the movie listing class.
     * @param cineplex The cineplex where the movie is shown.
     * @param movie The movie that is being shown.
     * @param cinema The cinema where the movie is shown.
     * @param startingTime The start time of the movie listing.
     * @param endingTime The end time of the movie listing.
     */
    public MovieListing(Cineplex cineplex, Movie movie, Cinema cinema, LocalDateTime startingTime, LocalDateTime endingTime) {
        this.cineplex = cineplex;
        this.movie = movie;
        this.cinema = cinema;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.seats = new HashMap<String, Seat>();
        seatNames = new ArrayList<String>(
        		Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
        				"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
        				"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10",
        				"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
        				"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10",
        				"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10",
        				"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
        				"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10",
        				"I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
        				"J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"));
        for (String seat: seatNames) {
        	seats.put(seat, new Seat(seat));
        }
    }

    /**
     * Give the caller the cineplex where the movie is listed.
     * @return The cineplex where the movie is listed.
     */
    public Cineplex getCineplex() {
        return this.cineplex;
    }

    /**
     * Give the caller the movie which is being shown.
     * @return The movie that is being shown.
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * Give the caller the cinema where the movie is being shown.
     * @return The cinema where the movie is being shown.
     */
    public Cinema getCinema() {
        return this.cinema;
    }

    /**
     * Give the caller the start time of the movie listing.
     * @return The start time of the movie listing.
     */
    public LocalDateTime getStartingTime() {
        return this.startingTime;
    }

    /**
     * Give the caller the end time of the movie listing.
     * @return The end time of the movie listing.
     */
    public LocalDateTime getEndingTime() {
        return this.endingTime;
    }

    /**
     * Set the movie being shown with the movie that is given in the parameter.
     * @param movie The movie to be shown.
     */
    public void setMovie(Movie movie) {
    	this.movie = movie;
    }

    /**
     * Set the cineplex and cinema where the movie will be shown with the cineplex and cinema
     * given in the parameter.
     * @param newCineplex The new cineplex where the movie will be shown.
     * @param newCinema The new cinema where the movie will be shown.
     * @param oldCineplex The old cineplex where the movie will be shown.
     * @param oldCinema The old cinema where the movie will be shown.
     */
    public void setCineplexAndCinema(Cineplex newCineplex, Cinema newCinema, Cineplex oldCineplex, Cinema oldCinema) {
    	cineplex = newCineplex;
    	cinema = newCinema;
    	cinema.addTimetable(new Timetable(startingTime, endingTime));
    	oldCinema.removeTimetable(startingTime, endingTime);
    }

    /**
     * Set the starting and ending time of the movie listing with the starting and ending time
     * given in the parameter.
     * @param startingTime The starting time period of the movie listing.
     * @param endingTime The ending time period of the movie listing.
     */
    public void setTime(LocalDateTime startingTime, LocalDateTime endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        cinema.addTimetable(new Timetable(startingTime, endingTime));
        cinema.removeTimetable(startingTime, endingTime);
    }

    /**
     * Give the caller the seats that are available for booking for the movie listing.
     * @return The seats that are available for booking for the movie listing.
     */
    public HashMap<String, Seat> getSeats(){
    	return seats;
    }

    /**
     * Give the caller seat names of each seats in the cinema for the movie listing.
     * @return The seat names of each seats in the cinema for the movie listing.
     */
    public ArrayList<String> getSeatNames() {
    	return seatNames;
    }

    /**
     * Occupy the seats given in the parameter to prevent the seats from being occupied
     * further.
     * @param chosenSeats The seats that were chosen during the booking process by the moviegoer.
     */
    public void occupyTheSeats(ArrayList<String> chosenSeats) {
    	for (String seatName: chosenSeats) {
    		seats.get(seatName).occupy();
    	}
    }

}
