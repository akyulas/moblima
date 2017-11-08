package com.moblima.Controller;

import com.moblima.Model.MovieSystem.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieManager implements Serializable{

    private ArrayList<Movie> movies;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/movies.dat";
    private Comparator<Movie> ticketOrder;
    private Comparator<Movie> ratingOrder;

    public MovieManager() {
        movies = new ArrayList<Movie>();
    }
    
    public void setMovie(ArrayList<Movie> movies) {
    	this.movies = movies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    
    public Movie searchForSpecificMovie(String name, MovieType type) {
    	for (Movie movie: movies) {
    		if (movie.getName().equals(name) && movie.getMovieType().equals(type)) {
    			return movie;
    		}
    	}
    	return null;
    }
    
    public ArrayList<Movie> getMatchingMovies(String movieSearchString) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        String tempString = movieSearchString.toLowerCase();
        for (Movie movie: movies) {
            if (movie.getName().toLowerCase().contains(tempString))
                tempList.add(movie);
        }
        return tempList;
    }
    
    public ArrayList<Movie> sortByTicketSales() {
    	ArrayList<Movie> tempList = new ArrayList<Movie>();
    	ticketOrder = new Comparator<Movie>() {
        	public int compare(Movie m1, Movie m2) {
        		int cmp = m2.getNumberOfTicketsSold() - m1.getNumberOfTicketsSold();
        		if (cmp == 0) {
        			cmp = Double.compare(m2.getRating(), m1.getRating());
        		}
        		return cmp;
        	}
        };
    	Collections.sort(movies, ticketOrder);
    	ticketOrder = null;
    	if (movies.size() < 5) {
    		return movies;
    	}
    	for (int i = 0; i < 5; i++) {
    		tempList.add(movies.get(i));
    	}
    	return tempList;
    }
    
    public ArrayList<Movie> sortByRatings() {
    	ArrayList<Movie> tempList = new ArrayList<Movie>();
    	ratingOrder = new Comparator<Movie>() {
        	public int compare(Movie m1, Movie m2) {
        		int cmp = Double.compare(m2.getRating(), m1.getRating());
        		if (cmp == 0) {
        			cmp = m2.getNumberOfTicketsSold() - m1.getNumberOfTicketsSold();
        		}
        		return cmp;
        	}
        };
    	Collections.sort(movies, ratingOrder);
    	ratingOrder = null;
    	if (movies.size() < 5) {
    		return movies;
    	}
    	for (int i = 0; i < 5; i++) {
    		tempList.add(movies.get(i));
    	}
    	return tempList;
    }


}
