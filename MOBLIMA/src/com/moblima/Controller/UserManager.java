package com.moblima.Controller;

import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the user manager that stores the users and it is used to control
 * the user processes.
 */
public class UserManager implements Serializable {

    /**
     * These are the list of admins that are inside the system.
     */
    private ArrayList<Admin> admins;

    /**
     * These are the list of moviegoers that are inside the system.
     */
    private ArrayList<Moviegoer> moviegoers;

    /**
     * The construction of the class.
     */
    public UserManager() {
        admins = new ArrayList<Admin>();
        moviegoers = new ArrayList<Moviegoer>();
    }

    /**
     * This is used to get the admins that are inside the system.
     * @return Admins that are inside the system.
     */
    public ArrayList<Admin> getAdmins() {
    	return admins;
    }

    /**
     * This is used to get the moviegoers that are inside the system.
     * @return Moviegoers that are inside the system.
     */
    public ArrayList<Moviegoer> getMoviegoers() {
    	return moviegoers;
    }

    /**
     * This is used to add new moviegoer into the system.
     * @param username The username of the moviegoer.
     * @param password The password of the moviegoer.
     * @param age The age of the moviegoer.
     * @param name The name of the moviegoer.
     * @param mobileNumber The mobile number of the moviegoer.
     * @param email The email address of the moviegoer.
     */
    public void addNewMoviegoer(String username, String password, int age, String name, int mobileNumber, String email) {
    	Moviegoer moviegoer = new Moviegoer(username, password, age, name, mobileNumber, email);
    	moviegoers.add(moviegoer);
    }

    /**
     * Add new admin into the system.
     * @param username The username of the admin.
     * @param password The password of the admin.
     * @param id The admin ID of the admin.
     */
    public void addNewAdmin(String username, String password) {
        Admin admin = new Admin(username, password);
        admins.add(admin);
    }

    /**
     * This is used to validate the moviegoer login information that is inside the system
     * with that found inside the system.
     * @param username The username of the moviegoer.
     * @param password The password of the moviegoer.
     * @return The moviegoer that is inside the system. Null if no moviegoer of the given
     * information is found.
     */
    public Moviegoer validateMovieGoerData(String username, String password) {
    	for (Moviegoer moviegoer: moviegoers) {
    		if (moviegoer.verify(username, password))
    			return moviegoer;
    	}
    	return null;
    }

    /**
     * This is used to validate the admin login information that is inside the system
     * with that found inside the system.
     * @param username The username of the admin.
     * @param password The password of the admin.
     * @param id The adminID of the admin.
     * @return The admin that is inside the system. Null if no admin of the given
     * information is found.
     */
    public Admin validateAdmin(String username, String password) {
    	for (Admin admin: admins) {
    		if (admin.verify(username, password))
    			return admin;
    	}
    	return null;
    }


    /**
     * This is used to check if a moviegoer with the username exist inside the system.
     * @param username The username of the moviegoer.
     * @return True if the moviegoer is found. False if the moviegoer is not found.
     */
    public boolean checkIfMovieGoerUserNameExist(String username) {
        for (Moviegoer moviegoer: moviegoers) {
            if (moviegoer.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is used to check if a admin with the username exist inside the system.
     * @param username The username of the admin.
     * @return True if the admin is found. False if the admin is not found.
     */
    public boolean checkIfAdminUserNameExist(String username) {
        for (Admin admin: admins) {
            if (admin.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
