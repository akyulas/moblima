package com.moblima.Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportController {
	
	private  MovieManager movieManager;
	private  CineplexManager cineplexManager;
	private  UserManager userManager;
	private  BookingManager bookingManager;
	private String movieFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/movieManager.dat";
	private String cineplexFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/cineplexManager.dat";
	private String userFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/userManager.dat";
	private String bookingFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/bookingManager.dat";
	
	public void importData() {
		movieManager = readSerializedMovieManager(movieFileString);
		cineplexManager = readSerializedCineplexManager(cineplexFileString);
		userManager = readSerializedUserManager(userFileString);
		bookingManager = readSerializedBookingManager(bookingFileString);
	}
	
	public void export() {
		writeSerializedMovieManager(movieFileString, movieManager);
		writeSerializedCineplexManager(cineplexFileString, cineplexManager);
		writeSerializedUserManager(userFileString, userManager);
		writeSerializedBookingManager(bookingFileString, bookingManager);
	}
	
	public MovieManager getMovieManager() {
		return movieManager;
	}
	
	public CineplexManager getCineplexManager() {
		return cineplexManager;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	public BookingManager getBookingManager() {
		return bookingManager;
	}
	
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	
	public void setCineplexManager(CineplexManager cineplexManager) {
		this.cineplexManager = cineplexManager;
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void setBookingManager(BookingManager bookingManager) {
		this.bookingManager = bookingManager;
	}
	
	private MovieManager readSerializedMovieManager(String filename) {
	        MovieManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (MovieManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}
	 
	 private void writeSerializedMovieManager(String filename, MovieManager movieManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(movieManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }
	 
	 private CineplexManager readSerializedCineplexManager(String filename) {
	        CineplexManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (CineplexManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}
	 
	 private void writeSerializedCineplexManager(String filename, CineplexManager cineplexManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(cineplexManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }
	 
	 private UserManager readSerializedUserManager(String filename) {
	        UserManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (UserManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}
	 
	 private void writeSerializedUserManager(String filename, UserManager userManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(userManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }
	 
	 private BookingManager readSerializedBookingManager(String filename) {
	        BookingManager pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (BookingManager) in.readObject();
	            in.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        // print out the size
	        //System.out.println(" Details Size: " + pDetails.size());
	        //System.out.println();
	        return pDetails;
	}
	 
	 private void writeSerializedBookingManager(String filename, BookingManager bookingManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(bookingManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }
	 
	 
}
