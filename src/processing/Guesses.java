package processing;

import java.util.Arrays;

/**
 * Class Guesses holds the arrays of correctly and incorrectly guessed letters as well
 * as the methods to access and mutate them. Furthermore, it sets the initial Array of underscores
 * to the length of the word set by the game.
 *
 */

public class Guesses {
	
	private String[] correctlyGuessed;
	private String[] incorrectlyGuessed = new String[26];
	private SoundPlayer playSound = SoundPlayer.getInstance();
	private Message message = Message.getInstance();
	private Vocabulary word = new Vocabulary();
	private Lives lives = Lives.getInstance();
	
	private static final String GUESS_NEXT_MSG = "Guess another letter:";
	private static final String NOT_LETTERS_MSG = "Please limit yourself to letters only. Try again:";
	private static final String ALREADY_GUESSED_MSG = "You already guessed this letter. Try again:";
	private static final String CORRECT_WORD_MSG = "You guessed it!";
	private static final String WRONG_WORD_MSG = "You guessed wrong.";
	private static final String WRONG_LENGTH_MSG = "Try something with the same length as the word.";
	
	/**
	 * Initializes Guesses using an integer for the number of initial lives. 
	 * It sets the array of underscores in the length of the word and gives 
	 * the number of initial lives to a lives object.
	 */
	public Guesses(int initialLives) {
		setUnderscores();
		lives.setInitialLives(initialLives);
	}

	/**
	 * Sets GameLoop word object to a different word. Solely for testing purposes.
	 * Mutator method.
	 */
	public void setWord(String newWord) {
		word.setWord(newWord);
		setUnderscores();
	}
	
	/**
	 * Returns Vocabulary word string.
	 * Accessor method.
	 */
	public String getWord() {
		return this.word.getWord();
	}
	
	/**
	 * Returns word array.
	 * Accessor method.
	 * @return
	 */
	public String[] getWordArray() {
		return this.word.getWordArray();
	}
	
	/**
	 *  Returns correctlyGuessed
	 *  Accessor method.
	 */
	public String[] getCorrectlyGuessed() {
		return this.correctlyGuessed;
	}

	/**  
	 * Returns correctlyGuessed
	 * Accessor method.
	 */
	public String[] getIncorrectlyGuessed() {  
		return this.incorrectlyGuessed;
	}

	/**
	 * Returns int livesLeft.
	 * Accessor method.
	 */
	public int getLivesLeft() {
		return lives.getLives();
	}
	
	/**
	 * Returns int initialLives.
	 * Accessor method.
	 */
	public int getInitialLives() {
		return lives.getInitialLives();
	}
	
	/**
	 * Returns message string.
	 * Accessor method.
	 */
	public String getMessage() {
		return message.getString();
	}
	
	/**
	 * Sets correctlyGuessed array to underscores.
	 * Mutator method.
	 */
	private void setUnderscores() {
		String[] underscoreArray = new String[word.getWord().length()];
		Arrays.fill(underscoreArray, "_");
		this.correctlyGuessed = underscoreArray;
	}
	
	/**
	 * Processes string guess.
	 * Mutator method.
	 * @param guess
	 */
	public void giveGuess(String guess) {
		String wordString = this.word.getWord();
		if (guess.length() == 1) {
			InputLetter inputLetter = new InputLetter(guess);
			guessLetter(inputLetter);
		}
		else if(guess.length() == wordString.length()) {
			InputWord inputWord = new InputWord(guess);
			guessWord(inputWord);
		}
		else {
			message.setMessage(WRONG_LENGTH_MSG);
		}
	}
	
	/**
	 * Processes the inputLetter
	 * @param inputLetter
	 */
	private void guessLetter(InputLetter inputLetter) {
		inputLetter.checkNotGuessedYet(incorrectlyGuessed, correctlyGuessed);
		if (inputLetter.isAlpha() && inputLetter.getNotGuessedYet()) {
			updateGuessedLetters(inputLetter);
			message.setMessage(GUESS_NEXT_MSG);
		}
		else if (inputLetter.isAlpha() == false) {
			message.setMessage(NOT_LETTERS_MSG);
			playSound.wrongGuess();
		}
		else if (inputLetter.getNotGuessedYet() == false) {
			message.setMessage(ALREADY_GUESSED_MSG);
			playSound.wrongGuess();
		}
	}
	
	/**
	 * Processes the guess if a word was guessed
	 * @param inputWord
	 */
	private void guessWord(InputWord inputWord) {
		if(inputWord.isAlpha() == false) {
			message.setMessage(NOT_LETTERS_MSG);;
		}
		else if(inputWord.getString().equals(word.getWord())) {
			for (int i=0; i<word.getWordArray().length; i++) {
				InputLetter wordLetter = new InputLetter(word.getWordArray()[i]);
				updateGuessedLetters(wordLetter);
				message.setMessage(CORRECT_WORD_MSG);
				playSound.correctGuess();
			}
		}
		else {
			lives.subtract(2);
			message.setMessage(WRONG_WORD_MSG);
			playSound.wrongGuess();
		}
	}
	
	/**
	 *  Evaluates whether inputLetter is present in word
	 *  If it is, it updates correctlyGuessed
	 *  If it's not, it updates incorrectlyGuessed and subtracts a life
	 *  Mutator method.
	 */
	private void updateGuessedLetters(InputLetter inputLetter) {
		int position = word.getWord().indexOf(inputLetter.getString());
		if (position != -1) {
			playSound.correctGuess();
			updateCorrectlyGuessed(inputLetter);
		}
		else {
			playSound.wrongGuess();
			updateIncorrectlyGuessed(inputLetter);
			lives.subtract();
		}
	}
	
	/**
	 *  Updates the array of wrongly guessed Letters as a function of livesLost (the index of the
	 *  array element to be updated) and guessedLetter (what it is going to be updated to).
	 *  Mutator method.
	 */
	private void updateIncorrectlyGuessed(InputLetter inputLetter) {
		int i = 0;
		while (i<this.incorrectlyGuessed.length && this.incorrectlyGuessed[i] != null ) {
			i++;
		}
		if (this.incorrectlyGuessed[i] == null) {
			this.incorrectlyGuessed[i] = inputLetter.getString();
		}
	}
	
	/**
	 *  Updates the array of correctly guessed letters and makes it into a string to display 
	 *  in the GUI.
	 *  Mutator method.
	 */
	private void updateCorrectlyGuessed(InputLetter inputLetter) {
		for (int i=0; i<word.getWordArray().length; i++)
			if (word.getWordArray()[i].matches(inputLetter.getString())) {
				this.correctlyGuessed[i]=inputLetter.getString();
			}
	}
}
