package com.moblima.Model.LoginSystem;

import java.io.Serializable;

/**
 * This is an abstract class that represents users in the system.
 */
public abstract class User implements Serializable{

    /**
     * The username of the user.
     */
    private final String username;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The construction of the user class.
     * @param username The username of the user.
     * @param password The password of the uer.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Give the username of the user to the caller.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Give the password of the user to the caller.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }
    

	public abstract boolean verify(String username, String password);

}
