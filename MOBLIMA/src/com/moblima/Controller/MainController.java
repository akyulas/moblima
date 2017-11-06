package com.moblima.Controller;
import java.util.Scanner;

import com.moblima.Model.Control.CineplexManager;
import com.moblima.Model.Control.MovieManager;
import com.moblima.Model.Control.Populate;
import com.moblima.Model.Control.UserManager;
import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.View.LoginView;

public class MainController{

	private ImportController importController = new ImportController();
	private Populate populate;
    private MovieManager movieManager;
    private CineplexManager cineplexManager;
    private UserManager userManager;
    private LoginController loginController;
    private MoviegoerController moviegoerController;
    private AdminController adminController;

    public MainController() {
    	importController = new ImportController();
    	populate = new Populate(importController);
    	movieManager = new MovieManager(importController);
		cineplexManager = new CineplexManager(importController);
		userManager = new UserManager(importController);
		loginController = new LoginController(userManager);
	}

    public void start() {
        System.out.println("Starting application");     
        movieManager.importData();
        cineplexManager.importData();
        userManager.importData();
        System.out.println("Welcome to moblima.");
        continueInstructions();
    }
	private void continueInstructions() {
    	boolean continueLoop= true;
    	while (continueLoop) {
    		loginController.getLoginInformation();
    		boolean quit = loginController.checkIfUserWantsToQuit();
    		if (quit) {
    			break;
			}
    		boolean loginSuccessful = loginController.checkSuccessOfLogin();
    		if (loginSuccessful) {
    			boolean runMoviegoerController = loginController.checkIfMoviegoer();
    			if (runMoviegoerController) {
    				Moviegoer moviegoer = loginController.getMoviegoer();
    				moviegoerController = new MoviegoerController(movieManager, cineplexManager, moviegoer);
    				moviegoerController.getMoviegoerCommands();
				} else {
					adminController = new AdminController();
				}
			}
		}
		end();
	}

    private void end() {
        System.out.println("Ending application");
        movieManager.exportData();
        cineplexManager.exportData();
        userManager.exportData();
        System.out.println("Goodbye!");
    }

}