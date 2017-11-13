package com.moblima.Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.moblima.Model.MovieSystem.Cineplex;
import com.moblima.Model.MovieSystem.Movie;
import com.moblima.Model.MovieSystem.MovieListing;
/**
 * This is the import controller that imports data from the text files.
 */
public class ImportController {
	
	private AllTheManagers allTheManagers;

	private String allTheManagerFileString = "../moblima/MOBLIMA/src/com/moblima/Textfiles/allTheManager.dat";
	/**
	 * This is used to import the data from the textfiles.
	 */
	public void importData() {
		allTheManagers = readSerializedObject(allTheManagerFileString);
	}

	/**
	 * This is used to remove all the old data from the managers.
	 */
	
	public void export() {
		writeSerializedObject(allTheManagerFileString, allTheManagers);
	}
	
	public AllTheManagers getAllTheManagers() {
		return allTheManagers;
	}

	public void setAllTheManagers(AllTheManagers allTheManagers) {
		this.allTheManagers = allTheManagers;
	}

	/**
	 * This is used to read the serialized file of the movie manager.
	 * @param filename The path to the movie manager text file.
	 * @return The movie manager that is deserialized
	 */
	private AllTheManagers readSerializedObject(String filename) {
	        AllTheManagers pDetails = null;
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            pDetails = (AllTheManagers) in.readObject();
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

	/**
	 * This is used to create the serialized file of the movie manager.
	 * @param filename The path to the movie manager text file.
	 * @param movieManager The movie manager that will be exported.
	 */
	 private void writeSerializedObject(String filename, AllTheManagers allTheManager) {
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(allTheManager);
	            out.close();
	            //	System.out.println("Object Persisted");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 }

}
