package processing;

/**
 * 
 * Class InputWord contains a set of methods that check the validity of the player's input.
 * The InputWord object is handled by GameLoop and only created, if the user tries to guess the
 * whole word in the hangman game.
 *
 */

public class InputWord extends AbstractInput{

	/**
	 * Processes the inputWord to be only lower cases and all letters.
	 */
	public InputWord(String input) {
		super.input = input.toLowerCase();
		checkIfAlpha();
	}
	
}
