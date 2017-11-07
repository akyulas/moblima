package com.moblima.Controller;

import com.moblima.Model.MovieSystem.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieManager implements Serializable{

    private ArrayList<Movie> movies;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/movies.dat";

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


}
