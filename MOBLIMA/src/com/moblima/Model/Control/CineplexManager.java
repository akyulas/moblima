package com.moblima.Model.Control;

import com.moblima.Controller.ImportController;
import com.moblima.Model.MovieSystem.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CineplexManager implements IManager{

    private ArrayList<Cineplex> cineplexes;
    private String FileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/cineplex.dat";
    private ImportController importController;

    public CineplexManager(ImportController importController) {
        cineplexes = new ArrayList<Cineplex>();
        this.importController = importController;
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

    public ArrayList<MovieListing> getMovieList(String movieName) {
        ArrayList<MovieListing> temp = new ArrayList<MovieListing>();
        String tempString = movieName.toLowerCase();
        for (Cineplex cineplex: cineplexes) {
            for (MovieListing movieListing: cineplex.getMovieListing()) {
                String tempMovieName = movieListing.getMovie().getName().toLowerCase();
                if (tempMovieName.contains(tempString)) {
                    temp.add(movieListing);
                }
            }
        }
        return temp;
    }
    

}
