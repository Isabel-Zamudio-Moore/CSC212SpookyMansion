package edu.smith.cs.csc212.spooky;

// Based off Spooky Mansion Class
// Lab buddy Talia
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author izamudiomoore
 *
 */

public class WorldsOfFun implements GameWorld {
	/**
	 *  Create an empty list of places
	 */
	private Map<String, Place> placeList = new HashMap<>();

	@Override
	public String getStart() {
		return "TheEntry";
	}		

	public WorldsOfFun() {
		Place TheEntry = insert(
				Place.create("TheEntry", "You are just at the entrance of the "
						+ "World of Fun theme park. Although you did not want to go, you decided."
						+ " to join a friend."));
				TheEntry.addExit(new Exit("Admissions", "Join your friend."));
				TheEntry.addExit(new SecretExit("OceansOfFun", "Try a new exit."));
				TheEntry.addExit(new Exit("OceansOfFun", "YOU HAVE FOUND THE SPECIAL DOOR."));

				
		
		Place Admissions = insert(
				Place.create("Admissions", "You are in line to get a ticket."+
						" You are about to enter the gate. Just as you guys go inside"+
						" Your friend gets caught up talking with a person on the outside of the park."
						+ " And cannot get back in. Admissions will not let you go back. They"
						+ " tell you to go through the exit once you get inside. What do you do now?" ));
		Admissions.addExit(new Exit("EntryWay", "Go inside reluctantly."));
		Admissions.addExit(new Exit("AdmissionsNoGo", "Stay and wait for your friend."));
		
		Place AdmissionsNoGo= insert(
				Place.create("AdmissionsNoGo", "Your friend ."));
		AdmissionsNoGo.addExit(new Exit("EntryWay", "Go inside reluctantly."));
		AdmissionsNoGo.addExit(new Exit("AdmissionsNoGo", "Stay and wait for your friend."));


		Place EntryWay= insert(
				Place.create("EntryWay", "You are just at the entrance of the building."));
				EntryWay.addExit(new Exit("SnoopyLand0", "Go inside and see SnoopyLand. Then, go to SnoopyLand without your friend."));

		Place Mamba = insert(
				Place.create("Mamba", "You are at a large roller coaster."));
		Mamba.addExit( new Exit ("ConcessionStands", "There are trucks heading north. Follow them?"));


		Place TimberWolf= insert(
				Place.create("TimberWolf", "You can get on this roller coaster that"
						+"will go upside down."));
		TimberWolf.addExit(new Exit("TimberWolf" , "Ride again?"));
		TimberWolf.addExit(new Exit("Hint", "Try this."));
		
				
		
		Place Hint= insert( 
				Place.create("Hint",  "You stuck...hahaha.... Just kidding. You will have to guess correctly"));
			Hint.addExit(new Exit("Hint", "Try again."));
			Hint.addExit(new Exit("ConcertArena", "This isn't a hint"));


		Place ConcertArena= insert(
				Place.create("ConcertArena", "You are in the concert arena. Here"
						+" concerts are held reguarly."));
		ConcertArena.addExit(new Exit("ConcessionStands", "From all that dancing you might want to get some water."));

		Place ConcessionStands= insert(
				Place.create("ConcessionStands", "There are food trucks outside. Hopefully, "
						+" the food takes good. Do you take your chances?"));
		ConcessionStands.addExit(new Exit("CrowdedExit", "There is a exit way that is not so crowded. Take it?"));


		Place GameStations= insert(
				Place.create("GameStations", "There are games where you can win prizes"+
						"Do you want to play?"));
		GameStations.addExit( new Exit("CrowdedExit", "There is an exit way that is clear. Take it?"));

		Place CrowdedExit= insert(
				Place.create("CrowdedExit", "There is a crowded exit. If you want to get passed"+
						"You'll need to get passed equipment that is in use by the theme park. There's no way out here."));
		CrowdedExit.addExit(new Exit("ConcertArena", "A group of friends are going to an event. Follow them?"));

		Place NewRollerCoaster = insert(
				Place.create("NewRollerCoaster", "There is a new rollercoaster. Would you like to visit it?"));
		NewRollerCoaster.addExit(new Exit("SnoopyLand0", "There's a pathway to a bright colored billboard. Go here?"));
		NewRollerCoaster.addExit(new Exit("OceansOfFun", "YOU HAVE UNLOCKED THE SPECIAL DOOR."));

	
	/**
	 * Create a for loop that goes the length of steps where we have a nested if statement
	 * 
	 */

	int Steps_SL = 4;
	int EndSLTrail= Steps_SL -1; 				
				
	for (int i=0; i<= EndSLTrail; i++) {
		Place SnoopyLand= insert(			
			Place.create("SnoopyLand"+ i, "You are in the remains of the once running"+
						" children's themed park called snoopy land. It was abandoned years ago."));
		System.out.print("You are"+ i+ "steps in.");
		System.out.print(Steps_SL);
		System.out.print(EndSLTrail);	

		// the nested if statement will tell us to keep going or go back or if it is the last
		//Step until we reach SnoopyLand go forward one more to get to the Oceans of fun
		if (i == 0) {
				SnoopyLand.addExit(new Exit("SnoopyLand"+(i+1), "Go around the corner towards the Carcel."));
				SnoopyLand.addExit(new Exit("NewRollerCoaster", "Go ahead to ride the new roller coaster instead."));
				SnoopyLand.addExit(new Exit("GameStations", "Try heading towards a game station instead."));
				SnoopyLand.addExit(new Exit("TimberWolf", "Head to the Timber Wolf instead."));
		} else if (i!= EndSLTrail) {
			SnoopyLand.addExit(new Exit("SnoopyLand"+(i+1), "Keep going around the Carcel."));
			SnoopyLand.addExit(new Exit("SnoopyLand"+(i-1), "Go back."));
		} else {
			SnoopyLand.addExit(new Exit("SnoopyLand"+(EndSLTrail-1), "Stay in Snoopyland Forver!"));
			SnoopyLand.addExit(new Exit("OceansOfFun", "Go through a special door."));
		}
	}
	
	
	//TODO Why do we not need a method here?
	Place OceansOfFun= insert(Place.terminal("OceansOfFun", "You are now in a place called Oceans of"+
			" Fun. Welcome to the new theme park."));

	}

	/**
	 *  Using the id received take player go to list of places and
	 *  @ return bring out corresponding place by bringing out the value of place
	 *  from the key id
	 */
	@Override
	public Place getPlace(String id) {
		return placeList.get(id);
	}


	/**From the list of places get the location's name and its description of options
	 * @param loc - this is the place we input
	 * @return place and description of options to player
	 */

	// TODO: Why does using at override create an error here?
	// if we change this to public why can we not define these
	// parameters
	private Place insert(Place loc) {
		placeList.put(loc.getId(), loc);
		return loc;
	}

}
