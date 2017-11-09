package com.moblima.Controller;

import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {

    private ArrayList<Admin> admins;
    private ArrayList<Moviegoer> moviegoers;
    private final String AdminString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/admin.dat";
    private final String MoviegoerString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/moviegoer.dat";

    public UserManager() {
        admins = new ArrayList<Admin>();
        moviegoers = new ArrayList<Moviegoer>();
    }
    
    public ArrayList<Admin> getAdmins() {
    	return admins;
    }
    
    public ArrayList<Moviegoer> getMoviegoers() {
    	return moviegoers;
    }
    
    public void addNewMoviegoer(String username, String password, int age, String name, int mobileNumber, String email) {
    	Moviegoer moviegoer = new Moviegoer(username, password, age, name, mobileNumber, email);
    	moviegoers.add(moviegoer);
    }

    public void addNewAdmin(String username, String password, int id) {
        Admin admin = new Admin(username, password, id);
        admins.add(admin);
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

    public boolean checkIfAdminUserNameExist(String username) {
        for (Admin admin: admins) {
            if (admin.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
