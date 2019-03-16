package processing;

/**
 * 
 * Class Gallow contains the method, that "draws" the gallow on the MainFrame.
 * A Gallow object created and held by the GameLoop.
 *
 */
public class Gallow {
	
	private int remainingLives;
	
	/**
	 * 
	 * Creates the filepath of the image to be displayed according to the amount of lives the player
	 * still has in the game. 
	 * Mutator method - mutates the filepath-String.
	 * 
	 */
	public String hangmanPath(int remainingLives)	{
		this.remainingLives = remainingLives;
		String imageString = "../BetterHangman/data/hangmanfigures/hangman_" 
								+ this.remainingLives + ".png";
		return imageString;
		
	}
}
