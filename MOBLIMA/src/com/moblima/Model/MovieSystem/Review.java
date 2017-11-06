package com.moblima.Model.MovieSystem;

import java.io.Serializable;

public class Review implements Serializable{

    private final String user;
    private final double rating;
    private final String comment;

    public Review(String user, double rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

}
