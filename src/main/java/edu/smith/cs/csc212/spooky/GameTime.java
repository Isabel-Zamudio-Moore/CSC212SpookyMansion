package edu.smith.cs.csc212.spooky;

import java.util.Random;
public class GameTime {
	/**
	 * Create a variable that holds the amount of time
	 */
	int hour;
	
	/**
	 * Create a variable that tells us how many hours have passed since moving
	 */
	int hourPast;
	
	/**
	 * Create a variable that keeps track of all time passed in game
	 */
	private int GtStretch;
	
	public GameTime(int hour, int hourPast){
	// Initiate variables
	this.hour=hour;
	this.hourPast=hourPast;
	// Increase time when the class runs
	increaseHour();
	}

	/**
	 *  Create a method that increases the time elapsed
	 */
	public void increaseHour() {
		// Increase the time by the hours passed
		GtStretch+=hour+hourPast;
		}
	
	/**
	 *  Method that gives the time 
	 * @return the total time user has been in game
	 */
	public int getHour(){
		return GtStretch;
	}
}
