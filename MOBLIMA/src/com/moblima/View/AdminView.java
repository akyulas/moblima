package com.moblima.View;

import com.moblima.Model.BookingSystem.Holidays;
import com.moblima.Utilities.Utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jodiakyulas on 4/11/17.
 */
public class AdminView {

    public Scanner reader;

    public AdminView(Scanner reader) {
        this.reader = reader;
    }

    public int getAdminInput() {
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please enter the option that you want to choose.");
            System.out.println("1. Register an admin into the system.");
            System.out.println("2. Create/Update/Remove movie listing.");
            System.out.println("3. Create/Update/Remove cinema showtimes and the movies to be shown.");
            System.out.println("4. Configure system settings.");
            System.out.println("0. Return back to login page.");
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
                        System.out.println("Please enter a valid input.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public String getUserName() {
        boolean continueLoop = true;
        String input = "";
        while (continueLoop) {
            System.out.println("Please enter your username:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    public String getNewUserName() {
        boolean continueLoop = true;
        String input = "";
        while (continueLoop) {
            System.out.println("Please enter new username:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    public String getNewPassword() {
        boolean continueLoop = true;
        String input = "";
        String tempinput = "";
        while (continueLoop) {
            System.out.println("Please enter new password:");
            try {
                input = reader.nextLine();
                if (input.equals("")) {
                    throw new RuntimeException();
                }
                System.out.println("Please reenter the same password:");
                tempinput = reader.nextLine();
                if (input.equals(tempinput)) {
                    continueLoop = false;
                } else {
                    System.out.println("Please reuse the same password.");
                }
            } catch(RuntimeException e) {
                System.out.println("Please do not give an empty string.");
            }
        }
        return input;
    }

    public int getAdminID() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please enter the admin ID that will be used during the login process.");
            try {
                input = Integer.parseInt(reader.nextLine());
                continueLoop = false;
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public String getMovieName() {
        String input = "";
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please enter the movie name.");
            try {
                input = reader.nextLine();
                if (input.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not enter an empty string.");
            }
        }
        return input;
    }

    public int showMovieGoerOptionsToChangeMovieListing() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please select what you want to do.");
            System.out.println("1. Add a movie.");
            System.out.println("2. Update a movie.");
            System.out.println("3. Remove a movie.");
            System.out.println("0. Back to main menu.");
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
                    default:
                        System.out.println("Please enter a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int getMovieType() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please choose a movie type.");
            System.out.println("1. 3D");
            System.out.println("2. Blockbuster");
            try {
                input = Integer.parseInt(reader.nextLine());
                switch(input) {
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please choose a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int tellUserSimilarMovieExist() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("A similar movie has been found.");
            System.out.println("You are not allowed to enter a movie that has a similar entry.");
            System.out.println("Please choose an option below.");
            System.out.println("1. Continue to add entry.");
            System.out.println("0. Go back and choose another option.");
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
                        System.out.println("Pleae choose a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int inputToRemoveMoviesFound(ArrayList<String> movieList) {
        if (movieList.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Press enter to continue.");
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
            System.out.println("Please select the movie that you want to remove. Enter 0 to go back to other commands.");
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

    public int inputToUpdateMoviesFound(ArrayList<String> movieList) {
        if (movieList.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Press enter to continue.");
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
            System.out.println("Please select the movie that you want to remove. Enter 0 to go back to other commands.");
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

    public String getSynopsis() {
        String input = "";
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please enter the synopsis.");
            try {
                input = reader.nextLine();
                if (input.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not enter an empty string.");
            }
        }
        return input;
    }

    public String getDirector() {
        String input = "";
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please enter the director.");
            try {
                input = reader.nextLine();
                if (input.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not enter an empty string.");
            }
        }
        return input;
    }

    public ArrayList<String> getCast() {
        String input = "";
        ArrayList<String> casts = new ArrayList<String>();
        boolean continueLoop = true;
        System.out.println("Please enter at least 2 cast members. Please press enter with an empty line if you are done.");
        while (continueLoop) {
            try {
                input = reader.nextLine();
                if (input.equals("") && casts.size() < 2)
                    throw new RuntimeException();
                if (input.equals(""))
                    continueLoop = false;
                else
                    casts.add(input);
            } catch(RuntimeException e) {
                System.out.println("Please enter at least 2 cast members. Please press enter with an empty line if you are done.");
            }
        }
        return casts;
    }

    public int getMovieRating() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please choose a movie rating.");
            System.out.println("1. PG");
            System.out.println("2. R18");
            System.out.println("3. PG13");
            System.out.println("4. NC16");
            System.out.println("5. R21");
            try {
                input = Integer.parseInt(reader.nextLine());
                switch(input) {
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
                        System.out.println("Please choose a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int getMovieStatus() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please choose a movie status.");
            System.out.println("1. COMING SOON");
            System.out.println("2. PREVIEW");
            System.out.println("3. NOW SHOWING");
            try {
                input = Integer.parseInt(reader.nextLine());
                switch(input) {
                    case 1:
                        continueLoop = false;
                        break;
                    case 2:
                        continueLoop = false;
                        break;
                    case 3:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Please choose a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public LocalDate getEndOfShowingDate() {
        boolean continueLoop = true;
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = Utilities.getDateFormatter();
        while (continueLoop) {
            System.out.println("Please enter a date in the format yyyy-MM-dd");
            String input = reader.nextLine();
            try {
                localDate = LocalDate.parse(input, formatter);
                if (localDate.isBefore(LocalDate.now())) {
                    System.out.println("Please enter a date that is after today.");
                } else {
                    continueLoop = false;
                }
            } catch(Exception e) {
                System.out.println("Please enter a proper date in the format yyyy-MM-dd");
            }
        }
        return localDate;
    }

    public int getUpdateChoiceFromUser() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please choose what you want to update.");
            System.out.println("1. Change Movie Name.");
            System.out.println("2. Change Status Type.");
            System.out.println("3. Change Synopsis.");
            System.out.println("4. Change Director.");
            System.out.println("5. Change Movie Rating.");
            System.out.println("6. Change Casts");
            System.out.println("7. Change End Of Showing Date");
            System.out.println("0. Return to select more movies.");
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
                        continueLoop =false;
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

    public void tellUserMovieIsSuccesfullyRemoved() {
        System.out.println("The movie has been successfully removed.");
        System.out.println("Please press enter to continue.");
        reader.nextLine();
    }

    public int showMovieGoerOptionsToChangeCineplexMovieListing() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please select what you want to do.");
            System.out.println("1. Add a movie listing to a cineplex.");
            System.out.println("2. Update a movie listing of a cineplex.");
            System.out.println("3. Remove a movie listing from a cineplex.");
            System.out.println("0. Back to main menu.");
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
                    default:
                        System.out.println("Please enter a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int letUserChooseAMovieForAdding(ArrayList<String> movieList) {
        if (movieList.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Press enter to continue.");
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
            System.out.println("Please select the movie that you want to use. Enter 0 to go back to other commands.");
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

    public String getCineplexName() {
        String input = "";
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please enter the cineplex name.");
            try {
                input = reader.nextLine();
                if (input.equals(""))
                    throw new RuntimeException();
                continueLoop = false;
            } catch(RuntimeException e) {
                System.out.println("Please do not enter an empty string.");
            }
        }
        return input;
    }

    public void tellUserMovieCannotBeFound() {
        System.out.println("Movie cannot be found.");
    }


    public int tellUserMovieCannotBeFoundAndGetInput() {
        System.out.println("Movie cannot be found.");
        System.out.println("Do you want to continue?");
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("1. Continue");
            System.out.println("0. Choose more options in the previous screen.");
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
                        System.out.println("Please enter a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }

    public int showAdminCineplexesAndGetInput(ArrayList<String> foundCineplexes) {
        if (foundCineplexes.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Press enter to continue.");
            reader.nextLine();
            return 0;
        }

        System.out.println("These are the cineplexes found.");
        for (String foundCineplex: foundCineplexes) {
            System.out.println(foundCineplex);
        }
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select the cineplex you want to add movie to. Enter 0 to go back to other commands.");
            try {
                input = Integer.parseInt(reader.nextLine());
                if (input > foundCineplexes.size() || input < 0) {
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

    public int showAdminCinemasAndGetInput(ArrayList<String> foundCinemas) {
        if (foundCinemas.size() == 0) {
            System.out.println("No movies are found.");
            System.out.println("Press enter to continue.");
            reader.nextLine();
            return 0;
        }

        System.out.println("These are the cinemas found.");
        for (String foundCinema: foundCinemas) {
            System.out.println(foundCinema);
        }
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select the cinema you want to add movie to. Enter 0 to go back to other commands.");
            try {
                input = Integer.parseInt(reader.nextLine());
                if (input > foundCinemas.size() || input < 0) {
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

    public int showAdminMoviesAndGetInput(ArrayList<String> foundMovies) {
        System.out.println("These are the movies found.");
        for (String foundMovie: foundMovies) {
            System.out.println(foundMovie);
        }
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select the movie. Enter 0 to go back to other commands.");
            try {
                input = Integer.parseInt(reader.nextLine());
                if (input > foundMovies.size() || input < 0) {
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

    public LocalDateTime getStartingTime() {
        boolean continueLoop = true;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = Utilities.getDateTimeFormatter();
        System.out.println("This is for the starting time.");
        while (continueLoop) {
            System.out.println("Please enter a date and time in the format yyyy-MM-dd HH:mm:ss");
            String input = reader.nextLine();
            try {
                localDateTime = LocalDateTime.parse(input, formatter);
                if (localDateTime.isBefore(LocalDateTime.now())) {
                    System.out.println("Please enter a date and time that is after the current date and time.");
                } else {
                    continueLoop = false;
                }
            } catch(Exception e) {
                System.out.println("Please enter a proper date and time in the format yyyy-MM-dd HH:mm:ss");
            }
        }
        return localDateTime;
    }

    public LocalDateTime getEndingTime() {
        boolean continueLoop = true;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = Utilities.getDateTimeFormatter();
        System.out.println("This is for the ending time.");
        while (continueLoop) {
            System.out.println("Please enter a date and time in the format yyyy-MM-dd HH:mm:ss");
            String input = reader.nextLine();
            try {
                localDateTime = LocalDateTime.parse(input, formatter);
                if (localDateTime.isBefore(LocalDateTime.now())) {
                    System.out.println("Please enter a date and time that is after the current date and time.");
                } else {
                    continueLoop = false;
                }
            } catch(Exception e) {
                System.out.println("Please enter a proper date and time in the format yyyy-MM-dd HH:mm:ss");
            }
        }
        return localDateTime;
    }

    public int tellUserTheTimeSlotIsOccupiedAndGetInput() {
    	int input = 0;
    	boolean continueLoop = true;
    	System.out.println("The time slot is occupied.");
        System.out.println("Please choose another time slot.");
        while (continueLoop) {
            System.out.println("1. Continue");
            System.out.println("0. Choose more options in the previous screen.");
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
                        System.out.println("Please enter a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;   
    }

    public void tellUserMovieListingIsSuccessfullyAdded() {
        System.out.println("The movie has been successfully listed.");
        System.out.println("Press enter to continue.");
        reader.nextLine();
    }
    
	public int showAdminMovieListingsAndGetInput(ArrayList<String> foundMovieListings) {
		System.out.println("These are the movie listings found.");
	    for (String foundMovieListing: foundMovieListings) {
	    	System.out.println(foundMovieListing);
	    }
	    int input = 0;
	    boolean continueLoop = true;
	    while (continueLoop) {
	    	System.out.println("Please select the movie listings. Enter 0 to go back to other commands.");
	        try {
	        	input = Integer.parseInt(reader.nextLine());
	        	if (input > foundMovieListings.size() || input < 0) {
	        		System.out.println("Press enter to continue.");
	            } else {
	                continueLoop = false;
	            }
	        } catch (Exception e) {
	        	System.out.println("Please enter an integer.");
	        }
	   }
	   return input;
    }
	
    public int tellUserMovieListingsCannotBeFoundAndGetInput() {
        System.out.println("Movie listings cannot be found.");
        System.out.println("Do you want to continue?");
        int input = 0;
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("1. Continue");
            System.out.println("0. Choose more options in the previous screen.");
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
                        System.out.println("Please enter a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;
    }
	
	public int giveAdminUpdateListAndGetInput() {
		int input = 0;
    	boolean continueLoop = true;
    	while (continueLoop) {
    		System.out.println("Please select what you want to update.");
    		System.out.println("1. The movie being shown.");
    		System.out.println("2. The cineplex and cinema it is being shown in.");
    		System.out.println("3. The starting and ending times.");
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
    				case 3:
    					continueLoop = false;
    					break;
    				default:
    					System.out.println("Please give a proper input.");
    			}
    		} catch(Exception e) {
    			System.out.println("Please enter an integer.");
    		}
    	}
    	return input;
    }

	public int tellUserTheCinemaTimeSlotIsOccupiedAndGetInput() {
		int input = 0;
    	boolean continueLoop = true;
    	System.out.println("The time slot in the cinema is occupied.");
        System.out.println("Please choose another cinema.");
        while (continueLoop) {
            System.out.println("1. Continue");
            System.out.println("0. Choose more options in the previous screen.");
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
                        System.out.println("Please enter a valid option.");
                }
            } catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        return input;   
	}

	public void tellUserMovieListingIsSuccessfullyUpdated() {
		System.out.println("The update of the movie listing is successfully.");
		System.out.println("Please press enter to continue.");
		reader.nextLine();
	}

	public void telluserMovieListingIsSuccessfullyRemoved() {
		System.out.println("The movie has been successfully removed.");
		System.out.println("Please press enter to continue.");
		reader.nextLine();
	}
	
	public int showUserSystemConfigurationAndGetInput() {
		boolean continueLoop = true;
		int input = 0;
		while (continueLoop) {
			System.out.println("Please select an option.");
			System.out.println("1. Change ticket price.");
			System.out.println("2. Add/Remove holidays.");
			System.out.println("0. Go back to the previous screen.");
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
						System.out.println("Please choose a valid option.");
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}

	public int showTicketOptions() {
		int input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please select what you want to change.");
			System.out.println("1. Price added by a 3D movie ticket.");
			System.out.println("2. Price added by a BlockBuster movie ticket.");
			System.out.println("3. Price added by a normal cinema.");
			System.out.println("4. Price added by a plantinum class cinema.");
			System.out.println("5. Price added by an elite class cinema.");
			System.out.println("6. Price added by a children ticket.");
			System.out.println("7. Price added by an adult ticket.");
			System.out.println("8. Price added by a senior citizen ticket.");
			System.out.println("9. Price added by a weeday ticket.");
			System.out.println("10. Price added by a weekend ticket.");
			System.out.println("11. Price added by a holiday ticket.");
			System.out.println("12. GST");
			System.out.println("0. Go back to the previous menu.");
			try {
				input = Integer.parseInt(reader.nextLine());
				if (input >= 0 && input <= 12) {
					continueLoop = false;
				} else {
					System.out.println("Please enter a valid option.");
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}
	
	public double getNewCost() {
		double input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please enter the new value.");
			try {
				input = Double.parseDouble(reader.nextLine());
				if (input > 0) {
					continueLoop = false;
				} else {
					System.out.println("Please enter a postive value.");
				}
			} catch(Exception e) {
				System.out.println("Pleae enter a double.");
			}		
		}
		return input;
	}
	
	public int getInputToAddOrRemoveHoliday() {
		int input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Please select an option.");
			System.out.println("1. Add a Holiday.");
			System.out.println("2. Remove a Holiday.");
			System.out.println("0. Go back to the previous menu.");
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
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}

	public LocalDate getHoliday() {
		LocalDate holidayDate = LocalDate.now();
		DateTimeFormatter formatter = Utilities.getDateFormatter();
		boolean continueLoop =true;
		while (continueLoop) {
			try {
				System.out.println("Please enter the holiday date in a yyyy-MM-dd format.");
				String input = reader.nextLine();
				holidayDate = LocalDate.parse(input, formatter);
				if (holidayDate.isBefore(LocalDate.now())) 
					System.out.println("Please do not enter a date before today's date.");
				else 
					continueLoop = false;
			} catch(Exception e) {
				System.out.println("Please enter a valid date in a yyyy-MM-dd format.");
			}
		}
		return holidayDate;
	}

	public String getHolidayDescription() {
		String input = "";
		boolean continueLoop = true;
		while (continueLoop) {
			try {
				System.out.println("Please enter the holdiay description.");
				input = reader.nextLine();
				if (input.equals(""))
					throw new RuntimeException();
				continueLoop = false;
			} catch(RuntimeException e) {
				System.out.println("Please do not enter an empty string.");
			}
		}
		return input;
	}

	public void tellUserNoHolidayDatesIsFound() {
		System.out.println("No holiday dates can be found.");
		System.out.println("Press enter to continue.");
		reader.nextLine();
	}

	public int displayHolidaysToAdmin(ArrayList<String> holidays) {
		int input = 0;
		boolean continueLoop = true;
		while (continueLoop) {
			for (String holiday: holidays) {
				System.out.println(holiday);
			}
			System.out.println("0. Go back to the previous menu.");
			try {
				input = Integer.parseInt(reader.nextLine());
				if (input < 0 || input > holidays.size()) {
					System.out.println("Please choose the correct input.");
				} else {
					continueLoop = false;
				}
			} catch(Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
		return input;
	}
	
	public void tellUserAddingIsSuccessful() {
		System.out.println("The addition of the holiday date is successful.");
		System.out.println("Please press enter to continue.");
		reader.nextLine();
	}

	public void tellUserRemovalIsSuccessful() {
		System.out.println("The removal of the holiday date is successful.");
		System.out.println("Please press enter to continue.");
		reader.nextLine();
	}


	
}
