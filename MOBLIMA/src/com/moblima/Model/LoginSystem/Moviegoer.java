package com.moblima.Model.LoginSystem;

import java.io.Serializable;

/**
 * The moviegoer class that represents moviegoers in the system.
 */
public class Moviegoer extends User implements Serializable {

    /**
     * The age of the moviegoer.
     */
    private int age;
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
     * @param age The moviegoer's age.
     * @param name The moviegoer's name.
     * @param mobileNumber The moviegoer's mobile number.
     * @param emailAddress The moviegoer's email address.
     */
    public Moviegoer(String username, String password, int age, String name, int mobileNumber, String emailAddress) {
        super(username, password);
        this.age = age;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
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
     * Get the age of the moviegoer.
     * @return The age of the moviegoer.
     */
    public int getAge() {
    	return age;
    }

    /**
     * The toString of the moviegoer.
     * @return The toString.
     */
    public String toString() {
    	return super.getUsername();
    }
}
