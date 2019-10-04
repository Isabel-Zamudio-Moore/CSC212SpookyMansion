package edu.smith.cs.csc212.spooky;

import java.util.List;
import java.util.Random;

/**
 * This is our main class for SpookyMansion.
 * It interacts with a GameWorld and handles user-input.
 * It can play any game, really.
 *
 * @author jfoley
 *
 */
public class InteractiveFiction {
			public static int hour=0;
			public static int hourPast;
			public static int actualT;
			public static Random random= new Random();


	/**
	 * This method actually plays the game.
	 * @param input - a helper object to ask the user questions.
	 * @param game - the places and exits that make up the game we're playing.
	 * @return where - the place the player finished.
	 */
	static String runGame(TextInput input, GameWorld game) {
		// This is the current location of the player (initialize as start).
		// Maybe we'll expand this to a Player object.
		String place = game.getStart();

		// Play the game until quitting.
		// This is too hard to express here, so we just use an infinite loop with breaks.
		while (true) {
			// Print the description of where you are.
			Place here = game.getPlace(place);
			
			System.out.println();
			System.out.println("... --- ...");
			// The place where we are and the exact location we are in is printed.
			System.out.println("Place: "+place);
			System.out.println("Here: "+here);
			
			
			
			
			// Tell us the description about the location we're in
			System.out.println(here.getDescription());
			System.out.println();
			
			// Now let's check if the location is a place we already have seen before and comment on this
			if (here.alreadyVisted()){
				System.out.println("Haven't you been here?");
			}
			// Now that we have gone to the place this location is now visited
			here.visit();
			
			// Generate a random integer
			hourPast= random.nextInt(23);
			// Assign the new values to gametime
			GameTime Gt= new GameTime(hour, hourPast);
			// Actually return the hour
			actualT+= Gt.getHour();
			int dayT=actualT%24;
			// Tell us the time if 12 or more hours have passed
			if (hourPast>=12) {				
				System.out.println(hourPast+" hrs. more have passed."); 
			}
			System.out.println("It is "+ dayT +":00 in the day.");
			

			// Game over after print!
			if (here.isTerminalState()) {
				System.out.println("You have been in the game for "+ actualT+" hours.");
				break;
			}

			// Show a user the ways out of this place.
			List<Exit> exits = here.getVisibleExits();

			for (int i=0; i<exits.size(); i++) {
				Exit e = exits.get(i);
				if ((e.key==false)&& (e.isLocked()==true)) {
					System.out.println(" "+ i+". You cannot go here because the door is locked.");
				} else {
				System.out.println(" "+i+". " + e.getDescription());
			}
			}

			// Figure out what the user wants to do, for now, only "quit" is special.
			List<String> words = input.getUserWords("?");
			if (words.size() > 1) {
				System.out.println("Only give the system 1 word at a time!");
				continue;
			}

			// Get the word they typed as lowercase, and no spaces.
			// Do not upper-case action -- I have lowercased it.
			String action = words.get(0).toLowerCase().trim();

				if (action.equals("search")) {
					Exit.search= true;
					continue;
				} else {
				} if (action.equals("key")) {
					Exit.key=true;
					continue;
				} else {
				} if (action.equals("help")) {
					System.out.println("Try choosing a integer option (0-n)."
							+ "Or try typing 'quit', 'q', or 'escape' to quit game.");
					continue;
				}	
				if (action.equals("quit") | action.equals("q")| action.equals("escape")) {
					if (input.confirm("Are you sure you want to quit?")) {
						return place;
				} else {
					continue;
				}
				
			}
		

			// From here on out, what they typed better be a number!
			Integer exitNum = null;
			try {
				exitNum = Integer.parseInt(action);
			} catch (NumberFormatException nfe) {
				System.out.println("That's not something I understand! Try a number!");
				continue;
			}

			if (exitNum < 0 || exitNum >= exits.size()) {
				System.out.println("I don't know what to do with that number!");
				continue;
			}

			// Move to the room they indicated.
			Exit destination = exits.get(exitNum);
			Exit destPrior= exits.get(0);
			if ((destination.key==false)&& (destination.isLocked()==true)) {
				//place= destination.(game.getStart());
			}
			place = destination.getTarget();
		}

		return place;
	}

	/**
	 * This is where we play the game.
	 * @param args
	 */    
	public static void main(String[] args) {
		// This is a text input source (provides getUserWords() and confirm()).
		TextInput input = TextInput.fromArgs(args);

		// This is the game we're playing.
		//GameWorld game = new SpookyMansion();
		GameWorld game= new WorldsOfFun();

		// Actually play the game.
		runGame(input, game);

		// You get here by typing "quit" or by reaching a Terminal Place.
		System.out.println("\n\n>>> GAME OVER <<<");
	}

}
