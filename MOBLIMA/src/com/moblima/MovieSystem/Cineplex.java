package com.moblima.MovieSystem;

import java.util.ArrayList;

public class Cineplex {

    private ArrayList<Cinema> cinemas;
    private String name;

    public Cineplex(String name) {
        this.name = name;
        cinemas = new ArrayList<Cinema>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public void setName() {
        this.name = name;
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void removeCinema(Cinema cinema) {
        if (cinemas.contains(cinema))
            cinemas.remove(cinema);
    }

}
