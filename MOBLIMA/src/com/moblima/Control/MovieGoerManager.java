package com.moblima.Control;

import java.util.ArrayList;
import com.moblima.LoginSystem.Moviegoer;

public class MovieGoerManager {

    private ArrayList<Moviegoer> moviegoers;
    private String FileString = "/com/moblima/TextFiles/moviegoer.dat";
    private ImportController importController;

    public MovieGoerManager() {
        moviegoers = new ArrayList<Moviegoer>();
        importController = new ImportController();
    }

    public void importData() {
        ArrayList list = (ArrayList)importController.readSerializedObject(FileString);
        for (int i = 0; i < list.size(); i++) {
            Moviegoer movie = (Moviegoer)list.get(i);
            moviegoers.add(movie);
        }
    }

    public void exportData() {
        importController.writeSerializedObject(FileString, moviegoers);
    }

    protected void wipeOutData() {
        importController.writeSerializedObject(FileString, new ArrayList());
    }

}
