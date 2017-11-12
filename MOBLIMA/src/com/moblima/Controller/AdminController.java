package com.moblima.Controller;

import com.moblima.Model.BookingSystem.TicketPriceConfiguration;
import com.moblima.Model.MovieSystem.*;
import com.moblima.Utilities.Utilities;
import com.moblima.View.AdminView;
import com.moblima.Model.BookingSystem.Holidays;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the admin controller that controls the flow of the admin part of the program
 */
public class AdminController {
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
     * This is the admin view that will be used to interact with the admin
     * and it will be used to get input.
     */
    private AdminView adminView;

    /**
     * This is the booking manager that stores the relevant stuff to the booking system and it is used to control
     * the booking processes.
     */
    private BookingManager bookingManager;

    /**
     * This is the user manager that stores the users and it is used to control
     * the user processes.
     */
    private UserManager userManager;

    /**
     *
     * @param movieManager This is the movie manager that stores the movies and it is used to control
     * the movies processes.
     * @param cineplexManager This is the cineplex manager that stores the cineplexes and it is used to control
     * the cineplex processes.
     * @param bookingManager This is the booking manager that stores the relevant stuff to the booking system and it is used to control
     * the booking processes.
     * @param userManager This is the user manager that stores the users and it is used to control
     * the user processes.
     * @param reader This is the reader that will be passed to the view to get input from the user.
     */
    public AdminController(MovieManager movieManager, CineplexManager cineplexManager, BookingManager bookingManager, UserManager userManager, Scanner reader) {
        this.movieManager = movieManager;
        this.cineplexManager = cineplexManager;
        this.bookingManager = bookingManager;
        this.userManager = userManager;
        this.adminView = new AdminView(reader);
    }

    /**
     * This is used to access the admin commands at the "main" menu of the admin part of the program
     */
    public void getAdminCommands() {
        boolean startingLoop = true;
        while (startingLoop) {
            int input = adminView.getAdminInput();
            switch(input) {
                case 0:
                    startingLoop = false;
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
                    break;
                case 5:
                    listTopMovies();
                    break;
            }
        }
    }

    /**
     * This is used to register new admin into the system.
     */
    private void registerNewAdmin() {
        String username = adminView.getNewUserName();
        boolean continueLoop = userManager.checkIfAdminUserNameExist(username);
        while (continueLoop) {
            adminView.tellAdminUserNameIsChosen();
            username = adminView.getNewUserName();
            continueLoop = userManager.checkIfAdminUserNameExist(username);
        }
        String password = adminView.getNewPassword();
        int id = adminView.getAdminID();
        userManager.addNewAdmin(username, password, id);
    }

