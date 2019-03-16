package processing;

import java.util.Arrays;

/**
 * Class InputLetter as a subclass of Input contains the methods to handle a single letter guess and check
 * the validity of a guessed Input.
 * 
 */

public class InputLetter extends AbstractInput
{
	private boolean notGuessedYet;

	/**
	 * Constructor only takes the input from the text field
	 */
	public InputLetter(String input) {	
		super.input = input.toLowerCase();
		checkIfAlpha();
	}	
	
	/**
	 * Returns the private boolean notGuessedYet.
	 * Accessor method.
	 */
	public boolean getNotGuessedYet() {
		return notGuessedYet;
	}

	/**
	 * Checks if the input has already been guessed. Adapts the private boolean notGuessedYet to the
	 * appropriate value after checking whether the letter has already been guessed.
	 */
	public void checkNotGuessedYet(String[] incorrectlyGuessed, String[] correctlyGuessed) {		
		if (Arrays.asList(correctlyGuessed).contains(this.input)||
				Arrays.asList(incorrectlyGuessed).contains(this.input)) {
			this.notGuessedYet = false;
		}
		else {
			this.notGuessedYet = true;
		}
	}
	
}

