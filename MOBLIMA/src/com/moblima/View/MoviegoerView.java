package com.moblima.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.moblima.Model.BookingSystem.TransactionID;
import com.moblima.Utilities.Utilities;

/**
 * This is the moviegoer view that will be used to interact with the moviegoer for
 * the moviegoer part of the program.
 */
public class MoviegoerView {

    /**
     * This is the scanner that will be used to get input from the user.
     */
    private Scanner reader;

    /**
     * The construction of the class
     * @param reader This is the scanner that will be used to get input from the user.
     */
    public MoviegoerView(Scanner reader) {
    	this.reader = reader;
    }

    /**
     * This will be used to get the starting input from the moviegoer.
     * @return The integer that indicates whether the choice the moviegoer has made.
     */
    public int getMovieGoerInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please select an input:");
            System.out.println("1. Search/List movie");
            System.out.println("2. Check seat availability and purchase tickets");
            System.out.println("3. View booking history and add reviews");
            System.out.println("4. List The Top 5 ranking movies by ticket sales OR by reviewer's ratings");
            System.out.println("0. Return to login page");
            try {
                input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
                switch(input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    case 3:
                        continueLoop = false;
                        break;
                    case 4:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please give the valid integer input.");
                }
            } catch(Exception e) {
                System.out.println("Please give the correct user input.");
            }
        }
        return input;
    }

    /**
     * Get the movie name from the moviegoer.
     * @return The movie name given by the moviegoer.
     */
    public String askUserForMovieName() {
        boolean continueLoop = true;
        String movieName = "";
        while (continueLoop) {
            try {
                System.out.println("Please enter a movie name that you want to search.");
                movieName = reader.nextLine();
                if (movieName.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not enter an empty string.");
            }
        }
        return movieName;
    }

    /**
     * This is used to show the moviegoer the movies that were found.
     * @param movieList The movies that were found.
     * @return The integer that indicates the movie that the moviegoer has chosen.
     */
    public int inputForMoviesFound(ArrayList<String> movieList) {
        if (movieList.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Please press enter to continue.");
            reader.nextLine().replaceAll("\\s","");
            return 0;
        }

        System.out.println("These are the movies found.");
        for (String movieResult: movieList) {
            System.out.println(movieResult);
        }
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select the movie that you want to watch. Enter 0 to go back to other commands.");
            try {
                input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
                if (input > movieList.size() || input < 0) {
                    System.out.println("Please choose the correct number.");
                } else {
                    continueLoop = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    /**
     * This is used to show the movie details options that are available for the moviegoer and to get them to
     * choose an option.
     * @return The integer that indicates the movie details the moviegoer wants to see.
     */
    public int inputForMovieDetails() {
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select one of the movie details that you want to know more about.");
            System.out.println("1. Movie title");
            System.out.println("2. Showing Status");
            System.out.println("3. Synopsis");
            System.out.println("4. Director");
            System.out.println("5. Cast");
            System.out.println("6. Overall reviewer rating(1 - 5[best])");
            System.out.println("7. Past reviews and reviewer's ratings");
            System.out.println("0. Choose more movies from search result");
            try {
                input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
                switch(input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    case 3:
                        continueLoop = false;
                        break;
                    case 4:
                        continueLoop = false;
                        break;
                    case 5:
                        continueLoop = false;
                        break;
                    case 6:
                        continueLoop = false;
                        break;
                    case 7:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please give a valid input.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    /**
     * This is used to show the moviegoer the name of the movie.
     * @param name The name of the movie.
     */
    public void showMovieGoerMovieName(String name) {
        System.out.println("Name: " + name);
        System.out.println();
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the status of the movie.
     * @param status The status of the movie.
     */
    public void showMovieGoerStatus(String status) {
        System.out.println("Status: " + status);
        System.out.println();
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the synopsis of the movie.
     * @param synopsis The synopsis of the movie.
     */
    public void showMovieGoerSynopsis(String synopsis) {
        System.out.println("Synopsis");
        System.out.println(Utilities.breakLines(synopsis, 100));
        System.out.println();
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the director of the movie.
     * @param director The director of the movie.
     */
    public void showMovieGoerDirector(String director) {
        System.out.println("Director: " + director);
        System.out.println();
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the casts of the movie.
     * @param casts The casts of the movie.
     */
    public void showMovieGoerCast(ArrayList<String> casts) {
        String resultString = "";
        int count = 0;
        for (String cast: casts) {
            if (count != casts.size() - 1)
                resultString += cast + ", ";
            else
                resultString += cast + ".";
            count++;
        }
        System.out.println(Utilities.breakLines("Casts: " + resultString, 100));
        System.out.println();
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the ratings of the movie.
     * @param ratings The ratings of the movie.
     */
    public void showMovieGoerRatings(String ratings) {
        System.out.println("Ratings: " + ratings);
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the reviews of the movie.
     * @param reviews The reviews of the movie.
     */
    public void showMovieGoerPastReviews(ArrayList<String> reviews) {
        System.out.println("Reviews By Other Users:");
        for (int i = 0; i < reviews.size(); i++) {
            if (i != 0 && i % 3 == 0) {
                System.out.println("Do you want more ratings?");
                System.out.println("Type N for no, any other buttons for yes.");
                String input = reader.nextLine().replaceAll("\\s","");
                if (input.equals("N"))
                    return;
            }
            System.out.println(reviews.get(i));
            System.out.println();
        }
        System.out.println("Please press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the options in the booking search menu.
     * @return The integer that indicates the option chosen by the moviegoer.
     */
    public int getBookingSearchInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("1. Search for movies");
            System.out.println("2. List out all the movies being listed in cinema.");
            System.out.println("0. Enter 0 to go back to other commands.");
            try {
                input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
                switch(input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                    	continueLoop = false;
                    	break;
                    default:
                        System.out.println("Please give a valid input.");
                }
            } catch(Exception e) {
                System.out.println("Please give an integer as input.");
            }
        }
        return input;
    }

    /**
     * This is used to get the movie name from the moviegoer.
     * @return The movie name given by the movie goer.
     */
    public String getMovieName() {
        boolean continueLoop = true;
        String movieName = "";
        while (continueLoop) {
            System.out.println("Please give a movie name");
            try {
                movieName = reader.nextLine();
                if (movieName.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty input.");
            }
        }
        return movieName;
    }

    /**
     * This is used to show the moviegoer options to get input for the booking page.
     * @return The option that indicates the option the moviegoer has chosen.
     */
    public int getInputForBookingPage() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please choose an input from the list.");
            System.out.println("1. Check seat availability and book seats.");
            System.out.println("0. Choose another movie listing from your search result.");
            try {
                input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
                switch(input) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please give a valid input.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    /**
     * This is used to show the moviegoer the seating plan.
     * @param seatingPlan The seating plan of the cinema.
     */
    public void showUserSeats(ArrayList<String> seatingPlan) {
    	System.out.println("==================screen===================");
    	for (int i = 0; i < seatingPlan.size(); i++) {
    		if (i != 0 && i % 5 == 0 && i % 10 != 0) {
    			System.out.print("  ");
    		}
    		if (i % 10 == 0) {
    			System.out.println();
    		}
    		System.out.print("|" + seatingPlan.get(i) + "|");
    	}
    	System.out.println();
    }

    /**
     * This is used to show the moviegoer seats that they have chosen
     * so far and to ask whether they want to continue adding more seats.
     * @param chosenSeats The seats that were chosen by the moviegoer
     * @return The new seat the moviegoer has chosen or other options that
     * indicates whether the user wants to quit or to continue with the booking
     * process.
     */
    public String askMovieGoerForSeats(ArrayList<String> chosenSeats) {
    	System.out.print("The seats you have chosen so far: ");
    	Iterator<String> iterator = chosenSeats.iterator();
    	String input = "";
    	if (chosenSeats.size() != 0) {
    		String result = "";
    		while (iterator.hasNext()) {
    			result += iterator.next() + ", " ;
    		}
    		result = result.substring(0, result.length() - 2);
    		System.out.println(result);
    	} else {
    		System.out.println();
    	}
    	System.out.println("XX represents a seat that is taken. OO represents a seat that you have already chosen");
    	System.out.println("Seats are in the form: A1, A2, etc....");
    	System.out.println("Please choose a seat. Press Y to proceed. Press 0 if you want to go back.");
    	boolean continueLoop = true;
    	while (continueLoop) {
    		try {
    			input = reader.nextLine().replaceAll("\\s","");
    			if (input.equals("")) 
    				throw new RuntimeException();
    			continueLoop = false;
    		} catch(RuntimeException e) {
    			System.out.println("Please do not give an empty string.");
    		}
    	}
    	return input;
    }

    /**
     * This is used to inform the moviegoer to choose a seat if they want to proceed
     * with no seats chosen.
     */
    public void informUserToChooseASeat() {
    	System.out.println("Please choose a seat first before you proceed.");
    	System.out.println("Press enter to continue with the choosing process.");
    	reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to inform the moviegoer that the seat is taken.
     */
    public void informUserSeatIsTaken() {
    	System.out.println("That seat is already taken.");
    	System.out.println("Press enter to continue with the choosing process.");
    	reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to inform the moviegoer that no such seats exist.
     */
    public void informUserNoSuchSeatExist() {
    	System.out.println("No such seat exist.");
    	System.out.println("Please enter a proper seat name.");
    	System.out.println("Press enter to continue with the choosing process.");
    	reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to inform the moviegoer that he has already chosen the seat.
     */
    public void informUserHeAlreadyChoseTheSeat() {
    	System.out.println("Hello. The seat has already been chosen by you. Please choose another seat.");
    	System.out.println("Press enter to continue with the choosing process.");
    	reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to ask the moviegoer if he wants to proceed with the booking.
     * @param chosenSeats The seats that he have chosen.
     * @param cost The total cost of the tickets he bought.
     * @return The integer that indicates whether he want to proceed with the purchase
     * or he wants to return to the previous menu.
     */
    public int askToProceedWithBooking(ArrayList<String> chosenSeats, double cost) {
    	int input = 0;
    	boolean continueLoop = true;
    	while (continueLoop)  {
    		System.out.print("The following seats have been chosen by you: ");
    		String result = "";
    		Iterator<String> iterator = chosenSeats.iterator();
    		while (iterator.hasNext()) {
    			result += iterator.next() + ", " ;
    		}
    		result = result.substring(0, result.length() - 2);
    		System.out.println(result);
    		String price = String.format("%.2f", cost);
    		System.out.println("The total cost is: " + price);
    		System.out.println("Please press 1 to confirm you want to book the tickets. Press 0 to go back and choose more seats.");
    		try {
    			input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
    			switch(input) {
    				case 0:
    					continueLoop = false;
    					break;
    				case 1:
    					continueLoop = false;
    					break;
    				default:
    					System.out.println("Please enter a valid input.");
    			}
    		} catch(Exception e) {
    			System.out.println("Please enter an integer.");
    		}
    	}
    	return input;
    }

    /**
     * This is used to show the moviegoer their booking history.
     * @param histories The booking histories of the moviegoer.
     */
    public void showMoviegoerBookingHistory(ArrayList<String> histories) {
    	if (histories.size() == 0) {
    		System.out.println("Your history could not be found.");
    	} else {
    		System.out.println("These are your past history of bookings:");
    		for (String history: histories) {
    			System.out.println(history);
    		}
    	}
    	System.out.println("Please press enter to continue.");
    	reader.nextLine().replaceAll("\\s","");
    }

    /**
     * This is used to show the moviegoer the movies that they can add reviews to.
     * @param movieList The movies the moviegoer can added reviews to.
     * @return The integer that indicates whether the moviegoer wants to add review or to
     * go back to the previous menu.
     */
    public int showMoviegoerReviewAndGetInput(ArrayList<String> movieList) {
    	System.out.println("Please take note that you can only add a review once to a movie you have watched.");
    	System.out.println("Please press enter to continue.");
    	reader.nextLine().replaceAll("\\s","");
    	int input = 0;
    	boolean continueLoop = true;
    	while (continueLoop) {
    		if (movieList.size() == 0) {
    			System.out.println("You are not allowed to add any reviews.");
    			System.out.println("You have either already add review to any movie that you have watched or you haven't watched any movie.");
    			System.out.println("Please press enter to continue.");
    			reader.nextLine().replaceAll("\\s","");
    			continueLoop =false;
    			break;
    		}
    		for (String movie: movieList) {
    			System.out.println("Choose a movie you want to add review to.");
    			System.out.println(movie);
    			System.out.println("0. Go back to the previous screen.");
    		}
    		try {
    			input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
    			if (input < 0 || input > movieList.size()) {
    				System.out.println("Please choose a movie from the list.");
    			} else {
    				continueLoop =false;
    			}
    		} catch(Exception e) {
    			System.out.println("Please enter an integer.");
    		}
    	}
    	return input;
    }

    /**
     * This is used to show the user options available from the booking history menu and
     * to get input from moviegoer.
     * @return The integer that indicates the option that the user has chosen.
     */
    public int getInputFromBookingHistoryMenu() {
    	int input = 0;
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Please select an option that you want.");
    		System.out.println("1. View your booking history.");
    		System.out.println("2. Add review to a movie that you have watched.");
    		System.out.println("0. Return back to main menu.");
    		try {
    			input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
    			switch(input) {
    				case 0:
    					continueLoop = false;
    					break;
    				case 1:
    					continueLoop = false;
    					break;
    				case 2:
    					continueLoop = false;
    					break;
    				default:
    					System.out.println("Please enter a valid option.");
    			}
    		} catch(Exception e) {
    			System.out.println("Please input an integer.");
    		}
    	}
    	return input;
    }

    /**
     * This is used to ask ratings from the moviegoer.
     * @return The ratings given by the moviegoer.
     */
	public double askForRatings() {
		double input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please give a rating(0 - 5) to the movie.");
			try {
				input = Double.parseDouble(reader.nextLine().replaceAll("\\s",""));
				if (input < 0 || input > 5) {
					System.out.println("Please ensure that it is between 0 and 5.");
				} else {
					continueLoop = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter a double.");
			}
		}
		return input;
	}

    /**
     * This is used to ask the moviegoer reviews for the movie.
     * @return The reviews given by the moviegoer.
     */
	public String askForReview() {
		String input = "";
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please enter a review to the movie.");
			try {
				input = reader.nextLine();
				if (input.equals(""))
					throw new RuntimeException();
				continueLoop = false;
			} catch(RuntimeException e) {
				System.out.println("Please do not enter an empty review.");
			}
		}
		return input;
	}

    /**
     * This is used to tell the moviegoer the review is successfully added.
     */
	public void tellUserReviewIsAdded() {
		System.out.println("Reivew has been successfully added.");
		System.out.println("Press enter to continue.");
		reader.nextLine().replaceAll("\\s","");
	}

    /**
     * This is used to show the admin options that the admin can choose to rank the
     * top movies by.
     * @return The integer that indicates that option the admin has chosen.
     */
	public int askForRankingInput() {
		int input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please select what you want to rank by.");
			System.out.println("1. Rank by ticket sales");
			System.out.println("2. Rank by reviewer's ratings");
			System.out.println("0. Go back to the previous page.");
			try {
				input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
				switch(input) {
					case 0:
						continueLoop = false;
						break;
					case 1:
						continueLoop = false;
						break;
					case 2:
						continueLoop = false;
						break;
					default:
						System.out.println("Please enter the correct input.");
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}

    /**
     * This is used to show the moviegoer the ranked list.
     * @param rankingList The ranked list produced by the system.
     */
	public void showUserRanking(ArrayList<String> rankingList) {
		System.out.println("These are the current rankings.");
		for (int i = 0; i < rankingList.size(); i++) {
			System.out.println(rankingList.get(i));
		}
		System.out.println("Please press enter to continue.");
		reader.nextLine().replaceAll("\\s","");
	}

	/**
	 * This is used to ask the moviegoer if he wants to search or to list.
	 * @return The integer that indicates the option the user has chosen.
	 */
	public int askForSearchingOrListing() {
		boolean continueLoop = true;
		int input = 0;
		while (continueLoop) {
			try {
				System.out.println("Please select an option.");
				System.out.println("1. Search for a movie.");
				System.out.println("2. List movies.");
				System.out.println("0. Go back to the previous menu.");
				input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
				switch(input) {
					case 0:
						continueLoop = false;
						break;
					case 1:
						continueLoop = false;
						break;
					case 2:
						continueLoop = false;
						break;
					default:
						System.out.println("Please enter a valid option.");
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}

	/**
	 * 
	 * @return 
	 */
	/**
	 * This is used to show the movies that were found through list to the moviegoer 
	 * and to get the input from the moviegoer.
	 * @param movies Show the user the movies that was found.
	 * @return The integer that indicates the option the moviegoer has chosen.
	 */
	public int showUserTheMoviesAndGetInput(ArrayList<String> movies) {
		boolean continueLoop = true;
		int input = 0;
		while (continueLoop) {
			for (String movie: movies) {
				System.out.println(movie);
			}
			System.out.println("Please select a movie you want to know more about. Enter 0 to go back to the previous page.");
			try {
				input = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
				if (input > movies.size() || input < 0) {
					System.out.println("Please enter a valid option.");
				} else {
					continueLoop = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}

    /***
     * This is to get the age group that the user wants to buy the tickets for.
     * @return The age group that the user wants to buy the tickets for.
     */
    public int askMovieGoerForAgeGroup() {
	    boolean continueLoop = true;
	    int ageGroup = 0;
	    while (continueLoop) {
            System.out.println("Please select an age group for tickets that you want to buy.");
            System.out.println("Only movies that can be viewed by the age group will be shown.");
            System.out.println("1. Children(Below 16)");
            System.out.println("2. Children(Below 18)");
            System.out.println("3. Adult (Below 21)");
            System.out.println("4. Adult (Below 55)");
            System.out.println("5. Senior Citizen (Above 55)");
            System.out.println("0. Go Back");
            System.out.println("Note: You can only buy the tickets for one age group at one time.");
            System.out.println("Note: Please enter the correct age group as it will be validated before the entry into the cinema.");
            try {
                ageGroup = Integer.parseInt(reader.nextLine().replaceAll("\\s",""));
                switch(ageGroup) {
                    case 0:
                        continueLoop = false;
                        break;
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    case 3:
                        continueLoop = false;
                        break;
                    case 4:
                        continueLoop = false;
                        break;
                    case 5:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please select a valid input.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return ageGroup;
    }

    /**
     * Show the transaction ID of the transaction to the user.
     * @param transactionID The transaction ID of the transaction.
     */
    public void showUserTransactionID(String transactionID) {
        System.out.println("This is your transactionID. Please take note of it since you have to show this before entry at the cinema.");
        System.out.println("Transaction ID:");
        System.out.println(transactionID);
        System.out.println("Press enter to continue.");
        reader.nextLine().replaceAll("\\s","");
    }
}
