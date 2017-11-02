package com.moblima.Control;

import com.moblima.MovieSystem.*;
import java.util.ArrayList;

public class MovieManager implements Manager{

    private ArrayList<Movie> movies;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/movies.dat";
    private ImportController importController;

    public MovieManager() {
        movies = new ArrayList<Movie>();
        importController = new ImportController();
    }

    public void importData() {
        ArrayList list = (ArrayList)importController.readSerializedObject(FileString);
        for (int i = 0; i < list.size(); i++) {
            Movie movie = (Movie)list.get(i);
            movies.add(movie);
        }
    }

    public void exportData() {
        importController.writeSerializedObject(FileString, movies);
    }

    protected void wipeOutData() {
    	movies = new ArrayList<Movie>();
        importController.writeSerializedObject(FileString, movies);
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
    
    public ArrayList<Movie> searchForMovie(String name) {
    	ArrayList<Movie> tempList = new ArrayList<Movie>();
    	for (Movie movie: movies) {
    		if (movie.getName().equals(name))
    			tempList.add(movie);
    	}
    	return tempList;
    }
    
    public void searchingLogic(String name) {
    	boolean continueLoop = true;
    	ArrayList<Movie> movieList = new ArrayList<Movie>();
    	if (movieList.size() == 0)
    		return;
    	while (continueLoop) {
    		System.out.println("These are the movies found");
    	}
    }
    
}
