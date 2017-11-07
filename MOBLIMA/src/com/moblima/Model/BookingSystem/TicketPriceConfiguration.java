package com.moblima.Model.BookingSystem;

import java.io.Serializable;
import java.util.HashMap;

import com.moblima.Model.MovieSystem.ClassType;
import com.moblima.Model.MovieSystem.MovieType;

public class TicketPriceConfiguration implements Serializable {
	
	private static double _3DPrice;
	private static double blockBusterPrice;
	private static double normalCinemaPrice;
	private static double plantinumPrice;
	private static double elitePrice;
	private static double childrenPrice;
	private static double adultPrice;
	private static double seniorCitizenPrice;
	private static double weekdayPrice;
	private static double weekendPrice;
	private static double holidayPrice;
	
	public void set3DPrice(Double price) {
		_3DPrice = price;
	}
	
	public void setBlockBusterPrice(Double price) {
		blockBusterPrice = price;
	}
	
	public void setNormalCinemaPrice(Double price) {
		normalCinemaPrice = price;
	}
	
	public void setPlantinumPrice(Double price) {
		plantinumPrice = price;
	}
	
	public void setElitePrice(Double price) {
		elitePrice = price;
	}
	
	public void setChildrenPrice(Double price) {
		childrenPrice = price;
	}
	
	public void setAdultPrice(Double price) {
		adultPrice = price;
	}
	
	public void setSeniorCitizenPrice(Double price) {
		seniorCitizenPrice = price;
	}
	
	public void setWeekdayPrice(Double price) {
		weekdayPrice = price;
	}
	
	public void setWeekendPrice(Double price) {
		weekendPrice = price;
	}
	
	public void setHolidayPrice(Double price) {
		holidayPrice = price;
	}
	
	public static double get3DPrice() {
		return _3DPrice;
	}
	
	public static double getBlockBusterPrice() {
		return blockBusterPrice;
	}
	
	public static double getNormalCinemaPrice() {
		return normalCinemaPrice;
	}
	
	public static double getPlantinumPrice() {
		return plantinumPrice;
	}
	
	public static double getElitePrice() {
		return elitePrice;
	}
	
	public static double getChildrenPrice() {
		return childrenPrice;
	}
	
	public static double getAdultPrice() {
		return adultPrice;
	}
	
	public static double getSeniorCitizenPrice() {
		return seniorCitizenPrice;
	}
	
	public static double getWeekdayPrice() {
		return weekdayPrice;
	}
	
	public static double getWeekendPrice() {
		return weekendPrice;
	}
	
	public static double getHolidayPrice() {
		return holidayPrice;
	}
}