    /**
     * This is used to show the options of changing the movies inside the movie pool to the
     * admin.
     */
    private void changeMovieList() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            input = adminView.showAdminOptionsToChangeMovieListing();
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
                    delistMovie();
                case 4:
                    removeMovie();
                    break;
            }
        }
    }

    /**
     * This is used to add the movie into the movie pool.
     */
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

    /**
     * This is used to update the movie that is inside the movie pool.
     */
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

    /**
     * This is used to show available options to update the movie
     * inside the movie pool.
     * @param movie This is the movie that the admin has chosen to update.
     */
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

    /**
     * This is used to remove the movie from the movie pool. The movie will still be
     * inside the movie history pool.
     */
    private void delistMovie() {
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
                movieManager.delistMovies(movieResults.get(input - 1));
                adminView.tellUserMovieIsSuccesfullyRemoved();
            }
        }
    }

    /**
     * This is used to remove the movie from the movie history pool and the movie pool.
     */
    private void removeMovie() {
        String movieName = adminView.getMovieName();
        boolean continueLoop = true;
        while (continueLoop) {
            ArrayList<Movie> movieResults = movieManager.getMatchingMoviesFromHistory(movieName);
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

    /**
     * This is used to show options that are available to change the movies
     * that are listed in the cinemas
     */
    private void changeCineplexMovieList() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            input = adminView.showAdminOptionsToChangeCineplexMovieListing();
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

    /**
     * This is used to list the movie to a cinema.
     */
    private void addCineplexMovieListing() {
        boolean continueLoop = true;
        while (continueLoop) {
            Cineplex cineplex;
            Cinema cinema;
            Movie movie;
            ArrayList<Movie> movies = null;
            ArrayList<String> tempList = new ArrayList<String>();
            ArrayList<Cineplex> cineplexes = cineplexManager.getCineplexes();
            int count = 1;
            for (Cineplex foundCineplex: cineplexes) {
                tempList.add(count + ". "  + foundCineplex.getName());
                count++;
            }
            int input = adminView.showAdminCineplexesAndGetInput(tempList);
            if (input == 0) {
                return;
            } else {
                cineplex = cineplexes.get(input - 1);
            }
            tempList = new ArrayList<String>();
            ArrayList<Cinema> cinemas = cineplexManager.getCinemas(cineplex);
            count = 1;
            for (Cinema foundCinemas: cinemas) {
                tempList.add(count + ". "  + foundCinemas.getCode());
                count++;
            }
            input = adminView.showAdminCinemasAndGetInput(tempList);
            if (input == 0) {
                return;
            } else {
                cinema = cinemas.get(input - 1);
            }
            boolean tempLoop = true;
            while (tempLoop) {
                String movieName = adminView.getMovieName();
                movies = movieManager.getMatchingMovies(movieName);
                if (movies.size() == 0) {
                    input = adminView.tellUserMovieCannotBeFoundAndGetInput();
                    switch (input) {
                        case 0:
                            return;
                        case 1:
                            continue;
                    }
                } else {
                    tempLoop = false;
                }
            }
            tempList = new ArrayList<String>();
            count = 1;
            for (Movie foundMovie: movies) {
                tempList.add(count + ". "  + foundMovie.getName() + " (" + foundMovie.getMovieType() + ")");
                count++;
            }
            input = adminView.showAdminMoviesAndGetInput(tempList);
            if (input == 0)
                return;
            movie = movies.get(input - 1);
            tempLoop = true;
            while (tempLoop) {
                LocalDateTime startingTime = adminView.getStartingTime();
                LocalDateTime endingTime = adminView.getEndingTime(startingTime);
                if (cinema.checkIfOccupied(startingTime, endingTime)) {
                	input = adminView.tellUserTheTimeSlotIsOccupiedAndGetInput();
                	switch(input) {
            		case 0:
            			return;
            		case 1:
            			continue;
            	}
                } else {
                    cineplexManager.addMovieListing(cineplex, cinema, movie, startingTime, endingTime);
                    adminView.tellUserMovieListingIsSuccessfullyAdded();
                    tempLoop = false;
                }
            }
        }
    }

    /**
     * This is used to show the movies that are listed in each cinema and it will show
     * options to update the movie listing.
     */
    private void updateCineplexMovieListing() {
    	boolean continueLoop = true;
    	int input;
    	while (continueLoop) {
        	ArrayList<MovieListing> movieListings = cineplexManager.getAllMovieListings();
        	ArrayList<String> tempList = new ArrayList<String>();
        	int count = 1;
            for (MovieListing foundMovieListing: movieListings) {
            	LocalDateTime startTime = foundMovieListing.getStartingTime();
        	    LocalDateTime endTime = foundMovieListing.getEndingTime();
        	    tempList.add(count + ". "  + "Movie: " + foundMovieListing.getMovie().getName() + " Cineplex: " + foundMovieListing.getCineplex().getName() + " Cinema: " + foundMovieListing.getCinema().getCode()
        	    		+ " Start time: " + Utilities.timeToString(startTime) + " End time: " + Utilities.timeToString(endTime));
        	    count++;
        	 }
        	 input = adminView.showAdminMovieListingsAndGetInput(tempList);
        	 if (input == 0)
        	    return;
        	 MovieListing movieListing = movieListings.get(input - 1);
        	 input = adminView.giveAdminUpdateListAndGetInput();
        	 switch(input) {
        	 	case 0:
        	 		continueLoop = false;
        	 		break;
        	 	case 1:
        	 		updateMovieListingName(movieListing);
        	 		break;
        	 	case 2:
        	 		updateCineplex(movieListing);
        	 		break;
        	 	case 3:
        	 		updateDateTime(movieListing);
        	 		break;
        	 }
        }
    }

    /**
     * This is used to change the movie being shown by the cinema at
     * that particular timing.
     * @param movieListing The movie listing the user has chosen.
     */
	private void updateMovieListingName(MovieListing movieListing) {
    	boolean continueLoop = true;
    	Movie movie;
 		while (continueLoop) {
 			String movieName = adminView.getMovieName(); 
	 		ArrayList<Movie> movies = movieManager.getMatchingMovies(movieName);
	 		if (movies.size() == 0) {
                int input = adminView.tellUserMovieCannotBeFoundAndGetInput();
                switch (input) {
                    case 0:
                        return;
                    case 1:
                        continue;
                }
            } else {
            	ArrayList<String> tempList = new ArrayList<String>();
                int count = 1;
                for (Movie foundMovie: movies) {
                    tempList.add(count + ". "  + foundMovie.getName() + " (" + foundMovie.getMovieType() + ")");
                    count++;
                }
                int input = adminView.inputToUpdateMoviesFound(tempList);
                if (input == 0) {
                    continueLoop = false;
                } else {
                    movie = movies.get(input - 1);
                    movieListing.setMovie(movie);
                    adminView.tellUserMovieListingIsSuccessfullyUpdated();
                    continueLoop = false;
                }
            }
 		}
    }

    /**
     * This is used to change cineplex and the cinema the movie will be shown at
     * that particular timing.
     * @param movieListing The movie listing the user has chosen.
     */
	private void updateCineplex(MovieListing movieListing) {
		ArrayList<String> tempList = new ArrayList<String>();
		Cineplex oldCineplex = movieListing.getCineplex();
		Cinema oldCinema = movieListing.getCinema();
		LocalDateTime startingTime = movieListing.getStartingTime();
		LocalDateTime endingTime = movieListing.getEndingTime();
		Cineplex cineplex;
		Cinema cinema;
		ArrayList<Cineplex> cineplexes = cineplexManager.getCineplexes();
        int count = 1;
        for (Cineplex foundCineplex: cineplexes) {
            tempList.add(count + ". "  + foundCineplex.getName());
            count++;
        }
        int input = adminView.showAdminCineplexesAndGetInput(tempList);
        if (input == 0) {
            return;
        } else {
            cineplex = cineplexes.get(input - 1);
        }
        tempList = new ArrayList<String>();
        ArrayList<Cinema> cinemas = cineplexManager.getCinemas(cineplex);
        count = 1;
        for (Cinema foundCinemas: cinemas) {
            tempList.add(count + ". "  + foundCinemas.getCode());
            count++;
        }
        boolean continueLoop = true;
        while(continueLoop) {
        	input = adminView.showAdminCinemasAndGetInput(tempList);
            if (input == 0) {
                return;
            } else {
                cinema = cinemas.get(input - 1);
                if (cinema.checkIfOccupied(startingTime, endingTime)) {
                	input = adminView.tellUserTheCinemaTimeSlotIsOccupiedAndGetInput();
                	switch (input) {
                		case 0:
                			return;
                		case 1:
                			continue;
                	}
                }
                else {
                	movieListing.setCineplexAndCinema(cineplex, cinema, oldCineplex, oldCinema);
                	adminView.tellUserMovieListingIsSuccessfullyAdded();
                	continueLoop = false;
                }
            }	
        }   
	}

    /**
     * This is used to change timing the movie is being shown at the cinema.
     * @param movieListing The movie listing the user has chosen.
     */
	private void updateDateTime(MovieListing movieListing) {
		boolean continueLoop = true;
		Cinema cinema = movieListing.getCinema();
		while (continueLoop) {
			LocalDateTime startingTime = adminView.getStartingTime();
            LocalDateTime endingTime = adminView.getEndingTime(startingTime);
            if (cinema.checkIfOccupied(startingTime, endingTime)) {
            	int input = adminView.tellUserTheTimeSlotIsOccupiedAndGetInput();
            	switch(input) {
            		case 0:
            			return;
            		case 1:
            			continue;
            	}
            } else {
                movieListing.setTime(startingTime, endingTime);
                continueLoop = false;
            }
       }
	}


    /**
     * This is used to remove the movie that is being listed at a cinema.
     */
    private void removeCineplexMovieListing() {
        boolean continueLoop = true;
        int input;
        while (continueLoop) {
            ArrayList<MovieListing> movieListings = cineplexManager.getAllMovieListings();
            ArrayList<String> tempList = new ArrayList<String>();
            int count = 1;
            for (MovieListing foundMovieListing: movieListings) {
                LocalDateTime startTime = foundMovieListing.getStartingTime();
                LocalDateTime endTime = foundMovieListing.getEndingTime();
                tempList.add(count + ". " + "Movie: " + foundMovieListing.getMovie().getName()  + " Cineplex: " + foundMovieListing.getCineplex().getName() + " Cinema: " + foundMovieListing.getCinema().getCode()
                        + " Start time: " + Utilities.timeToString(startTime) + " End time: " + Utilities.timeToString(endTime));
                count++;
            }
            input = adminView.showAdminMovieListingsAndGetInput(tempList);
            if (input == 0)
                return;
            MovieListing movieListing = movieListings.get(input - 1);
            cineplexManager.removeMovieListing(movieListing.getCineplex(), movieListing);
            adminView.tellUserMovieListingIsSuccessfullyRemoved();
        }
    }

    /**
     * This is used to show the user options to change the system settings.
     */
    private void configureSystemSettings() {
    	boolean continueLoop = true;
    	int input;
    	while (continueLoop) {
    		input = adminView.showUserSystemConfigurationAndGetInput();
    		switch(input) {
    			case 0:
    				continueLoop = false;
    				break;
    			case 1:
    				changeTicketPrice();
    				break;
    			case 2:
    				changeHolidays();
    				break;
    		}
    	}
    }

    /**
     * This is used to change the ticket price used by the movie system.
     */
	private void changeTicketPrice() {
		int input;
		double newCost;
		boolean continueLoop = true;
		while (continueLoop) {
			input = adminView.showTicketOptions();
			if (input == 0)
				break;
			newCost = adminView.getNewCost();
			switch(input) {
				case 1:
					TicketPriceConfiguration.set3DPrice(newCost);
					break;
				case 2:
					TicketPriceConfiguration.setBlockBusterPrice(newCost);
					break;
				case 3:
					TicketPriceConfiguration.setNormalCinemaPrice(newCost);
					break;
				case 4:
					TicketPriceConfiguration.setPlantinumPrice(newCost);
					break;
				case 5:
					TicketPriceConfiguration.setElitePrice(newCost);
					break;
				case 6:
					TicketPriceConfiguration.setChildrenPrice(newCost);
					break;
				case 7:
					TicketPriceConfiguration.setAdultPrice(newCost);
					break;
				case 8:
					TicketPriceConfiguration.setSeniorCitizenPrice(newCost);
					break;
				case 9:
					TicketPriceConfiguration.setWeekdayPrice(newCost);
					break;
				case 10:
					TicketPriceConfiguration.setWeekendPrice(newCost);
					break;
				case 11:
					TicketPriceConfiguration.setHolidayPrice(newCost);
					break;
				case 12:
					TicketPriceConfiguration.setGSTRate(newCost);
					break;
			}
		}
	}

    /**
     * This is used to add more holidays into the system or to remove holidays from the system.
     */
	private void changeHolidays() {
		int input;
		boolean continueLoop = true;
		while (continueLoop) {
			input = adminView.getInputToAddOrRemoveHoliday();
			switch(input) {
				case 0:
					continueLoop = false;
					break;
				case 1:
					LocalDate holidayDate = adminView.getHoliday();
					String description = adminView.getHolidayDescription();
					bookingManager.addHolidays(holidayDate, description);
					adminView.tellUserAdditionOfHolidayIsSuccessful();
					break;
				case 2:
					Holidays holidays = bookingManager.getHolidays();
					ArrayList<LocalDate> holidayDates = holidays.getHolidayDates();
					if (holidayDates.size() == 0) {
						adminView.tellUserNoHolidayDatesIsFound();
						break;
					} else {
						ArrayList<String> holidayDatesString = new ArrayList<String>();
						int count = 1;
						for (LocalDate holiday: holidayDates) {
							holidayDatesString.add(count + ". " + Utilities.dateToString(holiday) + " " + holidays.getDescription(holiday));
							count++;
						}
						input = adminView.displayHolidaysToAdmin(holidayDatesString);
						if (input == 0) {
							continueLoop = false;
						} else {
							LocalDate chosenDate = holidayDates.get(input - 1);
							holidays.removeHoliday(chosenDate);
							adminView.tellUserRemovalOfHolidayIsSuccessful();
						}
						break;
					}
			}
		}
	}

    /**
     * This is used to let the user choose
     * between different ranking systems
     */
    private void listTopMovies() {
        boolean continueLoop = true;
        int input;
        while (continueLoop) {
            input = adminView.askForRankingInput();
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
        adminView.showUserRanking(tempList);
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
        adminView.showUserRanking(tempList);
    }

}
