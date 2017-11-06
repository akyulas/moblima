package com.moblima.Model.MovieSystem;

public enum ClassType {
    NORMAL("NORMAL"), PLANTINUM("PLANTINUM"), ELITE("ELITE");
	
	 private final String name;
	 
	 private ClassType(String type) {
		 name = type;
	 }
	 
	 public String toString() {
		 return name;
	 }
}
