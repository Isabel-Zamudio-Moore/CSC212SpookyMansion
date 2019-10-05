package edu.smith.cs.csc212.spooky;

/**
 * Create a class for locked exits
 * @author izamudiomoore
 *
 */
public class LockedExit extends Exit {
	
	/**
	 * In contructor allow us make Exit the parent
	 * @param target - exit name
	 * @param description - exit description
	 */
	public LockedExit(String target, String description) {
		super(target, description);

	}
	
	/**
	 *  Initially call the exit hidden
	 */
	private boolean hidden=false;
	
	/**
	 * Initially let the exit be locked
	 */
	private static boolean locked=true;
	
	/**
	 *  Initially do not let locked doors be open
	 */
	private static boolean open=false;

	
	/*
	 *  If the user has the key let the user open the door
	 */
	private void key() {
		if ((isLocked()==true) && (key==true)){
			open=true;
		} else {
			open=false;
		}
			}
	}
