package com.moblima.Controller;

import com.moblima.View.MoviegoerView;
import java.util.Scanner;
import com.moblima.Model.MovieSystem.*;
import com.moblima.Model.LoginSystem.Moviegoer;
import com.moblima.Model.BookingSystem.Holidays;
import com.moblima.Model.BookingSystem.Ticket;
import com.moblima.Utilities.Utilities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * This is the moviegoer controller that controls the flow of the moviegoer part of the program
 */
public class MoviegoerController {

    /**
     * This is the movie manager that stores the movies and it is used to control
     * the movies processes.
     */
    private MovieManager movieManager;

    /**
     * This is the cineplex manager that stores the cineplexes and it is used to control
     * the cineplex processes.
     */
    private CineplexManager cineplexManager;

    /**
     * This is the moviegoer view that will be used to interact with the moviegoer
     * and it will be used to get input.
     */
    private MoviegoerView moviegoerView;

    /**
     * This is the moviegoer that is currently using the program.
     */
    private Moviegoer moviegoer;

    /**
     * This is the booking manager that stores the relevant stuff to the booking system and it is used to control
     * the booking processes.
     */
    private BookingManager bookingManager;

    /**
     * This is the boolean that will be used to control some of the loops if the booking is successful.
     */
    private boolean bookingSuccessful;

    /**
     * The construction of the moviegoer controller
     * @param movieManager This is the movie manager that stores the movies and it is used to control
     * the movies processes.
     * @param cineplexManager This is the cineplex manager that stores the cineplexes and it is used to control
     * the cineplex processes.
     * @param moviegoer This is the moviegoer that is currently accessing the program
     * @param bookingManager This is the booking manager that stores the relevant stuff to the booking system and it is used to control
     * the booking processes.
     * @param reader This is the reader that will be passed to the view to get input from the user.
     */
    public MoviegoerController(MovieManager movieManager, CineplexManager cineplexManager, Moviegoer moviegoer, BookingManager bookingManager, Scanner reader) {
        this.movieManager = movieManager;
        this.cineplexManager = cineplexManager;
        this.moviegoerView = new MoviegoerView(reader);
        this.bookingManager = bookingManager;
        this.moviegoer = moviegoer;
        bookingSuccessful = false;
    }

    /**
     * This is used to access the moviegoer commands at the "main" menu of the moviegoer part of the program
     */
    public void getMoviegoerCommands() {
        boolean continueLoop = true;
        while (continueLoop) {
            int input = moviegoerView.getMovieGoerInput();
            switch(input) {
                case 0:
                    continueLoop = false;
                    break;
                case 1:
                    searchForMovie();
                    break;
                case 2:
                    checkSeatsAndBuyTickets();
                    break;
                case 3:
                    viewBookingHistoryAndAddReview();
                    break;
                case 4:
                    listTopMovies();
                    break;
            }
        }
    }

    /**
     * This is the part of the program that searches for movies.
     */
    private void searchForMovie() {
        String movieName = moviegoerView.askUserForMovieName();
        ArrayList<Movie> movieResults = movieManager.getMatchingMovies(movieName);
        boolean continueLoop = true;
        while (continueLoop) {
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (Movie movie: movieResults) {
                tempList.add(count + ". "  + movie.getName() + " (" + movie.getMovieType() + ")");
                count++;
            }
            int input = moviegoerView.inputForMoviesFound(tempList);
            if (input == 0) {
                continueLoop = false;
            } else {
                viewMovieDetails(movieResults.get(input - 1));
            }
        }
    }

