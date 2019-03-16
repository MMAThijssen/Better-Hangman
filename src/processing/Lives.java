package processing;
/**
 * Class Lives manages the amount of lives of a player in the hangman game. 
 * Live object is created and used by GameLoop.
 *
 */
public class Lives {
	/**
	 *  Private fields: lives is used to keep track of whether the losing conditions are fulfilled.
	 *  initialLives is used to keep tracks of how many lives have been lost (used in the Array
	 *  of wrongly guessed letters).
	 */
	private static Lives instance;
	private int initialLives = 7;
	private int lives;
	

	/**
	 *  Default Lives constructor
	 */
	private Lives() {  
		this.lives = initialLives;
	}
	
	/**
	 * Singleton constructor
	 */
	public static Lives getInstance() {
		if (instance == null) {
			instance = new Lives();
		}
		return instance;
	}
	
	/**
	 *  Sets lives to a specific value.
	 *  This method is solely used in the testing classes.
	 *  Mutator method.
	 */
	public void setLives(int lives)   {
		this.lives = lives;
	}
	
	/**
	 * Returns the state of the field lives for the called object.
	 * Accessor method.
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * Sets the initial lives
	 * Mutator method
	 * @param initialLives
	 */
	public void setInitialLives(int initialLives) {
		this.initialLives = initialLives;
		this.lives = initialLives;
	}
	
	/**
	 * Returns the state of the field initialLives for the called object.
	 * Accessor method.
	 */
	public int getInitialLives()   {
		return this.initialLives;
	}
	
	/**
	 * Subtracts 1 from the field lives in the current object (When player loses a life).
	 * Mutator method.
	 */
	public void subtract() {
		this.lives--;
	}
	
	/**
	 * Overloaded declaration. Subtracts a given int from the field lives in the current object.
	 * Mutator method.
	 */
	public void subtract(int number) {
		if(number>this.lives) {
			this.lives = 0;
		}
		else {
		this.lives = this.lives-number;
		}
	}

}
