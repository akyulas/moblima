package com.moblima.Control;

public class MainController{

    private MovieManager movieManager = new MovieManager();

    public void start() {
        System.out.println("Starting application");
        movieManager.importData();
    }

    public void instructions() {
    }

    public void end() {
        System.out.println("Ending application");
        movieManager.exportData();
    }

}
