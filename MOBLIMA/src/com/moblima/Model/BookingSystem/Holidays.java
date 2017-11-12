package com.moblima.Model.BookingSystem;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.moblima.Utilities.Utilities;

/**
 * This is used to store the holidays inside the system.
 */
public class Holidays implements Serializable{

	/**
	 * This is used to store the dates and the descriptions of the holidays inside the system.
	 */
	private HashMap<LocalDate, String> holidays;

	/**
	 * The construction of the Holidays class.
	 */
	public Holidays() {
		holidays = new HashMap<LocalDate, String>();
	}

	/**
	 * The addition of holiday into the system.
	 * @param time The date of the holiday.
	 * @param description The description of the holiday.
	 */
	public void addHoliday(LocalDate time, String description) {
		holidays.put(time, description);
	}

	/**
	 * The removal of holiday inside the system.
	 * @param time The date of the holiday to be removed.
	 */
	public void removeHoliday(LocalDate time) {
		if (holidays.containsKey(time))
			holidays.remove(time);
	}

	/**
	 * This is used to check if the day inside the parameter is a holiday.
	 * @param time The date of the day
	 * @return True if it is a holiday.
	 */
	public boolean isHoliday(LocalDate time) {
		if (holidays.containsKey(time)) 
			return true;
		return false;
	}

	/**
	 * This is used to give the caller the holiday dates and their description.
	 * @return The holiday dates and their description.
	 */
	public HashMap<LocalDate, String> getHoliday() {
		return holidays;
	}

	/**
	 * This is used to return the holiday dates.
	 * @return The holiday dates.
	 */
	public ArrayList<LocalDate> getHolidayDates() {
		ArrayList<LocalDate> tempList = new ArrayList<LocalDate>();
		for (LocalDate holiday: holidays.keySet()) {
			tempList.add(holiday);
		}
		return tempList;
	}

	/**
	 * This is used to return the description of the holiday.
	 * @param localDate The holiday date.
	 * @return The description of the holiday.
	 */
	public String getDescription(LocalDate localDate) {
		String description = holidays.get(localDate);
		return description;
	}
	
}
