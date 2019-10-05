package edu.smith.cs.csc212.spooky;

// Based off Spooky Mansion from https://github.com/jjfiv/CSC212SpookyMansion
// Lab buddy Talia
import java.util.HashMap;
import java.util.Map;

/**
 * Create a class that lets us play the Worlds of Fun Game
 * @author izamudiomoore
 *
 */

public class WorldsOfFun implements GameWorld {
	/**
	 *  Create an empty map of places
	 */
	private Map<String, Place> placeList = new HashMap<>();

	
	/**
	 *  Go to the starting place
	 *  @return bring the place up to the user
	 */
	@Override
	public String getStart() {
		return "TheEntry";
	}		

	/**
	 * Create our Worlds of Fun World with the insert of places with
	 * exits as options
	 */
	public WorldsOfFun() {
		Place TheEntry = insert(
				Place.create("TheEntry", "You are just at the entrance of the "
						+ "World of Fun theme park. Although you did not want to go, you decided."
						+ " to join a friend."));
				TheEntry.addExit(new Exit("Admissions", "Join your friend."));
				TheEntry.addExit(new SecretExit("OceansOfFun", "Try a new exit."));
				TheEntry.addExit(new Exit("OceansOfFun", "YOU HAVE FOUND THE SPECIAL DOOR."));

				
		
		
		 Place Admissions = insert( Place.create("Admissions",
		  "You are in line to get a ticket. You are about to enter the gate. Just as you guys go inside"+
		  " Your friend gets caught up talking with a person on the outside of the park."+
		  " And cannot get back in. Admissions will not let you go back. They" +
		  " tell you to go through the exit once you get inside. What do you do now?"));
		 Admissions.addExit(new Exit("EntryWay", "Go inside reluctantly."));
		 Admissions.addExit(new Exit("AdmissionsNoGo", "Stay and wait for your friend."));
		 
		 Place AdmissionsNoGo= insert( 
				 Place.create("AdmissionsNoGo","Your friend ."));
		 AdmissionsNoGo.addExit(new Exit("EntryWay", "Go inside reluctantly."));
		 AdmissionsNoGo.addExit(new Exit("AdmissionsNoGo", "Stay and wait for your friend.")); 
		 
		 Place EntryWay= insert( 
				 Place.create("EntryWay","You are just at the entrance of the building."));
		 EntryWay.addExit(new Exit("ConcertArena", "Go to performance.")); 
		 EntryWay.addExit(new Exit("SnoopyLand0", "Go inside and see SnoopyLand. Then, go to SnoopyLand without your friend."));
		 EntryWay.addExit(new Exit("TimberWolf", "Ride the Timber Wolf."));
		 
		 Place Mamba = insert( Place.create("Mamba", "You are at a large roller coaster."));
		 Mamba.addExit( new Exit("ConcessionStands", "There are trucks heading north. Follow them?"));
		 Mamba.addExit( new Exit("GameStations", "Go play some games instead."));
		  
		 
		 Place TimberWolf= insert( Place.create("TimberWolf",
		  "You can get on this roller coaster that will go upside down."));
		 TimberWolf.addExit(new Exit("TimberWolf" , "Ride again?"));
		 TimberWolf.addExit(new Exit("Hint", "Try this.")); 
		 
		  Place Hint= insert( Place.create("Hint",
		  "You stuck...hahaha.... Just kidding. You will have to guess correctly"));
		 Hint.addExit(new Exit("Hint", "Try again.")); 
		 Hint.addExit(new Exit("ConcertArena", "This isn't a hint"));
		  
		  Place ConcertArena= insert( Place.create("ConcertArena",
		 "You are in the concert arena. Here" +" concerts are held reguarly."));
		 ConcertArena.addExit(new Exit("ConcessionStands", "From all that dancing you might want to get some water."));
		 ConcertArena.addExit(new Exit("Mamba","Ride the Mamba."));
		 
		 Place ConcessionStands= insert( Place.create("ConcessionStands",
		 "There are food trucks outside. Hopefully, "
		 +" the food takes good. Do you take your chances?"));
		 ConcessionStands.addExit(new Exit("CrowdedExit","There is a exit way that is not so crowded. Take it?"));
		 
		 
		 Place GameStations= insert( Place.create("GameStations",
		 "There are games where you can win prizes"+ "Do you want to play?"));
		 GameStations.addExit(new Exit("CrowdedExit", "There is an exit way that is clear. Take it?"));
		 GameStations.addExit(new Exit("NewRollerCoaster", "Go try a new rollercoaster."));
		 
		 Place CrowdedExit= insert( 
		Place.create("CrowdedExit", "There is a crowded exit. If you want to get passed"+
		 "You'll need to get passed equipment that is in use by the theme park. There's no way out here."));
		 CrowdedExit.addExit(new Exit("ConcertArena", "A group of friends are going to an event. Follow them?"));
		 Place NewRollerCoaster = insert( 
			Place.create("NewRollerCoaster", "There is a new rollercoaster. Would you like to visit it?"));
		 	NewRollerCoaster.addExit(new Exit("SnoopyLand0", "There's a pathway to a bright colored billboard. Go here?"));
		    NewRollerCoaster.addExit(new Exit("OceansOfFun", "YOU HAVE UNLOCKED THE SPECIAL DOOR."));

	
		/**
		 * Create a for loop that goes the length of steps where we have a nested if
		 * statement
		 */  
			  int Steps_SL = 4; int EndSLTrail= Steps_SL -1;
			  
			  for (int i=0; i<= EndSLTrail; i++) { Place SnoopyLand= insert(
			  Place.create("SnoopyLand"+ i, "You are in the remains of the once running"+
			  " children's themed park called snoopy land. It was abandoned years ago."));
			  System.out.print("You are"+ i+ "steps in."); System.out.print(Steps_SL);
			  System.out.print(EndSLTrail);
			  
			  // the nested if statement will tell us to keep going or go back or if it is the last 
			  //Step until we reach SnoopyLand go forward one more to get to the Oceans of fun 
			 if (i == 0) { 
			SnoopyLand.addExit(new Exit("SnoopyLand"+(i+1), "Go around the corner towards the Carcel."));
			 SnoopyLand.addExit(new Exit("NewRollerCoaster", "Go ahead to ride the new roller coaster instead."));
			 SnoopyLand.addExit(new Exit("GameStations", "Try heading towards a game station instead."));
			 SnoopyLand.addExit(new Exit("TimberWolf", "Head to the Timber Wolf instead.")); }
			 // if the step is not 0 nor the second to last step from the end of the trial you have these options
			 else if (i!= EndSLTrail) {
			  SnoopyLand.addExit(new Exit("SnoopyLand"+(i+1), "Keep going around the Carcel.")); SnoopyLand.addExit(new
			  Exit("SnoopyLand"+(i-1), "Go back.")); 
			  } else { SnoopyLand.addExit(new
			  Exit("SnoopyLand"+(EndSLTrail-1), "Stay in Snoopyland Forver!"));
			  SnoopyLand.addExit(new Exit("OceansOfFun", "Go through a special door.")); }
			  }
	
	// Create Ocean's of Fun as our terminal
	Place OceansOfFun= insert(Place.terminal("OceansOfFun", "You are now in a place called Oceans of"+	
		"Fun. Welcome to the new theme park."));

	checkTheExitsWork();
	
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
	private Place insert(Place loc) {
		placeList.put(loc.getId(), loc);
		return loc;
	}
	
	/**
	 *  Check if our our exits will 
	 *  get us where we want to go
	 */
	
	private void checkTheExitsWork() {
		// Initially no exit should be missing
		boolean missing=false;
		// check all places in the placeList
		for (Place loc: placeList.values()) {
			// Check all the exits in the place
			for (Exit E: loc.getVisibleExits()) {
				//make sure that each exit exists
				if (!placeList.containsKey(E.getTarget())) {
					missing= true;
				// Give user the error message
				System.err.println(" You don't have a all exits functioing.");
			}}
			
			//If there are some exits that don't work then mention it
		if (missing) {
			throw new RuntimeException("Some exits actually don't work.");
	
		}
		}
	}

}
