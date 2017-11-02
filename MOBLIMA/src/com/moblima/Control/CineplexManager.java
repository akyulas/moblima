package com.moblima.Control;

import com.moblima.MovieSystem.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CineplexManager implements Manager{

    private ArrayList<Cineplex> cineplexes;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/cineplex.dat";
    private ImportController importController;

    public CineplexManager() {
        cineplexes = new ArrayList<Cineplex>();
        importController = new ImportController();
    }

    public void importData() {
        ArrayList list = (ArrayList)importController.readSerializedObject(FileString);
        for (int i = 0; i < list.size(); i++) {
            Cineplex cineplex = (Cineplex)list.get(i);
            cineplexes.add(cineplex);
        }
    }

    public void exportData() {
        importController.writeSerializedObject(FileString, cineplexes);
    }

    protected void wipeOutData() {
        importController.writeSerializedObject(FileString, new ArrayList());
    }
    
    public ArrayList<Cineplex> getCineplexes() {
    	return cineplexes;
    }
    
    public void printAllCinema() {
    	for (Cineplex cineplex: cineplexes) {
    		for (Cinema cinema: cineplex.getCinemas()) {
    			System.out.println(cinema);
    			HashMap<Timetable, Movie> movieList = cinema.getMovieListing().getMovieListings();
    			for (Timetable timetable: movieList.keySet()) {
    				System.out.println(timetable);
    				System.out.println(movieList.get(timetable));
    			}
    		}
    	}
    }
    

}
