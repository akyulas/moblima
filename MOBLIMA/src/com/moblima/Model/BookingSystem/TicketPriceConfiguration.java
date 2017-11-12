package com.moblima.Model.BookingSystem;

import java.io.Serializable;
import java.util.HashMap;

import com.moblima.Model.MovieSystem.ClassType;
import com.moblima.Model.MovieSystem.MovieType;

/**
 * This is the ticket price configuration that stores the price inside the system.
 */
public class TicketPriceConfiguration implements Serializable {

	/**
	 * Price added for a 3D movie.
	 */
	private static double _3DPrice;

	/**
	 * Price added for a blockbuster movie.
	 */
	private static double blockBusterPrice;

	/**
	 * Price added for a normal class cinema price.
	 */
	private static double normalCinemaPrice;

	/**
	 * Price added for a plantinum class cinema price.
	 */
	private static double plantinumPrice;

	/**
	 * Price added for an elite class cinema price.
	 */
	private static double elitePrice;

	/**
	 * Price added by a children.
	 */
	private static double childrenPrice;

	/**
	 * Price added by an adult.
	 */
	private static double adultPrice;

	/**
	 * Price added by a senior citizen.
	 */
	private static double seniorCitizenPrice;

	/**
	 * Price added on a weekday.
	 */
	private static double weekdayPrice;

	/**
	 * Price added on a weekend.
	 */
	private static double weekendPrice;

	/**
	 * Price added on a holiday.
	 */
	private static double holidayPrice;

	/**
	 * The GST Rate.
	 */
	private static double GSTRate;

	/**
	 * Set the price added by a 3D movie ticket.
	 * @param price The price added by a 3D movie ticket.
	 */
	public static void set3DPrice(Double price) {
		_3DPrice = price;
	}

	/**
	 * Set the price added by a BlockBuster movie ticket.
	 * @param price The price added by a BlockBuster movie ticket.
	 */
	public static void setBlockBusterPrice(Double price) {
		blockBusterPrice = price;
	}

	/**
	 * Set the price added by a normal class cinema movie ticket.
	 * @param price The price added by a normal class movie ticket.
	 */
	public static void setNormalCinemaPrice(Double price) {
		normalCinemaPrice = price;
	}

	/**
	 * Set the price added by a plantinum class movie ticket.
	 * @param price The price added by a plantinum class movie ticket.
	 */
	public static void setPlantinumPrice(Double price) {
		plantinumPrice = price;
	}

	/**
	 * Set the price added by an elite class movie ticket.
	 * @param price The price added by an elite class movie ticket.
	 */
	public static void setElitePrice(Double price) {
		elitePrice = price;
	}

	/**
	 * Set the price added by a children movie ticket.
	 * @param price The price added by a children movie ticket.
	 */
	public static void setChildrenPrice(Double price) {
		childrenPrice = price;
	}

	/**
	 * Set the price added by an adult movie ticket.
	 * @param price The price added by an adult movie ticket.
	 */
	public static void setAdultPrice(Double price) {
		adultPrice = price;
	}

	/**
	 * Set the price added by a senior citizen ticket.
	 * @param price The price added by a senior citizen movie ticket.
	 */
	public static void setSeniorCitizenPrice(Double price) {
		seniorCitizenPrice = price;
	}

	/**
	 * Set the price added by a weekday movie ticket.
	 * @param price The price added by a weekday movie ticket.
	 */
	public static void setWeekdayPrice(Double price) {
		weekdayPrice = price;
	}

	/**
	 * Set the price added by a weekend movie ticket.
	 * @param price The price added by an weekend movie ticket.
	 */
	public static void setWeekendPrice(Double price) {
		weekendPrice = price;
	}

	/**
	 * Set the price added by a holiday movie ticket.
	 * @param price The price added by a holiday movie ticket.
	 */
	public static void setHolidayPrice(Double price) {
		holidayPrice = price;
	}

	/**
	 * Set the GST Rate
	 * @param taxRate GST Rate
	 */
	public static void setGSTRate(Double taxRate) {GSTRate = taxRate;}

	/**
	 * Get the price added by a 3D movie ticket.
	 * @return the price added by a 3D movie ticket.
	 */
	public static double get3DPrice() {
		return _3DPrice;
	}

	/**
	 * Get the price added by a BlockBuster movie ticket.
	 * @return the price added by a BlockBuster movie ticket.
	 */
	public static double getBlockBusterPrice() {
		return blockBusterPrice;
	}

	/**
	 * Get the price added by a normal class movie ticket.
	 * @return the price added by a normal class movie ticket.
	 */
	public static double getNormalCinemaPrice() {
		return normalCinemaPrice;
	}

	/**
	 * Get the price added by a plantinum movie ticket.
	 * @return the price added by a plantinum movie ticket.
	 */
	public static double getPlantinumPrice() {
		return plantinumPrice;
	}

	/**
	 * Get the price added by an elite movie ticket.
	 * @return the price added by an elite movie ticket.
	 */
	public static double getElitePrice() {
		return elitePrice;
	}

	/**
	 * Get the price added by a children movie ticket.
	 * @return the price added by a children movie ticket.
	 */
	public static double getChildrenPrice() {
		return childrenPrice;
	}

	/**
	 * Get the price added by an adult movie ticket.
	 * @return the price added by an adult movie ticket.
	 */
	public static double getAdultPrice() {
		return adultPrice;
	}

	/**
	 * Get the price added by a senior citizen movie ticket.
	 * @return the price added by a senior citizen movie ticket.
	 */
	public static double getSeniorCitizenPrice() {
		return seniorCitizenPrice;
	}

	/**
	 * Get the price added by a weekday movie ticket.
	 * @return the price added by a weekday movie ticket.
	 */
	public static double getWeekdayPrice() {
		return weekdayPrice;
	}

	/**
	 * Get the price added by a weekend movie ticket.
	 * @return the price added by a weekend movie ticket.
	 */
	public static double getWeekendPrice() {
		return weekendPrice;
	}

	/**
	 * Get the price added by a holiday movie ticket.
	 * @return the price added by a holiday movie ticket.
	 */
	public static double getHolidayPrice() {
		return holidayPrice;
	}

	/**
	 * Get the GST Rate.
	 * @return the GST Rate.
	 */
	public static double getGST() {return GSTRate;}
}
