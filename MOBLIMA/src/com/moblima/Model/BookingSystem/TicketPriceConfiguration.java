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
	private double _3DPrice;

	/**
	 * Price added for a blockbuster movie.
	 */
	private double blockBusterPrice;

	/**
	 * Price added for a normal class cinema price.
	 */
	private double normalCinemaPrice;

	/**
	 * Price added for a plantinum class cinema price.
	 */
	private double plantinumPrice;

	/**
	 * Price added for an elite class cinema price.
	 */
	private double elitePrice;

	/**
	 * Price added by a children.
	 */
	private double childrenPrice;

	/**
	 * Price added by an adult.
	 */
	private double adultPrice;

	/**
	 * Price added by a senior citizen.
	 */
	private double seniorCitizenPrice;

	/**
	 * Price added on a weekday.
	 */
	private double weekdayPrice;

	/**
	 * Price added on a weekend.
	 */
	private double weekendPrice;

	/**
	 * Price added on a holiday.
	 */
	private double holidayPrice;

	/**
	 * The GST Rate.
	 */
	private double GSTRate;

	/**
	 * Set the price added by a 3D movie ticket.
	 * @param price The price added by a 3D movie ticket.
	 */
	public void set3DPrice(Double price) {
		_3DPrice = price;
	}

	/**
	 * Set the price added by a BlockBuster movie ticket.
	 * @param price The price added by a BlockBuster movie ticket.
	 */
	public void setBlockBusterPrice(Double price) {
		blockBusterPrice = price;
	}

	/**
	 * Set the price added by a normal class cinema movie ticket.
	 * @param price The price added by a normal class movie ticket.
	 */
	public void setNormalCinemaPrice(Double price) {
		normalCinemaPrice = price;
	}

	/**
	 * Set the price added by a plantinum class movie ticket.
	 * @param price The price added by a plantinum class movie ticket.
	 */
	public void setPlantinumPrice(Double price) {
		plantinumPrice = price;
	}

	/**
	 * Set the price added by an elite class movie ticket.
	 * @param price The price added by an elite class movie ticket.
	 */
	public void setElitePrice(Double price) {
		elitePrice = price;
	}

	/**
	 * Set the price added by a children movie ticket.
	 * @param price The price added by a children movie ticket.
	 */
	public void setChildrenPrice(Double price) {
		childrenPrice = price;
	}

	/**
	 * Set the price added by an adult movie ticket.
	 * @param price The price added by an adult movie ticket.
	 */
	public void setAdultPrice(Double price) {
		adultPrice = price;
	}

	/**
	 * Set the price added by a senior citizen ticket.
	 * @param price The price added by a senior citizen movie ticket.
	 */
	public void setSeniorCitizenPrice(Double price) {
		seniorCitizenPrice = price;
	}

	/**
	 * Set the price added by a weekday movie ticket.
	 * @param price The price added by a weekday movie ticket.
	 */
	public void setWeekdayPrice(Double price) {
		weekdayPrice = price;
	}

	/**
	 * Set the price added by a weekend movie ticket.
	 * @param price The price added by an weekend movie ticket.
	 */
	public void setWeekendPrice(Double price) {
		weekendPrice = price;
	}

	/**
	 * Set the price added by a holiday movie ticket.
	 * @param price The price added by a holiday movie ticket.
	 */
	public void setHolidayPrice(Double price) {
		holidayPrice = price;
	}

	/**
	 * Set the GST Rate
	 * @param taxRate GST Rate
	 */
	public void setGSTRate(Double taxRate) {GSTRate = taxRate;}

	/**
	 * Get the price added by a 3D movie ticket.
	 * @return the price added by a 3D movie ticket.
	 */
	public double get3DPrice() {
		return _3DPrice;
	}

	/**
	 * Get the price added by a BlockBuster movie ticket.
	 * @return the price added by a BlockBuster movie ticket.
	 */
	public double getBlockBusterPrice() {
		return blockBusterPrice;
	}

	/**
	 * Get the price added by a normal class movie ticket.
	 * @return the price added by a normal class movie ticket.
	 */
	public double getNormalCinemaPrice() {
		return normalCinemaPrice;
	}

	/**
	 * Get the price added by a plantinum movie ticket.
	 * @return the price added by a plantinum movie ticket.
	 */
	public double getPlantinumPrice() {
		return plantinumPrice;
	}

	/**
	 * Get the price added by an elite movie ticket.
	 * @return the price added by an elite movie ticket.
	 */
	public double getElitePrice() {
		return elitePrice;
	}

	/**
	 * Get the price added by a children movie ticket.
	 * @return the price added by a children movie ticket.
	 */
	public double getChildrenPrice() {
		return childrenPrice;
	}

	/**
	 * Get the price added by an adult movie ticket.
	 * @return the price added by an adult movie ticket.
	 */
	public double getAdultPrice() {
		return adultPrice;
	}

	/**
	 * Get the price added by a senior citizen movie ticket.
	 * @return the price added by a senior citizen movie ticket.
	 */
	public double getSeniorCitizenPrice() {
		return seniorCitizenPrice;
	}

	/**
	 * Get the price added by a weekday movie ticket.
	 * @return the price added by a weekday movie ticket.
	 */
	public double getWeekdayPrice() {
		return weekdayPrice;
	}

	/**
	 * Get the price added by a weekend movie ticket.
	 * @return the price added by a weekend movie ticket.
	 */
	public double getWeekendPrice() {
		return weekendPrice;
	}

	/**
	 * Get the price added by a holiday movie ticket.
	 * @return the price added by a holiday movie ticket.
	 */
	public double getHolidayPrice() {
		return holidayPrice;
	}

	/**
	 * Get the GST Rate.
	 * @return the GST Rate.
	 */
	public double getGST() {return GSTRate;}
}
