package test;

import junit.framework.TestCase;
import processing.GameLoop;
import processing.Score;

// checkGamestate has been tested through acceptence tests, it has not failed once for any playtest, so we assume it works the works correctly
// all other methods that aren't included in this test class are not easily tested, we assume they work because they haven't failed in several weeks


public class GameLoopTest extends TestCase {
	public void testGameLoopCreation() {
		GameLoop gameLoop = new GameLoop(1);
		assertNotNull(gameLoop);
	}
	
	
	public void testGiveGuess() {
		// tests updateGuessedLetters and processGuess methods
		GameLoop gameLoop = new GameLoop(1);
		
		gameLoop.giveGuess("a");
		gameLoop.giveGuess("w");
		gameLoop.giveGuess("a");
		String test1 = gameLoop.getMessage();
		gameLoop.giveGuess("w");
		String test2 = gameLoop.getMessage();
		gameLoop.giveGuess("u");
		String test3 = gameLoop.getMessage();
		gameLoop.giveGuess("%");
		String test4 = gameLoop.getMessage();
		gameLoop.giveGuess("6");
		String test5 = gameLoop.getMessage();
		
		assertEquals(test1, "You already guessed this letter. Try again:");
		assertEquals(test2, "You already guessed this letter. Try again:");
		assertEquals(test3, "Guess another letter:");
		assertEquals(test4, "Please limit yourself to letters only. Try again:");
		assertEquals(test5, "Please limit yourself to letters only. Try again:");
		
	}
	
	public void testGetCorrectlyGuessedString(){
		GameLoop gameLoop = new GameLoop(1);
		String temp = gameLoop.getCorrectlyGuessedString();
		assertNotNull(temp);
	}
	
	public void testGetGallow()   {
		GameLoop gameLoop = new GameLoop(1);
		assertNotNull(gameLoop.getGallow());
	}
	
	public void testGetImage() {
		GameLoop gameLoop = new GameLoop(1);
		assertNotNull(gameLoop.getImage());
	}
	
	public void testUpdate()   {
		GameLoop gameLoop = new GameLoop(1);
		gameLoop.getGuesses().setWord("puppy");
		
		gameLoop.giveGuess("u");
		assertEquals(gameLoop.getGuesses().getCorrectlyGuessed()[1],"u");
		
		gameLoop.giveGuess("a");
		assertEquals(gameLoop.getGuesses().getIncorrectlyGuessed()[0], "a");
		assertEquals(gameLoop.getGuesses().getIncorrectlyGuessed()[1], null);
		
		gameLoop.giveGuess("p");
		assertEquals(gameLoop.getGuesses().getCorrectlyGuessed()[0], "p");
		assertEquals(gameLoop.getGuesses().getCorrectlyGuessed()[2], "p");
		assertEquals(gameLoop.getGuesses().getCorrectlyGuessed()[3], "p");
	}
	
	public void testCheckGameState_win() {
		int winBonus = 300;
		int difficultyBonus= 100;
		int livesLostPenalty = -25;
		
		GameLoop gameLoop = new GameLoop(5);
		gameLoop.getGuesses().setWord("puppy");
		
		Score score = Score.getInstance();
		assertEquals(score.getScore(), 0);
		
		gameLoop.checkGameState();
		assertEquals(score.getScore(), 0);
		
		gameLoop.giveGuess("puppy");
		gameLoop.checkGameState();
		int actualScore = winBonus + (difficultyBonus/5) + (0*livesLostPenalty);
		assertEquals(score.getScore(), actualScore);
	}
	
	public void testCheckGameState_lose() {
		int difficultyBonus= 100;
		int livesLostPenalty = -25;
		
		GameLoop gameLoop = new GameLoop(1);
		gameLoop.getGuesses().setWord("puppy");
		gameLoop.giveGuess("x");
		
		gameLoop.checkGameState();
		
		Score score = Score.getInstance();
		int actualScore = (difficultyBonus/1) + (1*livesLostPenalty);
		assertEquals(score.getScore(), actualScore);
	}


}
