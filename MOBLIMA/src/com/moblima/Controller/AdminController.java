package com.moblima.Controller;

import com.moblima.Model.BookingSystem.TicketPriceConfiguration;
import com.moblima.Model.LoginSystem.Admin;
import com.moblima.Model.MovieSystem.*;
import com.moblima.Utilities.Utilities;
import com.moblima.View.AdminView;
import com.moblima.Model.BookingSystem.Holidays;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jodiakyulas on 3/11/17.
 */
public class AdminController {
    private MovieManager movieManager;
    private CineplexManager cineplexManager;
    private AdminView adminView;
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
            int input = adminView.getAdminInput();
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
                LocalDateTime endingTime = adminView.getEndingTime();
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

    private void updateCineplexMovieListing() {
    	boolean continueLoop = true;
    	int input;
    	while (continueLoop) {
    		MovieListing movieListing;
    		boolean tempLoop = true;
        	ArrayList<MovieListing> movieListings = null;
        	while (tempLoop) {
        		String movieName = adminView.getMovieName();
        		movieListings = cineplexManager.getMovieList(movieName);
        		if (movieListings.size() == 0) {
        			input = adminView.tellUserMovieListingsCannotBeFoundAndGetInput();
        			switch(input) {
        				case 0:
        					return;
        				case 1:
        					continue;
        			}
        		}
        	}
        	ArrayList<String> tempList = new ArrayList<String>();
        	int count = 1;
        	continueLoop = true;
            for (MovieListing foundMovieListing: movieListings) {
            	LocalDateTime startTime = foundMovieListing.getStartingTime();
        	    LocalDateTime endTime = foundMovieListing.getEndingTime();
        	    tempList.add(count + ". "  + " Cineplex: " + foundMovieListing.getCineplex().getName() + " Cinema: " + foundMovieListing.getCinema().getCode()
        	    		+ " Start time: " + Utilities.timeToString(startTime) + " End time: " + Utilities.timeToString(endTime));
        	    count++;
        	 }
        	 input = adminView.showAdminMovieListingsAndGetInput(tempList);
        	 if (input == 0)
        	    return;
        	 movieListing = movieListings.get(input - 1);
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
                }
            }
 		}
    }
	
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
                }
            }	
        }   
	}
	
	private void updateDateTime(MovieListing movieListing) {
		boolean continueLoop = true;
		Cinema cinema = movieListing.getCinema();
		while (continueLoop) {
			LocalDateTime startingTime = adminView.getStartingTime();
            LocalDateTime endingTime = adminView.getEndingTime();
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
    	

    private void removeCineplexMovieListing() {
    	boolean continueLoop = true;
    	int input;
    	while (continueLoop) {
    		MovieListing movieListing;
    		boolean tempLoop = true;
        	ArrayList<MovieListing> movieListings = null;
        	while (tempLoop) {
        		String movieName = adminView.getMovieName();
        		movieListings = cineplexManager.getMovieList(movieName);
        		if (movieListings.size() == 0) {
        			input = adminView.tellUserMovieListingsCannotBeFoundAndGetInput();
        			switch(input) {
        				case 0:
        					return;
        				case 1:
        					continue;
        			}
        		}
        	}
        	ArrayList<String> tempList = new ArrayList<String>();
        	int count = 1;
        	continueLoop = true;
            for (MovieListing foundMovieListing: movieListings) {
            	LocalDateTime startTime = foundMovieListing.getStartingTime();
        	    LocalDateTime endTime = foundMovieListing.getEndingTime();
        	    tempList.add(count + ". "  + " Cineplex: " + foundMovieListing.getCineplex().getName() + " Cinema: " + foundMovieListing.getCinema().getCode()
        	    		+ " Start time: " + Utilities.timeToString(startTime) + " End time: " + Utilities.timeToString(endTime));
        	    count++;
        	 }
        	 input = adminView.showAdminMovieListingsAndGetInput(tempList);
        	 if (input == 0)
        	    return;
        	 movieListing = movieListings.get(input - 1);
        	 movieListings.remove(movieListing);
        	 adminView.telluserMovieListingIsSuccessfullyRemoved();
    	}
    }

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
					adminView.tellUserAddingIsSuccessful();
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
							holidayDatesString.add(count + ". " + Utilities.dateToString(holiday));
						}
						input = adminView.displayHolidaysToAdmin(holidayDatesString);
						if (input == 0) {
							continueLoop = false;
						} else {
							LocalDate chosenDate = holidayDates.get(input - 1);
							holidays.removeHoliday(chosenDate);
							adminView.tellUserRemovalIsSuccessful();
						}
						break;
					}
			}
		}
	}

}
