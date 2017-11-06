package com.moblima.Model.Control;

import com.moblima.Controller.ImportController;
import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;

import java.util.ArrayList;

public class UserManager implements Manager{

    private ArrayList<Admin> admins;
    private ArrayList<Moviegoer> moviegoers;
    private final String AdminString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/admin.dat";
    private final String MoviegoerString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/moviegoer.dat";
    private ImportController importController;

    public UserManager(ImportController importController) {
        admins = new ArrayList<Admin>();
        moviegoers = new ArrayList<Moviegoer>();
        this.importController = importController;
    }

    public void importData() {
        ArrayList list = (ArrayList)importController.readSerializedObject(AdminString);
        for (int i = 0; i < list.size(); i++) {
            Admin admin = (Admin)list.get(i);
            admins.add(admin);
        }
        ArrayList list2 = (ArrayList)importController.readSerializedObject(MoviegoerString);
        for (int i = 0; i < list2.size(); i++) {
            Moviegoer user = (Moviegoer)list2.get(i);
            moviegoers.add(user);
        }
    }
    
    public ArrayList<Admin> getAdmins() {
    	return admins;
    }
    
    public ArrayList<Moviegoer> getMoviegoers() {
    	return moviegoers;
    }

    public void exportData() {
        importController.writeSerializedObject(AdminString, admins);
        importController.writeSerializedObject(MoviegoerString, moviegoers);
    }

    protected void wipeOutData() {
        importController.writeSerializedObject(AdminString, new ArrayList());
        importController.writeSerializedObject(MoviegoerString, new ArrayList());
    }
    
    public void addNewMoviegoer(String username, String password, int age, String name, int mobileNumber, String email) {
    	Moviegoer moviegoer = new Moviegoer(username, password, age, name, mobileNumber, email);
    	moviegoers.add(moviegoer);
    }
    
    public Moviegoer validateMovieGoerData(String username, String password) {
    	for (Moviegoer moviegoer: moviegoers) {
    		if (moviegoer.verify(username, password))
    			return moviegoer;
    	}
    	return null;
    }
    
    public Admin validateAdmin(String username, String password, int id) {
    	for (Admin admin: admins) {
    		if (admin.verify(username, password, id))
    			return admin;
    	}
    	return null;
    }


    public boolean checkIfMovieGoerUserNameExist(String username) {
        for (Moviegoer moviegoer: moviegoers) {
            if (moviegoer.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}