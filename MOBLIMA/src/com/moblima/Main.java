package com.moblima;

import com.moblima.Controller.MainController;

/**
 * This is the main class of the application.
 */
public class Main {

    /**
     * The constructor of the main class of the application.
     * @param args The argument of the main class.
     */
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.start();
    }
}
