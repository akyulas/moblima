package com.moblima.Model.MovieSystem;

import java.io.Serializable;

/**
 * This class represents the seat in the movie system.
 */
public class Seat implements Serializable{

    /**
     * The code of the seat.
     */
	private String code;

    /**
     * The boolean is used to keep track if a seat has been booked.
     */
    private boolean occupied;

    /**
     * Constructor of the seat.
     * @param code The code of the seat.
     */
    public Seat(String code) {
    	this.code = code;
        this.occupied = false;
    }

    /**
     * The boolean is used to see if a seat has been booked.
     * @return True if the seat has been booked, false if the seat has not been booked.
     */
    public boolean isOccupied() {
    	return occupied;
    }

    /**
     * Mark the seat as booked.
     */
    public void occupy() {
    	occupied = true;
    }

}

