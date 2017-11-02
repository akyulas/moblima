package com.moblima.MovieSystem;

import java.io.Serializable;

public class Seat implements Serializable{

    private int row;
    private int column;
    private boolean occupied;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.occupied = false;
    }

}
