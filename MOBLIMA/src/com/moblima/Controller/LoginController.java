package com.moblima.Controller;

import com.moblima.Model.Control.UserManager;
import com.moblima.View.LoginView;
import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.LoginSystem.Moviegoer;

/**
 * Created by jodiakyulas on 3/11/17.
 */
public class LoginController {

    private UserManager userManager;
    private LoginView loginView;
    private boolean quit;
    private boolean isMoviegoer;
    private boolean continueStartingLoop;
    private boolean loginSuccessful;
    private int input;
    private Admin admin;
    private Moviegoer moviegoer;

    public LoginController(UserManager userManager) {
        this.userManager = userManager;
        loginView = new LoginView();
        quit = false;
        isMoviegoer =false;
        continueStartingLoop = true;
        loginSuccessful = false;
    }

    public void getLoginInformation() {
        loginSuccessful = false;
        quit = false;
        continueStartingLoop = true;
        input = 0;
        admin = null;
        moviegoer = null;
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

    public void getMoviegoerLoginInformation() {
        input = loginView.getMoviegoerLoginInput();
        switch(input) {
            case 0:
                break;
            case 1:
                loginAsMovieGoer();
                break;
            case 2:
                registerNewMovieGoer();
                break;
        }
    }

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

    public void registerNewMovieGoer() {
        String username = loginView.getNewUserName();
        boolean continueLoop = userManager.checkIfMovieGoerUserNameExist(username);
        while (continueLoop) {
            System.out.println("Please enter another username. This one's already taken.");
            username = loginView.getNewUserName();
            continueLoop = userManager.checkIfMovieGoerUserNameExist(username);
        }
        String password = loginView.getNewPassword();
        int age = loginView.getMoviegoerAge();
        String name = loginView.getMoviegoerName();
        int mobileNumber = loginView.getMoviegoerMobileNumber();
        String emailAddress = loginView.getEmailAddress();
        userManager.addNewMoviegoer(username, password, age, name, mobileNumber, emailAddress);
    }

    public void getAdminLoginInformation() {
        input = loginView.getAdminLoginInput();
        switch(input) {
            case 0:
                break;
            case 1:
                loginAsAdmin();
                break;
        }
    }

    public void loginAsAdmin() {
        boolean continueLoop = true;
        while (continueLoop) {
            String username = loginView.getUserName();
            String password = loginView.getPassword();
            int adminID = loginView.getAdminID();
            admin = userManager.validateAdmin(username, password, adminID);
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

    public boolean checkIfUserWantsToQuit() {
        return quit;
    }

    public boolean checkIfMoviegoer() {
        return isMoviegoer;
    }

    public boolean checkSuccessOfLogin() {
        return loginSuccessful;
    }

    public Moviegoer getMoviegoer() {
        return moviegoer;
    }

    public Admin getAdmin() {
        return admin;
    }

}