    /**
     * This is used to view the movie details.
     * @param movie The movie the user has selected.
     */
    private void viewMovieDetails(Movie movie) {
        boolean continueLoop = true;
        while (continueLoop) {
            int input = moviegoerView.inputForMovieDetails();
            switch (input) {
                case 0:
                    continueLoop = false;
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

    /**
     * This is used to view the movie name details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerMovieName(Movie movie) {
        String movieName = movie.getName();
        moviegoerView.showMovieGoerMovieName(movieName);
    }

    /**
     * This is used to view the movie status details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerStatus(Movie movie) {
        String status = String.valueOf(movie.getStatus());
        moviegoerView.showMovieGoerStatus(status);
    }

    /**
     * This is used to view the movie synopsis details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerSynopsis(Movie movie) {
        String synopsis = movie.getSynopsis();
        moviegoerView.showMovieGoerSynopsis(synopsis);
    }

    /**
     * This is used to view the movie director details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerDirector(Movie movie) {
        String director = movie.getDirector();
        moviegoerView.showMovieGoerDirector(director);
    }

    /**
     * This is used to view the movie casts details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerCast(Movie movie) {
        ArrayList<String> casts = movie.getCasts();
        moviegoerView.showMovieGoerCast(casts);
    }

    /**
     * This is used to view the movie rating details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerRatings(Movie movie) {
        if (movie.getNumberOfReviews() == 0) {
            moviegoerView.showMovieGoerRatings("NA");
        } else {
            double ratings = movie.getRating();
            String result = String.format("%.1f", ratings);
            moviegoerView.showMovieGoerRatings(result);
        }
    }

    /**
     * This is used to view the movie review details.
     * @param movie The movie the user has selected.
     */
    private void giveMoviegoerReviews(Movie movie) {
        ArrayList<String> strings = new ArrayList<String>();
        for (Review review: movie.getReviews()) {
            double ratings = movie.getRating();
            String result = String.format("%.1f", ratings);
            strings.add("User: " + review.getUser() + ", " + "Rating: " + review.getRating() + ", " + review.getComment());
        }
        moviegoerView.showMovieGoerPastReviews(strings);

    }

    /**
     * This is used to check for available seats and to buy tickets.
     */
    private void checkSeatsAndBuyTickets() {
        boolean continueLoop = true;
        while (continueLoop) {
        	bookingSuccessful = false;
            int input = moviegoerView.getBookingSearchInput();
            switch(input) {
                case 0:
                    continueLoop = false;
                    break;
                case 1:
                    searchByMovie();
                    if (bookingSuccessful) {
                    	continueLoop = false;
                    	break;
                    }
                    break;
            }
        }
    }

    /**
     * This is used to search for movie listings that the moviegoer
     * wants to check the seating availabilities and to book the ticket
     * for.
     */
    private void searchByMovie() {
        String movieName = moviegoerView.getMovieName();
        ArrayList<MovieListing> movieListings = cineplexManager.getMovieList(movieName, moviegoer.getAge());
        boolean continueLoop = true;
        while (continueLoop) {
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (MovieListing movieListing: movieListings) {
                LocalDateTime startTime = movieListing.getStartingTime();
                LocalDateTime endTime = movieListing.getEndingTime();
                tempList.add(count + ". "  + "Movie: " + movieListing.getMovie().getName() + " Cineplex: " + movieListing.getCineplex().getName() + " Cinema: " + movieListing.getCinema().getCode()
                        + " Start time: " + Utilities.timeToString(startTime) + " End time: " + Utilities.timeToString(endTime));
                count++;
            }
            int input = moviegoerView.inputForMoviesFound(tempList);
            if (input == 0) {
                continueLoop = false;
            } else {
                viewMovieListingDetail(movieListings.get(input - 1));
                if (bookingSuccessful)
                	continueLoop = false;
            }
        }
    }

    /**
     * This is used to view the details of the movie listing that the
     * moviegoer has selected.
     * @param movieListing The movie listing that the user has selected.
     */
    private void viewMovieListingDetail(MovieListing movieListing) {
        boolean continueLoop = true;
        while (continueLoop) {
            int input = moviegoerView.getInputForBookingPage();
            switch(input) {
                case 0:
                    continueLoop = false;
                    break;
                case 1:
                	giveUserSeats(movieListing);
                	if (bookingSuccessful)
                		continueLoop = false;
                    break;
            }
        }
    }

    /**
     * This will show the seat arrangements of the cinema
     * to the movie goer and let the moviegoer choose
     * seats.
     * @param movieListing The movie listing the user has selected.
     */
    private void giveUserSeats(MovieListing movieListing) {
    	HashMap<String, Seat> seats = movieListing.getSeats();
    	ArrayList<String> seatPlan = new ArrayList<String>();
    	ArrayList<String> seatNames = movieListing.getSeatNames();
    	ArrayList<String> chosenSeats = new ArrayList<String>();
    	for (int i = 0; i < seatNames.size(); i++) {
    		String seat = seatNames.get(i);
    		if (seats.get(seat).isOccupied())
    			seatPlan.add("XX");
    		else
    			seatPlan.add(seat);
    	}
    	boolean continueLoop = true;
    	String input;
    	while (continueLoop) {
    		moviegoerView.showUserSeats(seatPlan);
    		input = moviegoerView.askMovieGoerForSeats(chosenSeats);
    		if (input.equals("0")) { // user wants to go back
    			continueLoop = false;
    			break;
    		} else if (input.equals("Y") || input.equals("y")) { // user wants to proceed with the booking
    			if (chosenSeats.size() == 0) { // user wants to proceed but he have not chosen a seat
    				moviegoerView.informUserToChooseASeat();
    			} else { // proceed with the booking
    				BookSeats(chosenSeats, movieListing);
    				if (bookingSuccessful)
    					continueLoop = false;
    				break;
    			}
    		} else if (chosenSeats.contains(input)) { // the seat he choose has already been chosen by him
    			moviegoerView.informUserHeAlreadyChoseTheSeat();
    		} else if (seatNames.contains(input)) { // the seatNames which contain the original sitting plan contains the input
    			int index = seatNames.indexOf(input);
    			if (seatPlan.get(index).equals("XX")) { // the seat has already been taken
    				moviegoerView.informUserSeatIsTaken();
    			} else { // the seat has no been taken and can be chosen by the user
    				String newString = seatPlan.get(index).replace(input, "OO");
    				seatPlan.set(index, newString);
    				chosenSeats.add(input);
    			}
    		} else { // user enter an invalid seat
    			moviegoerView.informUserNoSuchSeatExist();
    		}
    	}	
    }

    /**
     * This is used to book the seats that the moviegoer has selected.
     * @param chosenSeats The chosen seats the user has selected.
     * @param movieListing The movie listing the user has selected.
     */
    public void BookSeats(ArrayList<String> chosenSeats, MovieListing movieListing) {
    	double price = 0.0;
    	Movie movie = movieListing.getMovie();
    	Cinema cinema = movieListing.getCinema();
    	Cineplex cineplex = movieListing.getCineplex();
    	LocalDateTime startTime = movieListing.getStartingTime();
    	LocalDateTime bookedTiming = LocalDateTime.now();
    	int age = moviegoer.getAge();
    	Holidays holidays = bookingManager.getHolidays();
    	for (String chosenSeat: chosenSeats) {
    		price += Ticket.calculateTicketPrice(movie, cinema, startTime, age, holidays);
    	}
    	int input = moviegoerView.askToProceedWithBooking(chosenSeats, price);
    	switch(input) {
    		case 0:
    			break;
    		case 1:
    			System.out.println("Booking successful.");
    			for (String chosenSeat: chosenSeats)
    			    movie.increaseTicketSales();
    			bookingManager.addHistory(moviegoer.getUsername(), new Ticket(movie, cineplex, cinema, startTime, bookedTiming, moviegoer.getUsername(), chosenSeats.size()));
    			bookingManager.addTransactionID(cinema.getCode());
    			movieListing.occupyTheSeats(chosenSeats);
    			bookingSuccessful = true; // ensure the user will end up on the main screen
    	}
    }

    /**
     * This is used to show the moviegoer the options to
     * view their booking history or to add reviews to the movies
     * they have watched.
     */
    private void viewBookingHistoryAndAddReview() {
    	ArrayList<Ticket> tickets = bookingManager.getHistoryOfMoviegoer(moviegoer.getUsername());
    	boolean continueLoop = true;
    	while (continueLoop) {
    		int input = moviegoerView.getInputFromBookingHistoryMenu();
    		switch(input) {
    			case 0:
    				continueLoop = false;
    				break;
    			case 1:
    				viewBookingHistory(tickets);
    				break;
    			case 2:
    				addReview();
    				break;
    		}
    		
    	}
    }

    /**
     * This is used to allow the moviegoer to see their booking history.
     * @param tickets The ticket history that belongs to the user.
     */
    private void viewBookingHistory(ArrayList<Ticket> tickets) {
    	ArrayList<String> temp = new ArrayList<String>();
    	int count = 1;
    	for (Ticket ticket: tickets) {
    		temp.add(count + ". " + ticket.toString());
    		count++;
    	}
    	moviegoerView.showMoviegoerBookingHistory(temp);
    }

    /**
     * This is used to show the moviegoer the movies the moviegoer has watched
     * and ask if they want to add review for it
     */
    private void addReview() {
    	ArrayList<Movie> movies = bookingManager.getMoviesForReview(moviegoer.getUsername());
    	ArrayList<String> tempList = new ArrayList<String>();
        int count = 1;
        for (Movie movie: movies) {
            tempList.add(count + ". "  + movie.getName() + " (" + movie.getMovieType() + ")");
            count++;
        }
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
        	input = moviegoerView.showMoviegoerReviewAndGetInput(tempList);
        	if (input == 0) {
        		continueLoop = false;
        	} else {
        		addReviewByTheUser(movies.get(input - 1));
        	}
        }
    }

    /**
     * This is used to let the moviegoer add reviews for the movie they have
     * watched.
     * @param movie The movie the moviegoer has selected.
     */
    public void addReviewByTheUser(Movie movie) {
    	String name = moviegoer.getUsername();
    	double rating = moviegoerView.askForRatings();
    	String review = moviegoerView.askForReview();
    	movie.addReview(new Review(name, rating, review));
    	moviegoerView.tellUserReviewIsAdded();
    }

    /**
     * This is used to let the user choose
     * between different ranking systems
     */
    private void listTopMovies() {
    	boolean continueLoop = true;
    	int input;
    	while (continueLoop) {
    		input = moviegoerView.askForRankingInput();
    		switch(input) {
    			case 0:
    				continueLoop = false;
    				break;
    			case 1:
    				getRankingByTicketSales();
    				break;
    			case 2:
    				getRankingByRatings();
    		}
    	}
    }

    /**
     * This is used to let the moviegoer view the top 5
     * movies sorted by ticket sales.
     */
    private void getRankingByTicketSales() {
    	ArrayList<Movie> movies = movieManager.sortByTicketSales();
    	int count = 1;
    	ArrayList<String> tempList = new ArrayList<String>();
    	for (Movie movie: movies) {
    		tempList.add(count + ". " + movie.getName() + "(" + movie.getMovieType() + ") " + "(" + movie.getNumberOfTicketsSold() + ") tickets sold");
    		count++;
    	}
    	moviegoerView.showUserRanking(tempList);
    }

    /**
     * This is used to let the moviegoer view the top 5 movies
     * sorted by movie ratings.
     */
    private void getRankingByRatings() {
    	ArrayList<Movie> movies = movieManager.sortByRatings();
    	int count = 1;
    	ArrayList<String> tempList = new ArrayList<String>();
    	for (Movie movie: movies) {
    	    double ratings = movie.getRating();
    	    String result;
    	    if (ratings == -1) {
    	        result = "NA";
            } else {
                result = String.format("%.1f", ratings);
            }

    		tempList.add(count + ". " + movie.getName() + "(" + movie.getMovieType() + ") " + "(" + result + ") rating");
    		count++;
    	}
    	moviegoerView.showUserRanking(tempList);
    }


}