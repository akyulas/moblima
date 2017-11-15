package com.moblima.Model.LoginSystem;

import java.io.Serializable;

/**
 * The moviegoer class that represents moviegoers in the system.
 */
public class Moviegoer extends User implements Serializable {

    /**
     * The name of the moviegoer.
     */
    private String name;
    /**
     * The mobile number of the moviegoer.
     */
    private int mobileNumber;
    /**
     * The email address of the moviegoer.
     */
    private String emailAddress;

    /**
     * The construction of the moviegoer class.
     * @param username The moviegoer's username.
     * @param password The moviegoer's password.
     * @param name The moviegoer's name.
     * @param mobileNumber The moviegoer's mobile number.
     * @param emailAddress The moviegoer's email address.
     */
    public Moviegoer(String username, String password, String name, int mobileNumber, String emailAddress) {
        super(username, password);
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Return the moviegoer's name.
     * @return Moviegoer's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the moviegoer's mobile number.
     * @return Moviegoer's mobileNumber.
     */
    public int getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * Return the moviegoer's email address.
     * @return The moviegoer's email address;
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * The verification of a moviegoer.
     * @param username The username that is being verified with.
     * @param password The password that is being verified with.
     * @return True if the verification is successful. False if the verification is unsuccessful.
     */
    public boolean verify(String username, String password) {
        if (getUsername().equals(username) && getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * The toString of the moviegoer.
     * @return The toString.
     */
    public String toString() {
    	return super.getUsername();
    }
}
