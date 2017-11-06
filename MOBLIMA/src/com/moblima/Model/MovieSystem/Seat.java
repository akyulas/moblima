package com.moblima.Model.MovieSystem;

import java.io.Serializable;

public class Seat implements Serializable{
	
	private String code;
    private boolean occupied;

    public Seat(String code) {
    	this.code = code;
        this.occupied = false;
    }
    
    public String getCode() {
    	return code;
    }
    
    public boolean isOccupied() {
    	return occupied;
    }

}

