 package processing;

import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.Hangman;
import gui.PopUpScreen;
import sql.AccountManager;

/**
 * 
 * GameLoop manages the progression of the game overall. It contains the methods necessary to check winning
 * and losing conditions. It also contains objects of the helper classes Word, Lives, GuessedLetters, Gallow
 * and PlaySound.
 *
 */

public class GameLoop extends Utilities {

	private Guesses guesses;
	private Gallow gallow = new Gallow();
	private String correctlyGuessedString;
	private String incorrectlyGuessedString = "";
	private boolean gameOver = false;
	
	CurrentLogin currentLogin = CurrentLogin.getInstance();
	String userName = currentLogin.getLogin();
	char[] password = {'d'};
	AccountManager account = new AccountManager(userName, password);

	private static final String GAME_OVER_MSG = "Oops! The game is already over!\nPress restart if you want to continue playing!";
	
	
	/**
	 * @param initialLives
	 * Initializes a gameloop using an integer for the number of initial lives.
	 * It initializes a Guesses object and calls method to set correctly guessed string.
	 */
	public GameLoop(int initialLives) {
		Score score = Score.getInstance();
		score.reset();
		this.guesses = new Guesses(initialLives);
		setCorrectlyGuessedString();
	}


	/** 
	 * Sets correctlyGuessed to the length of word, and converts it to string.
	 * Mutator method.
	 */
	private void setCorrectlyGuessedString() {
		String[] stringArray = guesses.getCorrectlyGuessed();
		String string = makeArrayIntoString(stringArray, " ");
		this.correctlyGuessedString = string;
	}
	
	/**
	 * Sets IncorrectlyguessedString to the incorrectly guessed letters and converts it to string
	 */
	private void setIncorrectlyGuessedString() {
		String[] stringArray = guesses.getIncorrectlyGuessed();
		String string = makeArrayIntoString(stringArray, "\n");
		this.incorrectlyGuessedString = string;
	}
	

	/**
	 *  Returns GameLoop's livesLeft variable.
	 *  Accessor.
	 */
	public int getLivesLeft() {
		return guesses.getLivesLeft();
	}
	
	/**
	 *  Returns GameLoop's initialLives variable.
	 *  Accessor.
	 */
	public int getInitialLives() {
		return guesses.getInitialLives();
	}
	
	/**
	 *  Returns GameLoop's initialLives variable.
	 *  Accessor.
	 */
	public Guesses getGuesses() {
		return this.guesses;
	}
	
	/**
	 *  References the interface Hangman so as to not have a circular reference between GameLoop
	 *  and MainFrame.	 *  
	 */
	public void updateGame(Hangman hm) {
		hm.updateHangman();
	}
	
	/**
	 * Gets underscore array to be displayed in the GUI.
	 * Accessor method.
	 */
	public String getCorrectlyGuessedString() {
		return this.correctlyGuessedString;
	}
	
	/**
	 * Gets array of incorrectly guessed letters
	 * Accessor method.
	 */
	public String getIncorrectlyGuessedString() {
		return this.incorrectlyGuessedString;
	}
	
	/**
	 * Returns GameLoop's instance of Gallow.
	 * Accessor method.
	 */
	public Gallow getGallow() {
		return this.gallow;
	}
	
	/**
	 *  Delegates the user's input to guessLetter and guessWord.
	 *  Delegator method.
	 */
	public void giveGuess(String guess) {
		if (gameOver) {			
			JOptionPane.showMessageDialog(null, GAME_OVER_MSG);	
		}
		else {
			guesses.giveGuess(guess);
			setIncorrectlyGuessedString();
			setCorrectlyGuessedString();
		}		
	}
	
	/**
	 * Returns the message String
	 * Accessor method
	 */
	public String getMessage() {
		return guesses.getMessage();
	}
	
	/**
	 * Checks for win or loss and triggers appropriate pop-up.
	 */
	public void checkGameState() {
		Score score = Score.getInstance();
		if ((checkLoss() || checkWin())) {
			PopUpScreen popUp = PopUpScreen.getInstance(guesses.getWord());
			if (checkLoss() == true && gameOver == false) {
				score.settleScore(getLivesLeft(), getInitialLives());
				popUp.youLose(score.getScore());
			}
			if (checkWin() == true && gameOver == false) {
				score.settleScore(getLivesLeft(), getInitialLives());
				score.applyWinBonus();
				popUp.youWin(score.getScore());
			}
			if (currentLogin.getLogin()!=null && gameOver == false) {
				account.editScore(score.getScore());
			}
			gameOver = true;
		}
	}
		
	
	/**
	 * Checks for loss by comparing lives to 0.
	 * Accessor.
	 */
	private boolean checkLoss() {
		Boolean result = false;
		if (getLivesLeft() == 0) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Checks if the guessed letters equals the to be guessed letters
	 * returns Boolean true if true
	 */
	private boolean checkWin() {
		boolean result = false;
		if (Arrays.equals(guesses.getWordArray(), guesses.getCorrectlyGuessed())) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Gets the image to be displayed on the GUI.
	 * Accessor.
	 */
	public Image getImage() {
		Image imageIcon = new ImageIcon(gallow.hangmanPath(getLivesLeft())).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		return imageIcon;
	}
	
	/**
	 * Gets the avatar to be displayed on the GUI.
	 * Accessor.
	 */
	public Image getAvatar() {
		Image imageIcon = new ImageIcon(account.avatarPath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		return imageIcon;
	}
	
	/**
	 * Returns the userName String
	 * Accessor method
	 */
	public String getUsername(){
		return currentLogin.getLogin();
	}
	
	/**
	 * Returns the totalScore String
	 * Accessor method
	 */
	public String getTotalScore(){
		String score = Integer.toString(account.getTotalScore());
		return score;
	}
	
	

}
