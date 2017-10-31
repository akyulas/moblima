package com.moblima.Control;

import com.moblima.MovieSystem.*;
import java.util.ArrayList;

public class CineplexManager {

    private ArrayList<Cineplex> cineplexes;
    private String FileString = "/com/moblima/TextFiles/cineplex.dat";
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
}
