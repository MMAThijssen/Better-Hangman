package test;

import junit.framework.TestCase;
import processing.InputWord;

public class InputWordTest extends TestCase {
	
	public void testInput()   {
		InputWord input = new InputWord("");
		assertNotNull(input);
	}
	
	public void testInputArgument()   {
		InputWord input = new InputWord("word");
		assertEquals("word", input.getString());
	}
	
	public void testLowerCase()   {
		InputWord input = new InputWord("WORD");
		assertEquals(input.getString(),"word");
	}
	
	public void testGetIsValidLetters()   {
		InputWord input = new InputWord("word");
		assertTrue(input.isAlpha());
	}
	
	public void testInputCheckIfLetters()   {
		InputWord input1 = new InputWord("word");
		InputWord input2 = new InputWord("w0rd");
		InputWord input3 = new InputWord("1234");
		InputWord input4 = new InputWord("word!");
		
		assertTrue(input1.isAlpha());
		assertFalse(input2.isAlpha());
		assertFalse(input3.isAlpha());
		assertFalse(input4.isAlpha());
	}
	

}
