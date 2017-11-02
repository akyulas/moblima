package com.moblima.MovieSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{

    private String code;
    private ArrayList<Seat> seats;
    private ClassType classType;
    private MovieListing movieList;

    public Cinema(String code, ClassType classType) {
        this.code = code;
        seats = new ArrayList<Seat>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats.add(new Seat(i, j));
            }
        }
        this.classType = classType;
        this.movieList = new MovieListing();
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public ClassType getClassType() {
        return classType;
    }
    
    public MovieListing getMovieListing() {
    	return movieList;
    }

    public void setId(String code) {
        this.code = code;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public void addMovieIntoList(Timetable timetable, Movie movie) {
        movieList.addMovie(timetable, movie);
    }
    
    public String toString() {
    	return code + "," + classType;
    }

}
