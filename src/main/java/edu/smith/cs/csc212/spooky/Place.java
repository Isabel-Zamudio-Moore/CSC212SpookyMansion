package edu.smith.cs.csc212.spooky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This represents a place in our text adventure.
 * @author jfoley
 *
 */
public class Place {
	/**
	 * This is a list of places we can get to from this place.
	 */
	private List<Exit> exits;
	/**
	 * This is the identifier of the place.
	 */
	private String id;
	/**
	 * What to tell the user about this place.
	 */
	private String description;
	/**
	 * Whether reaching this place ends the game.
	 */
	private boolean terminal;
	
	/**
	 * Initially no place is visited
	 * @ return will tell us if visited has been marked as true or false/if the place has been visited
	 */
	private boolean visited= false;
	
	public String descItem;
	
	/**
	 * Internal only constructor for Place. Use {@link #create(String, String)} or {@link #terminal(String, String)} instead.
	 * @param id - the internal id of this place.
	 * @param description - the user-facing description of the place.
	 * @param terminal - whether this place ends the game.
	 */
	protected Place(String id, String description, boolean terminal) {
		this.id = id;
		this.description = description;
		this.exits = new ArrayList<>();
		this.terminal = terminal;
		//stuff(exits);
		List<Exit> vistedlist = new ArrayList<>(); 
	}
	
	/**
	 * Create an exit for the user to navigate to another Place.
	 * @param exit - the description and target of the other Place.
	 */
	public void addExit(Exit exit) {
		this.exits.add(exit);
	}
	
	/**
	 * Add a secret exit
	 */
	//	public void addSecretExit(SecretExit exit) {
	//		this.exits.add(exit);
	//}
	
	/**
	 * For gameplay, whether this place ends the game.
	 * @return true if this is the end.
	 */
	public boolean isTerminalState() {
		return this.terminal;
	}
	
	/**
	 * The internal id of this place, for referring to it in {@link Exit} objects.
	 * @return the id.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * The narrative description of this place.
	 * @return what we show to a player about this place.
	 */
	public String getDescription() {
		if (descItem==null){
			description=description;
		} else {
		description= description + descItem;
		} //else {}
		return this.description;
	}

	/**
	 * Get a view of the exits from this Place, for navigation.
	 * 
	 * @return all the exits from this place.
	 */
	public List<Exit> getVisibleExits() {
		List<Exit> visible = new ArrayList<>();
		for (Exit e : this.exits) {
			// Check if secret
			if (e.isSecret()==true) {
				//if secret add if search is true
				if (e.search==true) {
					visible.add(e);
				}
				
			} else {
			visible.add(e);
			}
		}
		return visible;
	}
	
	/**
	 * This is a terminal location (good or bad).
	 * @param id - this is the id of the place (for creating {@link Exit} objects that go here).
	 * @param description - this is the description of the place.
	 * @return the Place object.
	 */
	public static Place terminal(String id, String description) {
		return new Place(id, description, true);
	}
	
	/**
	 * Create a place with an id and description.
	 * @param id - this is the id of the place (for creating {@link Exit} objects that go here).
	 * @param description - this is what we show to the user.
	 * @return the new Place object (add exits to it).
	 */
	public static Place create(String id, String description) {
		return new Place(id, description, false);
	}
	
	/**
	 * Implements what we need to put Place in a HashSet or HashMap.
	 */
	public int hashCode() {
		return this.id.hashCode();
	}
	
	/**
	 * Give a string for debugging what place is what.
	 * @ return the place with its exits and number of exits
	 */
	public String toString() {
		return "Place("+this.id+" with "+this.exits.size()+" exits.)";
	}
	
	/**
	 * Whether this is the same place as another.
	 * @return if one place is an instance of another place
	 */
	public boolean equals(Object other) {
		if (other instanceof Place) {
			return this.id.equals(((Place) other).id);
		}
		return false;
	}
	
	
	/**
	 *  We have or have not visited this place depending on the boolean visited
	 * @return check if the place has been marked as visited
	 */
	public boolean alreadyVisted() {
				return this.visited;
		}
	/**
	 *  Mark the place as visited
	 *  @ return changes visited to a true statement
	 */
	public void visit(){
		this.visited=true;
	}
	
	
	/**
	 *  Create a list of items that we can place in rooms
	 */
	public void items() {
		List <String>items= new ArrayList<>();
			items.add("Special Key.");
			items.add("Prize bear.");
			items.add("Prize headphones.");
			items.add("Water bottle.");
			items.add("Admission ticket");
			items.add("Picture.");
			items.add("Concert Tshirt.");
			items.add("Timberwolf Picture.");
			}
	
}
