package edu.smith.cs.csc212.spooky;

public class LockedExit extends Exit {
	
	public LockedExit(String target, String description) {
		super(target, description);

	}
			
	private boolean hidden=false;
	private static boolean locked=true;
	private static boolean open=false;

	

	private void key() {
		if ((isLocked()==true) && (key==true)){
			open=true;
		} else {
			open=false;
		}
			}
	}
