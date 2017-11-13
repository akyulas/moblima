package com.moblima.Model.LoginSystem;

import java.io.Serializable;
import java.util.Scanner;

/**
 * The admin class that represents admins in the system
 */
public class Admin extends User implements Serializable{


    /**
     * The construction of the admin class.
     * @param username The admin's username.
     * @param password The admin's password.
     */
    public Admin(String username, String password) {
        super(username, password);
    }

    /**
     * The verification of an admin.
     * @param username The username that is being verified with.
     * @param password The password that is being verified with.
     * @return True if the verification is successful. False if the verification is unsuccessful.
     */
    public boolean verify(String username, String password) {
        if (getUsername().equals(username) && getPassword().equals(password))
            return true;
        return false;
    }

    /**
     * The toString of the admin.
     * @return The toString.
     */
    public String toString() {
    	return super.getUsername();
    }


}
