package com.moblima.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.moblima.Utilities.Utilities;

/**
 * Created by jodiakyulas on 4/11/17.
 */
public class MoviegoerView {

    private Scanner reader;
    
    public MoviegoerView(Scanner reader) {
    	this.reader = reader;
    }

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
                input = Integer.parseInt(reader.nextLine());
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

    public int inputForMoviesFound(ArrayList<String> movieList) {
        if (movieList.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Please press enter to continue.");
            reader.nextLine();
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
                input = Integer.parseInt(reader.nextLine());
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
                input = Integer.parseInt(reader.nextLine());
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

    public void showMovieGoerName(String name) {
        System.out.println("Name: " + name);
        System.out.println();
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

    public void showMovieGoerStatus(String status) {
        System.out.println("Status: " + status);
        System.out.println();
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

    public void showMovieGoerSynopsis(String synopsis) {
        System.out.println("Synopsis");
        System.out.println(Utilities.breakLines(synopsis, 100));
        System.out.println();
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

    public void showMovieGoerDirector(String director) {
        System.out.println("Director: " + director);
        System.out.println();
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

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
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

    public void showMovieGoerRatings(String ratings) {
        System.out.println("Ratings: " + ratings);
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

    public void showMovieGoerPastReviews(ArrayList<String> strings) {
        System.out.println("Reviews By Other Users:");
        for (int i = 0; i < strings.size(); i++) {
            if (i != 0 && i % 3 == 0) {
                System.out.println("Do you want more ratings?");
                System.out.println("Type N for no, any other buttons for yes.");
                String input = reader.nextLine();
                if (input.equals("N"))
                    return;
            }
            System.out.println(strings.get(i));
            System.out.println();
        }
        System.out.println("Please press any buttons to continue.");
        reader.nextLine();
    }

    public int getBookingSearchInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please select your search criteria");
            System.out.println("1. Search by movies");
            System.out.println("0. Enter 0 to go back to other commands.");
            try {
                input = Integer.parseInt(reader.nextLine());
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
                System.out.println("Please give an integer as input.");
            }
        }
        return input;
    }

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
    
    public String getCineplex() {
    	 boolean continueLoop = true;
         String cineplexName = "";
         while (continueLoop) {
             System.out.println("Please give a movie name");
             try {
                 cineplexName = reader.nextLine();
                 if (cineplexName.equals(""))
                     throw new RuntimeException();
                 continueLoop = false;
             } catch(RuntimeException e) {
                 System.out.println("Please do not give an empty input.");
             }
         }
         return cineplexName;
    }

    public int inputForBookingSearchDetails(ArrayList<String> strings) {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("Please choose a movie in the list. Please key in 0 if you want to go back.");
            try {
                input = Integer.parseInt(reader.nextLine());
                if (input < 0 || input > strings.size())
                    System.out.println("Please choose a valid movie.");
                else {
                    continueLoop = false;
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int getInputForBookingPage() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please choose an input from the list.");
            System.out.println("1. Check seat availability and book seats.");
            System.out.println("0. Choose another movie listing from your search result.");
            try {
                input = Integer.parseInt(reader.nextLine());
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
    
    public void showUserSeats(ArrayList<String> seatingPlan) {
    	System.out.println("========screen========");
    	for (int i = 0; i < seatingPlan.size(); i++) {
    		if (i != 0 && i % 5 == 0 && i % 10 != 0) {
    			System.out.print("  ");
    		}
    		if (i % 10 == 0) {
    			System.out.println();
    		}
    		System.out.print(seatingPlan.get(i));
    	}
    	System.out.println();
    }
    
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
    			input = reader.nextLine();
    			if (input.equals("")) 
    				throw new RuntimeException();
    			continueLoop = false;
    		} catch(RuntimeException e) {
    			System.out.println("Please do not give an empty string.");
    		}
    	}
    	return input;
    }
    
    public void informUserToChooseASeat() {
    	System.out.println("Please choose a seat first before you proceed.");
    	System.out.println("Press any key to continue with the choosing process.");
    	reader.nextLine();
    }
    
    public void informUserSeatIsTaken() {
    	System.out.println("That seat is already taken.");
    	System.out.println("Press any key to continue with the choosing process.");
    	reader.nextLine();
    }
    
    public void informUserNoSuchSeatExist() {
    	System.out.println("No such seat exist.");
    	System.out.println("Please enter a proper seat name.");
    	System.out.println("Press any key to continue with the choosing process.");
    	reader.nextLine();
    }
    
    public void informUserHeAlreadyChoseTheSeat() {
    	System.out.println("Hello. The seat has already been chosen by you. Please choose another seat.");
    	System.out.println("Press any key to continue with the choosing process.");
    	reader.nextLine();
    }
    
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
    			input = Integer.parseInt(reader.nextLine());
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
    	reader.nextLine();
    }
    
    public int showMoviegoerReviewAndGetInput(ArrayList<String> movieList) {
    	System.out.println("Please take note that you can only add a review once to a movie you have watched.");
    	System.out.println("Please press enter to continue.");
    	reader.nextLine();
    	int input = 0;
    	boolean continueLoop = true;
    	while (continueLoop) {
    		if (movieList.size() == 0) {
    			System.out.println("You are not allowed to add any reviews.");
    			System.out.println("You have either already add review to any movie that you have watched or you haven't watched any movie.");
    			System.out.println("Please press enter to continue.");
    			reader.hasNextLine();
    			continueLoop =false;
    			break;
    		}
    		for (String movie: movieList) {
    			System.out.println("Choose a movie you want to add review to.");
    			System.out.println(movie);
    			System.out.println("0. Go back to the previous screen.");
    		}
    		try {
    			input = Integer.parseInt(reader.nextLine());
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
    
    public int getInputFromBookingHistoryMenu() {
    	int input = 0;
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Please select an option that you want.");
    		System.out.println("1. View your booking history.");
    		System.out.println("2. Add review to a movie that you have watched.");
    		System.out.println("0. Return back to main menu.");
    		try {
    			input = Integer.parseInt(reader.nextLine());
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

	public double askForRatings() {
		double input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please give a rating(0 - 5) to the movie.");
			try {
				input = Double.parseDouble(reader.nextLine());
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

	public void tellUserReviewIsAdded() {
		System.out.println("Reivew has been successfully added.");
	}
	
	public int askForRankingInput() {
		int input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please select what you want to rank by.");
			System.out.println("1. Rank by ticket sales");
			System.out.println("2. Rank by reviewer's ratings");
			System.out.println("0. Go back to the previous page.");
			try {
				input = Integer.parseInt(reader.nextLine());
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

	public void showUserRanking(ArrayList<String> rankingList) {
		System.out.println("These are the current rankings.");
		for (int i = 0; i < rankingList.size(); i++) {
			System.out.println(rankingList.get(i));
		}
		System.out.println("Please press enter to continue.");
		reader.nextLine();
	}

}
