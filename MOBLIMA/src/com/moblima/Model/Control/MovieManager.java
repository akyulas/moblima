package com.moblima.Model.Control;

import com.moblima.Controller.ImportController;
import com.moblima.Model.MovieSystem.*;
import java.util.ArrayList;

public class MovieManager implements Manager{

    private ArrayList<Movie> movies;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/movies.dat";
    private ImportController importController;

    public MovieManager(ImportController importController) {
        movies = new ArrayList<Movie>();
        this.importController = importController;
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
