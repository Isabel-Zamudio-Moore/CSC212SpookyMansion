package edu.smith.cs.csc212.spooky;

import java.util.List;
import java.util.Objects;

/**
 * This class represents an exit from a Place to another Place.
 * @author jfoley
 *
 */
public class Exit {
	/**
	 * How do we describe this exit to a user, e.g., "A door with a spiderweb."
	 */
	private String description;
	/**
	 * How do we identify the Place that this is going.
	 */
	private String target;
	
	/**
	 * Create a new Exit.
	 * @param target - where it goes.
	 * @param description - how it looks.
	 */
	public Exit(String target, String description) {
		this.description = description;
		this.target = target;
	}
	
	/**
	 * A getter for the description of this exit.
	 * @return how it looks.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * A getter for the target place of this exit.
	 * @return where it goes.
	 */
	public String getTarget() {
		return this.target;
	}
	
	/**
	 * Make this debug-able when we print it for ourselves.
	 */
	public String toString() {
		return "Exit("+this.description+", "+this.target+")";
	}
	
	/**
	 * Make it so we can put this in a HashMap or HashSet.
	 */
	public int hashCode() {
		return Objects.hash(this.description, this.target);
	}
	
	/**
	 * This is a useful definition of being the same.
	 * @param other - another exit.
	 * @return if they go to the same place.
	 */
	public boolean goesToSamePlace(Exit other) {
		return this.target.equals(other.target);
	}
	
	/**
	 * Determine if the exit has been hidden
	 */
	
	private boolean hidden=false;
	
	/**
	 * The other half of hashCode that lets us put it in a HashMap or HashSet.
	 */
	public boolean equals(Object other) {
		if (other instanceof Exit) {
			Exit rhs = (Exit) other;
			return this.target.equals(rhs.target) && this.description.equals(rhs.description); 
		}
		return false;
	}
	
	/**
	 * Initially create a boolean for
	 * Exit and its children that tells
	 * us if a exit is secret
	 * @return whether exit is secret
	 */
	public boolean isSecret() {
			if ((this.description!="Try a new exit.")) {
			return false;
			} else {
			return true;
			}}
	
	/** 
	 * Initially search is false
	 */
	public static boolean search= false;
	
	/**
	 *  Search becomes true if user
	 *  types search that suggest the
	 *  game search for an exit
	 */
	private void search(){
		if ((isSecret()==true) && (search==true)){
			hidden= false;
			} else {}
	}
		
	/**
	 * Differentiate locked doors from open doors
	 * @return if the door is locked or not
	 */
	public boolean isLocked() {
		if ((this.description!= "YOU HAVE FOUND THE SPECIAL DOOR.")) {
		return false;
			} else {
		return true;
	}}
	
	/**
	 * Create a boolean for if key is had 
	 */
	public static boolean key= false;
	
	/**
	 * Create a boolean for if door is open
	 */
	private static boolean open= true;
	
	/**
	 *  Open the door if the key is found
	 */
	private void key() {
		if ( ((isLocked()==true) && (key==true)) | (isLocked()==false) ) {
			open=true;
		} else {
			open=false;
			}
		
		}
		
	

}	

