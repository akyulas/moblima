package com.moblima.View;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jodiakyulas on 4/11/17.
 */
public class MoviegoerView {

    private Scanner reader = new Scanner(System.in);

    public int getMovieGoerInput() {
        boolean continueLoop = true;
        int input = 0;
        while (continueLoop) {
            System.out.println("Please select an input:");
            System.out.println("1. Search/List movie");
            System.out.println("2. Check seat availability and purchase tickets");
            System.out.println("3. View booking history");
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
        System.out.println(breakLines(synopsis, 100));
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
        System.out.println(breakLines("Casts: " + resultString, 100));
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
            System.out.println("2. Search by cineplex");
            System.out.println("3. Search by movies and cineplex");
            System.out.println("4. Search by movies, cineplex and date");
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
            System.out.println("1. Check seat availability and selection of seats.");
            System.out.println("2. Book and purchase ticket.");
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
                    case 2:
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

    public  String breakLines(String input, int maxLineLength) {
        String SPLIT_REGEXP= "\\s+";
        String SPACE_SEPARATOR = " ";
        String NEWLINE = "\n";
        String[] tokens = input.split(SPLIT_REGEXP);
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];

            if (lineLen + (SPACE_SEPARATOR + word).length() > maxLineLength) {
                if (i > 0) {
                    output.append(NEWLINE);
                }
                lineLen = 0;
            }
            if (i < tokens.length - 1 && (lineLen + (word + SPACE_SEPARATOR).length() + tokens[i + 1].length() <=
                    maxLineLength)) {
                word += SPACE_SEPARATOR;
            }
            output.append(word);
            lineLen += word.length();
        }
        return output.toString();
    }



}
