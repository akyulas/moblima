package com.moblima.Controller;

import com.moblima.View.LoginView;

import java.util.Scanner;

import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;

/**
 * Created by jodiakyulas on 3/11/17.
 */
/**
 * This is the Login Controller that controls the login process
 */
public class LoginController {

    /**
     * This is the user manager that stores the users and it is used to control
     * the user processes.
     */
    private UserManager userManager;

    /**
     * This is the log-in view that will be used to interact with the user
     * and it will be used to get input.
     */
    private LoginView loginView;

    /**
     * This boolean will indicate whether the user wants to quit.
     */
    private boolean quit;

    /**
     * This boolean will indicate whether the user is a moviegoer.
     */
    private boolean isMoviegoer;

    /**
     * This boolean will control the starting loop of the login controller.
     */
    private boolean continueStartingLoop;

    /**
     * This boolean will indicate whether the login is succesfully.
     */
    private boolean loginSuccessful;

    /**
     * This will store the moviegoer that is trying to login if the login is
     * by a moviegoer.
     */
    private Moviegoer moviegoer;

    /**
     * Construction of the moviegoer.
     * @param userManager This is the user manager that stores the users and it is used to control
     * the user processes.
     * @param reader This is the reader that will be passed to the view to get input from the user.
     */
    public LoginController(UserManager userManager, Scanner reader) {
        this.userManager = userManager;
        loginView = new LoginView(reader);
        quit = false;
        isMoviegoer =false;
        continueStartingLoop = true;
        loginSuccessful = false;
    }

    /**
     * This is used to get login information at the start.
     */
    public void getLoginInformation() {
        loginSuccessful = false;
        quit = false;
        continueStartingLoop = true;
        int input = 0;
        moviegoer = null;
        isMoviegoer = false;
        while (continueStartingLoop) {
            input = loginView.getLoginInput();
            switch(input) {
                case 0:
                    continueStartingLoop = false;
                    quit = true;
                    break;
                case 1:
                    getMoviegoerLoginInformation();
                    break;
                case 2:
                    getAdminLoginInformation();
                    break;
                default:
            }
        }

    }

    /**
     * This is used to get the moviegoer login information.
     */
    public void getMoviegoerLoginInformation() {
    	boolean continueLoop = true;
    	while (continueLoop) {
    		int input = loginView.getMoviegoerLoginInput();
    		switch(input) {
            	case 0:
            		continueLoop = false;
            		break;
            	case 1:
            		loginAsMovieGoer();
            		if (loginSuccessful)
            			continueLoop = false;
            		break;
            	case 2:
            		registerNewMovieGoer();
            		break;
    		}
    	}
    }

    /**
     * This is used to login as a moviegoer.
     */
    public void loginAsMovieGoer() {
        boolean continueLoop = true;
        while (continueLoop) {
            String username = loginView.getUserName();
            String password = loginView.getPassword();
            moviegoer = userManager.validateMovieGoerData(username, password);
            if (moviegoer != null) {
                continueLoop = false;
                loginView.tellUserLoginIsSuccessful();
                continueStartingLoop = false;
                loginSuccessful = true;
                isMoviegoer = true;
            } else {
                boolean continueWithLogin = loginView.tellUserLoginIsNotSuccessful();
                continueLoop = continueWithLogin;
            }
        }
    }

    /**
     * This is used to register a new moviegoer.
     */
    public void registerNewMovieGoer() {
        String username = loginView.getNewUserName();
        boolean continueLoop = userManager.checkIfMovieGoerUserNameExist(username);
        while (continueLoop) {
            loginView.tellUserUserNameIsChosen();
            username = loginView.getNewUserName();
            continueLoop = userManager.checkIfMovieGoerUserNameExist(username);
        }
        String password = loginView.getNewPassword();
        int age = loginView.getMoviegoerAge();
        String name = loginView.getMoviegoerName();
        int mobileNumber = loginView.getMoviegoerMobileNumber();
        String emailAddress = loginView.getEmailAddress();
        userManager.addNewMoviegoer(username, password, name, mobileNumber, emailAddress);
    }

    /**
     * This is used to get the admin login information.
     */
    public void getAdminLoginInformation() {
        int input = loginView.getAdminLoginInput();
        switch(input) {
            case 0:
                break;
            case 1:
                loginAsAdmin();
                break;
        }
    }

    /**
     * This is used to login as an admin.
     */
    public void loginAsAdmin() {
        boolean continueLoop = true;
        while (continueLoop) {
            String username = loginView.getUserName();
            String password = loginView.getPassword();
            Admin admin = userManager.validateAdmin(username, password);
            if (admin != null) {
                continueLoop = false;
                loginView.tellUserLoginIsSuccessful();
                continueStartingLoop = false;
                loginSuccessful = true;
            } else {
                boolean continueWithLogin = loginView.tellUserLoginIsNotSuccessful();
                continueLoop = continueWithLogin;
            }
        }
    }

    /**
     * This will return the boolean value of whether the user wants to quit.
     * @return True if the user wants to quit.
     */
    public boolean checkIfUserWantsToQuit() {
        return quit;
    }

    /**
     * This will return the boolean value of whether the user is a moviegoer.
     * @return True if the user is a moviegoer.
     */
    public boolean checkIfMoviegoer() {
        return isMoviegoer;
    }

    /**
     * This will return the boolean value of whether the login is successful.
     * @return true if login is successful.
     */
    public boolean checkSuccessOfLogin() {
        return loginSuccessful;
    }

    /**
     * This will return the moviegoer that is using the system.
     * @return The moviegoer that is using the system.
     */
    public Moviegoer getMoviegoer() {
        return moviegoer;
    }

}
