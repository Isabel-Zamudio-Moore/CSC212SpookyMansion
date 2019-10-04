package edu.smith.cs.csc212.spooky;

import java.util.Random;
public class GameTime {
	int hour;
	int hourPast;
	private int GtStretch;
	
	public GameTime(int hour, int hourPast){
		//TODO
		// does random use the integer
		//parameter as the largest value it could 
		// draw out or the value larger than
		// it could draw out.
	
	this.hour=hour;
	this.hourPast=hourPast;
	increaseHour();
	}

	public void increaseHour() {
		GtStretch+=hour+hourPast;
		}
	
	public int getHour(){
		return GtStretch;
	}
}
