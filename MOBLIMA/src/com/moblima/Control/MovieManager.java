package com.moblima.Control;

import com.moblima.MovieSystem.*;
import java.util.ArrayList;

public class MovieManager{

    private ArrayList<Movie> movies;
    private String FileString = "/com/moblima/TextFiles/movies.dat";
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
        importController.writeSerializedObject(FileString, new ArrayList());
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

}
