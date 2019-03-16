package test;

import junit.framework.TestCase;
import processing.Guesses;
import processing.InputLetter;

public class InputLetterTest extends TestCase {
	
	//Test whether the inputGet function works
	public void testGetInput()
	{
		InputLetter testLetter = new InputLetter("a");
		InputLetter testNumber = new InputLetter("4");
		InputLetter testCharacter = new InputLetter("#");
		String myInputLetter = testLetter.getString();
		String myInputNumber = testNumber.getString();
		String myInputCharacter = testCharacter.getString();
		assertEquals(myInputLetter, "a");
		assertEquals(myInputNumber, "4");
		assertEquals(myInputCharacter, "#");
	}
	

	//Test whether a CheckInput object can be created and is not null.
	public void testCheckInput() {
		String testString = "Test";
		InputLetter newString = new InputLetter(testString);
		assertNotNull(newString);
	}
	
	//Method checks whether the output is as expected.
	//Checking a single letter or more than one letter should return true.
	//Checking a string that contains a symbol or a number should return false.
	public void testCheckIfLetter() {
		String validInput1="a";
		String validInput2="ok";
		String invalidInput1="1";
		String invalidInput2="a1";
		String invalidInput3="1a";
		String invalidInput4="b$";
		InputLetter valid1 = new InputLetter(validInput1);
		InputLetter valid2 = new InputLetter(validInput2);
		InputLetter invalid1 = new InputLetter(invalidInput1);
		InputLetter invalid2 = new InputLetter(invalidInput2);
		InputLetter invalid3 = new InputLetter(invalidInput3);
		InputLetter invalid4 = new InputLetter(invalidInput4);
		
		valid1.checkIfAlpha();
		valid2.checkIfAlpha();
		invalid1.checkIfAlpha();
		invalid2.checkIfAlpha();
		invalid3.checkIfAlpha();
		invalid4.checkIfAlpha();

		
		assertTrue(valid1.isAlpha());
		assertTrue(valid2.isAlpha());
		assertFalse(invalid1.isAlpha());
		assertFalse(invalid2.isAlpha());
		assertFalse(invalid3.isAlpha());
		assertFalse(invalid4.isAlpha());
	}
	
	//Checks a letter against two arrays and tests whether the outcome is as expected.
	//Checking a letter against two arrays, neither of which contains said letter should return true.
	//Checking a letter against two arrays, one (or both) of which contain said letter should return false.
	public void testNotGuessedYet() {
		Guesses guessedLetters = new Guesses(7);
		guessedLetters.setWord("test");
		guessedLetters.giveGuess("a");
		guessedLetters.giveGuess("b");
		guessedLetters.giveGuess("t");
		
		InputLetter invalid1 = new InputLetter("a");
		InputLetter invalid2 = new InputLetter("t");
		InputLetter valid1 = new InputLetter("s");
				
		invalid1.checkNotGuessedYet(guessedLetters.getCorrectlyGuessed(),guessedLetters.getIncorrectlyGuessed());
		invalid2.checkNotGuessedYet(guessedLetters.getCorrectlyGuessed(),guessedLetters.getIncorrectlyGuessed());
		valid1.checkNotGuessedYet(guessedLetters.getCorrectlyGuessed(),guessedLetters.getIncorrectlyGuessed());
		
		assertTrue(valid1.getNotGuessedYet());
		assertFalse(invalid1.getNotGuessedYet());
		assertFalse(invalid2.getNotGuessedYet());
	}

}
