package com.moblima.Model.MovieSystem;

/**
 * This enum represents the class type of a cinema in the movie system.
 */
public enum ClassType {
	/**
	 * NORMAL CLASS
	 */
	NORMAL("NORMAL"),
	/**
	 * PLANTINUM CLASS
	 */
	PLANTINUM("PLANTINUM"),
	/**
	 * ELITE CLASS
	 */
	ELITE("ELITE");

	/**
	 * The name of the enum.
	 */
	private final String name;

	/**
	 * The constructor of the class type.
	 * @param type The name of the class type.
	 */
	private ClassType(String type) {
		 name = type;
	 }

	/**
	 * The toString of the class type.
	 * @return The toString of the class type.
	 */
	public String toString() {
		 return name;
	 }
}
