package com.moblima.Model.BookingSystem;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Holidays implements Serializable{
	
	private HashMap<LocalDate, String> holidays;
	
	public Holidays() {
		holidays = new HashMap<LocalDate, String>();
	}
	
	public void addHoliday(LocalDate time, String description) {
		holidays.put(time, description);
	}
	
	public boolean removeHoliday(LocalDate time) {
		if (holidays.containsKey(time)) {
			holidays.remove(time);
			return true;
		}
		return false;
	}
	
	public boolean isHoliday(LocalDate time) {
		if (holidays.containsKey(time)) 
			return true;
		return false;
	}
	
}
