package test;

import java.util.Arrays;

import junit.framework.TestCase;
import processing.Guesses;

public class GuessesTest extends TestCase{

	public void testGetWord()
	{
		Guesses guesses = new Guesses(7);
		assertNotNull(guesses.getWord());
	}
	
	//Test for testing the constructor and the getCorrectlyGuessed() method.
	public void testSetCorrectlyGuessed()  {
		Guesses testgame = new Guesses(7);
		testgame.setWord("puppy");
		String[] testArray = {"_","_","_","_","_"};
		Arrays.equals(testgame.getCorrectlyGuessed(), testArray);
	}
	
	public void testGetIncorrectlyGuessed()   {
		Guesses testgame = new Guesses(7);
		testgame.setWord("puppy");
		testgame.getIncorrectlyGuessed();
		String[] nullArray = new String[26];
		Arrays.equals(testgame.getIncorrectlyGuessed(), nullArray);
	}
	
	public void testUpdateCorrectlyGuessed() {
		Guesses guesses = new Guesses(7);
		guesses.setWord("puppy");
		guesses.giveGuess("u");
		String[] testArray = {"_","u","_","_","_"};
		Arrays.equals(guesses.getCorrectlyGuessed(), testArray);
	}
	
	public void testUpdateIncorrectlyGuessed() {
		Guesses testgame = new Guesses(7);
		testgame.setWord("puppy");
		testgame.giveGuess("s");
		String[] Array = new String[26];
		Array[0] = "s" ;
		Arrays.equals(testgame.getIncorrectlyGuessed(), Array);
	}
	
	public void testGetMessage() {
		Guesses guesses = new Guesses(7);
		guesses.setWord("puppy");
		guesses.giveGuess("p");
		assertEquals("Guess another letter:", guesses.getMessage());
		guesses.giveGuess("#");
		assertEquals("Please limit yourself to letters only. Try again:", guesses.getMessage());
	}
	
}
