package processing;

/**
 * Class Score contains the scoring conditions for winning and losing the game in 
 * different difficulties and methods to apply those scores.
 *
 */
public class Score {
	
	/**
	 * 
	 * Score calculates the score obtained at the end of the game with the settleScore method.
	 * It is a singleton class.
	 *
	 */
	
	private static Score scoreObject;
	private int score = 0;
	private static final int winBonus = 300;
	private static final int difficultyBonus = 100;
	private static final int livesLostPenalty = -25;
	
	private Score() {
	}
	
	/**
	 * Returns the score object. If no score object has been created, one will be made.
	 * Accessor method.
	 */
	public static Score getInstance() {
		if (scoreObject == null) {
			scoreObject = new Score();
		}
		return scoreObject;
	}
	
	/**
	 * Returns the score integer.
	 * Accessor method.
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Resets score to zero.
	 * Mutator method.
	 */
	public void reset() {
		this.score = 0;
	}
	
	/**
	 * Settles the score after each turn. Is dependent on the Lives class for calculations.
	 * Subtracts points for losing lives.
	 * Mutator method.
	 */ 
	public void settleScore(int livesLeft, int initialLives) {
		int livesLost = initialLives - livesLeft;
		int difficulty = initialLives;
		int gameScore = (difficultyBonus/difficulty) + (livesLost * livesLostPenalty);
		gameScore = Math.round(gameScore);
		this.score = gameScore;
	}
	
	/**
	 * Applies winBonus after a game has been won.
	 */
	public void applyWinBonus() {
		this.score = score + winBonus;
	}
	
	

}
