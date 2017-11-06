package com.moblima.Controller;

import com.moblima.Model.Control.CineplexManager;
import com.moblima.Model.Control.MovieManager;
import com.moblima.View.MoviegoerView;
import com.moblima.Model.MovieSystem.*;
import com.moblima.Model.LoginSystem.Moviegoer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/**
 * Created by jodiakyulas on 3/11/17.
 */
public class MoviegoerController {

    private MovieManager movieManager;
    private CineplexManager cineplexManager;
    private MoviegoerView moviegoerView;
    private int input;
    private boolean continueStartingLoop;
    private DateTimeFormatter formatter;
    private Moviegoer moviegoer;

    public MoviegoerController(MovieManager movieManager, CineplexManager cineplexManager, Moviegoer moviegoer) {
        this.movieManager = movieManager;
        this.cineplexManager = cineplexManager;
        this.moviegoerView = new MoviegoerView();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.moviegoer = moviegoer;
    }

    public void getMoviegoerCommands() {
        continueStartingLoop = true;
        while (continueStartingLoop) {
            input = moviegoerView.getMovieGoerInput();
            switch(input) {
                case 0:
                    continueStartingLoop = false;
                    break;
                case 1:
                    searchForMovie();
                    break;
                case 2:
                    checkSeatsAndBuyTickets();
                    break;
                case 3:
                    viewBookingHistory();
                    break;
                case 4:
                    listTopMovies();
                    break;
            }
        }
    }

    private void searchForMovie() {
        String movieName = moviegoerView.askUserForMovieName();
        ArrayList<Movie> movieResults = movieManager.getMatchingMovies(movieName);
        boolean continueStartingLoop = true;
        while (continueStartingLoop) {
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (Movie movie: movieResults) {
                tempList.add(count + ". "  + movie.getName() + " (" + movie.getMovieType() + ")");
                count++;
            }
            int input = moviegoerView.inputForMoviesFound(tempList);
            if (input == 0) {
                continueStartingLoop = false;
            } else {
                viewMovieDetails(movieResults.get(input - 1));
            }
        }
    }

    private void viewMovieDetails(Movie movie) {
        boolean continueStartingLoop = true;
        while (continueStartingLoop) {
            input = moviegoerView.inputForMovieDetails();
            switch (input) {
                case 0:
                    continueStartingLoop = false;
                    break;
                case 1:
                    giveMoviegoerMovieName(movie);
                    break;
                case 2:
                    giveMoviegoerStatus(movie);
                    break;
                case 3:
                    giveMoviegoerSynopsis(movie);
                    break;
                case 4:
                    giveMoviegoerDirector(movie);
                    break;
                case 5:
                    giveMoviegoerCast(movie);
                    break;
                case 6:
                    giveMoviegoerRatings(movie);
                    break;
                case 7:
                    giveMoviegoerReviews(movie);
            }
        }
    }

    private void giveMoviegoerMovieName(Movie movie) {
        String movieName = movie.getName();
        moviegoerView.showMovieGoerName(movieName);
    }

    private void giveMoviegoerStatus(Movie movie) {
        String status = String.valueOf(movie.getStatus());
        moviegoerView.showMovieGoerStatus(status);
    }

    private void giveMoviegoerSynopsis(Movie movie) {
        String synopsis = movie.getSynopsis();
        moviegoerView.showMovieGoerSynopsis(synopsis);
    }

    private void giveMoviegoerDirector(Movie movie) {
        String director = movie.getDirector();
        moviegoerView.showMovieGoerDirector(director);
    }

    private void giveMoviegoerCast(Movie movie) {
        ArrayList<String> casts = movie.getCasts();
        moviegoerView.showMovieGoerCast(casts);
    }

    private void giveMoviegoerRatings(Movie movie) {
        if (movie.getNumberOfReviews() == 0) {
            moviegoerView.showMovieGoerRatings("NA");
        } else {
            double ratings = movie.getRating();
            String result = String.format("%.2f", ratings);
            moviegoerView.showMovieGoerRatings(result);
        }
    }

    public void giveMoviegoerReviews(Movie movie) {
        ArrayList<String> strings = new ArrayList<String>();
        for (Review review: movie.getReviews()) {
            double ratings = movie.getRating();
            String result = String.format("%.2f", ratings);
            strings.add("User: " + review.getUser() + ", " + "Rating: " + review.getRating() + ", " + review.getComment());
        }
        moviegoerView.showMovieGoerPastReviews(strings);

    }

    private void checkSeatsAndBuyTickets() {
        boolean continueLoop = true;
        while (continueLoop) {
            input = moviegoerView.getBookingSearchInput();
            switch(input) {
                case 0:
                    continueStartingLoop = false;
                    break;
                case 1:
                    searchByMovie();
                    break;
                case 2:
                    searchByCineplex();
                    break;
                case 3:
                    searchByMovieAndCineplex();
                    break;
                case 4:
                    searchByMovieAndCineplexAndTime();
                    break;
            }
        }
    }

    public void searchByMovie() {
        String movieName = moviegoerView.getMovieName();
        ArrayList<MovieListing> movieListings = cineplexManager.getMovieList(movieName);
        boolean continueStartingLoop = true;
        while (continueStartingLoop) {
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (MovieListing movieListing: movieListings) {
                LocalDateTime startTime = movieListing.getStartingTime();
                LocalDateTime endTime = movieListing.getEndingTime();
                tempList.add(count + ". "  + " Cineplex: " + movieListing.getCineplex().getName() + " Cinema: " + movieListing.getCinema().getCode()
                        + " Start time: " + startTime.format(formatter) + " End time: " + endTime.format(formatter));
                count++;
            }
            int input = moviegoerView.inputForMoviesFound(tempList);
            if (input == 0) {
                continueStartingLoop = false;
            } else {
                viewMovieListingDetail(movieListings.get(input - 1));
            }
        }
    }

    public void searchByCineplex() {

    }

    public void searchByMovieAndCineplex() {

    }

    public void searchByMovieAndCineplexAndTime() {

    }

    public void viewMovieListingDetail(MovieListing movieListing) {
        boolean continueLoop = true;
        while (continueLoop) {
            input = moviegoerView.getInputForBookingPage();
            switch(input) {
                case 0:
                    continueStartingLoop = false;
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    }

    private void viewBookingHistory() {

    }

    private void listTopMovies() {

    }


}
