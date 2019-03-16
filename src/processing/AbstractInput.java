package processing;

/**
 * Class AbstractInput is an abstract class that contains methods for obtaining and
 * checking input. 
 * Classes InputLetter and InputWord extend AbstractInput.
 *
 */
public abstract class AbstractInput {
	
	protected String input;
	protected Boolean isAlpha;

	/**
	 *  gets input.
	 *  Accessor method.
	 */
	public String getString() {
		return this.input;
	}

	/**
	 * Returns the information of whether the input is a letter.
	 * Accessor method.
	 */
	public boolean isAlpha() {
		return this.isAlpha;
	}
	
	/**
	 * Checks if the input is a Letter, lower or upper case and returns true if it is. 
	 * Returns false if it isn't.
	 * Used to mutate isAlpha.
	 */
	public void checkIfAlpha()   {		
		this.isAlpha = this.input.matches("[a-zA-Z]+");
	}
}
