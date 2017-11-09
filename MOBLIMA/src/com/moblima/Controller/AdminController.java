package com.moblima.Controller;

import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.MovieSystem.*;
import com.moblima.View.AdminView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jodiakyulas on 3/11/17.
 */
public class AdminController {
    private MovieManager movieManager;
    private CineplexManager cineplexManager;
    private AdminView adminView;
    private int input;
    private boolean continueStartingLoop;
    private Admin admin;
    private BookingManager bookingManager;
    private boolean bookingSuccessful;
    private UserManager userManager;

    public AdminController(MovieManager movieManager, CineplexManager cineplexManager, Admin admin,BookingManager bookingManager, UserManager userManager, Scanner reader) {
        this.movieManager = movieManager;
        this.cineplexManager = cineplexManager;
        this.admin = admin;
        this.bookingManager = bookingManager;
        this.userManager = userManager;
        this.adminView = new AdminView(reader);
    }

    public void getAdminCommands() {
        continueStartingLoop = true;
        while (continueStartingLoop) {
            input = adminView.getAdminInput();
            switch(input) {
                case 0:
                    continueStartingLoop = false;
                    break;
                case 1:
                    registerNewAdmin();
                    break;
                case 2:
                    changeMovieList();
                    break;
                case 3:
                    changeCineplexMovieList();
                    break;
                case 4:
                    configureSystemSettings();
            }
        }
    }

    private void registerNewAdmin() {
        String username = adminView.getUserName();
        boolean continueLoop = userManager.checkIfAdminUserNameExist(username);
        while (continueLoop) {
            System.out.println("Please enter another username. This one's already taken.");
            username = adminView.getNewUserName();
            continueLoop = userManager.checkIfAdminUserNameExist(username);
        }
        String password = adminView.getNewPassword();
        int id = adminView.getAdminID();
        userManager.addNewAdmin(username, password, id);
    }

    private void changeMovieList() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            input = adminView.showMovieGoerOptionsToChangeMovieListing();
            switch(input) {
                case 0:
                    continueLoop = false;
                    break;
                case 1:
                    addMovie();
                    break;
                case 2:
                    updateMovie();
                    break;
                case 3:
                    removeMovie();
                    break;
            }
        }
    }

    private void addMovie() {
        boolean continueLoop = true;
        while (continueLoop) {
            String movieName = adminView.getMovieName();
            int movieTypeChoice = adminView.getMovieType();
            MovieType movieType = MovieType._3D;
            switch(movieTypeChoice) {
                case 1:
                    movieType = MovieType._3D;
                    break;
                case 2:
                    movieType = MovieType.BlockBuster;
            }
            Movie movie = movieManager.searchForSpecificMovie(movieName, movieType);
            if (movie == null)
                continueLoop = false;
            else {
                int input = adminView.tellUserSimilarMovieExist();
                switch(input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        break;
                }
            }
            StatusType statusType = StatusType.COMING_SOON;
            int statusChoice = adminView.getMovieStatus();
            switch(statusChoice) {
                case 1:
                    statusType = StatusType.COMING_SOON;
                    break;
                case 2:
                    statusType = StatusType.PREVIEW;
                    break;
                case 3:
                    statusType = StatusType.NOW_SHOWING;
                    break;
            }
            String synopsis = adminView.getSynopsis();
            String director = adminView.getDirector();
            int movieRatingChoice = adminView.getMovieRating();
            MovieRating movieRating = MovieRating.PG;
            switch(movieRatingChoice) {
                case 1:
                    movieRating = MovieRating.PG;
                    break;
                case 2:
                    movieRating = MovieRating.R18;
                    break;
                case 3:
                    movieRating = MovieRating.PG13;
                    break;
                case 4:
                    movieRating = MovieRating.NC16;
                    break;
                case 5:
                    movieRating = MovieRating.R21;
                    break;
            }
            ArrayList<String> casts = adminView.getCast();
            LocalDate endingDate = adminView.getEndOfShowingDate();
            movieManager.addMovies(new Movie(movieName, statusType, synopsis, director, movieType, movieRating, casts, endingDate));
        }
    }

    private void updateMovie() {
        String movieName = adminView.getMovieName();
        boolean continueLoop = true;
        while (continueLoop) {
            ArrayList<Movie> movieResults = movieManager.getMatchingMovies(movieName);
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (Movie movie: movieResults) {
                tempList.add(count + ". "  + movie.getName() + " (" + movie.getMovieType() + ")");
                count++;
            }
            int input = adminView.inputToUpdateMoviesFound(tempList);
            if (input == 0) {
                continueLoop = false;
            } else {
                showChoices(movieResults.get(input - 1));
            }
        }
    }

    private void showChoices(Movie movie) {
        boolean continueLoop = true;
        int input = 0;
        ArrayList<StatusType> statuses= new ArrayList<StatusType>();
        statuses.add(StatusType.COMING_SOON);
        statuses.add(StatusType.PREVIEW);
        statuses.add(StatusType.NOW_SHOWING);
        ArrayList<MovieRating> movieRatings = new ArrayList<MovieRating>();
        movieRatings.add(MovieRating.PG);
        movieRatings.add(MovieRating.R18);
        movieRatings.add(MovieRating.PG13);
        movieRatings.add(MovieRating.NC16);
        movieRatings.add(MovieRating.R21);
        int tempInput;
        while (continueLoop) {
            input = adminView.getUpdateChoiceFromUser();
            switch(input) {
                case 0:
                    continueLoop = false;
                    break;
                case 1:
                    String movieName = adminView.getMovieName();
                    movie.setName(movieName);
                    break;
                case 2:
                    tempInput = adminView.getMovieStatus();
                    movie.setStatus(statuses.get(tempInput - 1));
                    break;
                case 3:
                    String synopsis = adminView.getSynopsis();
                    movie.setSynopsis(synopsis);
                    break;
                case 4:
                    String director = adminView.getDirector();
                    movie.setDirector(director);
                    break;
                case 5:
                    tempInput = adminView.getMovieRating();
                    movie.setMovieRating(movieRatings.get(tempInput - 1));
                    break;
                case 6:
                    ArrayList<String> casts = adminView.getCast();
                    movie.setCast(casts);
                    break;
                case 7:
                    LocalDate endOfShowingDate = adminView.getEndOfShowingDate();
                    movie.setEndOfShowingDate(endOfShowingDate);

            }
        }
    }

    private void removeMovie() {
        String movieName = adminView.getMovieName();
        boolean continueLoop = true;
        while (continueLoop) {
            ArrayList<Movie> movieResults = movieManager.getMatchingMovies(movieName);
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (Movie movie: movieResults) {
                tempList.add(count + ". "  + movie.getName() + " (" + movie.getMovieType() + ")");
                count++;
            }
            int input = adminView.inputToRemoveMoviesFound(tempList);
            if (input == 0) {
                continueLoop = false;
            } else {
                movieManager.removeMovies(movieResults.get(input - 1));
                adminView.tellUserMovieIsSuccesfullyRemoved();
            }
        }
    }

    private void changeCineplexMovieList() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            input = adminView.showMovieGoerOptionsToChangeCineplexMovieListing();
            switch(input) {
                case 0:
                    continueLoop = false;
                    break;
                case 1:
                    addCineplexMovieListing();
                    break;
                case 2:
                    updateCineplexMovieListing();
                    break;
                case 3:
                    removeCineplexMovieListing();
                    break;
            }
        }
    }


    private void addCineplexMovieListing() {
        
    }

    private void updateCineplexMovieListing() {

    }

    private void removeCineplexMovieListing() {

    }

    private void configureSystemSettings() {
    }


}
