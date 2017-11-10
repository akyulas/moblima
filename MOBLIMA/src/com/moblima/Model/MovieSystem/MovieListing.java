package com.moblima.Model.MovieSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MovieListing implements Serializable{

    private Cineplex cineplex;
    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;
    private HashMap<String, Seat> seats;
    private ArrayList<String> seatNames;

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

    public Cineplex getCineplex() {
        return this.cineplex;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public LocalDateTime getStartingTime() {
        return this.startingTime;
    }

    public LocalDateTime getEndingTime() {
        return this.endingTime;
    }
    
    public void setMovie(Movie movie) {
    	this.movie = movie;
    }
    
    public void setCineplexAndCinema(Cineplex newCineplex, Cinema newCinema, Cineplex oldCineplex, Cinema oldCinema) {
    	cineplex = newCineplex;
    	cinema = newCinema;
    	cinema.addTimetable(new Timetable(startingTime, endingTime));
    	oldCinema.removeTimetable(startingTime, endingTime);
    }
   

    public void setTime(LocalDateTime startingTime, LocalDateTime endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        cinema.addTimetable(new Timetable(startingTime, endingTime));
        cinema.removeTimetable(startingTime, endingTime);
    }
  
    public HashMap<String, Seat> getSeats(){
    	return seats;
    }
    
    public ArrayList<String> getSeatNames() {
    	return seatNames;
    }
    
    public void occupyTheSeats(ArrayList<String> chosenSeats) {
    	for (String seatName: chosenSeats) {
    		seats.get(seatName).occupy();
    	}
    }

}
