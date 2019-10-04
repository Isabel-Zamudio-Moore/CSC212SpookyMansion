package edu.smith.cs.csc212.spooky;

//citation with guidance from TAs

public class SecretExit extends Exit{
	
	public SecretExit(String target, String description) {
		/**
		 * Allow Secret exit to access parameters Exit can.
		 *  Also, create variables
		 */
		super(target, description);
	}
	
	private static boolean hidden= true;

	private void search(){
		if ((isSecret()==true) && (search==true)){
			hidden=false;
			} else {	
			SecretExit.hidden=true;
			}
	}
	
	
	
		//public void search(){
			//if (description.contains("search") {
				//return true;
			//}
			//return false;
		//}
		// say that if search is true then secret exit
		//is no longer secret
	
}
	


