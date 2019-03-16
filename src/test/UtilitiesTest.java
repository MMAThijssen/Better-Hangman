package test;

import junit.framework.TestCase;
import processing.GameLoop;

public class UtilitiesTest extends TestCase {
	//tests the String[] version via one of Utilities' subclasses
	public void testMakeArrayIntoString()   {
		GameLoop gameLoop = new GameLoop(7);
		String testWord = " a b c d ";
		String[] testArray = {"a","b","c","d"};
		assertEquals(gameLoop.makeArrayIntoString(testArray, " "),testWord);	
	}
	
	//tests the char[] version via one of Utilities' subclasses
	public void testMakeArrayIntoString2()   {
		GameLoop gameLoop = new GameLoop(7);
		String testWord = " a b c d ";
		char[] testArray = {'a','b','c','d'};
		assertEquals(gameLoop.makeArrayIntoString(testArray, " "),testWord);	
	}
}

