package test;

import junit.framework.TestCase;
import processing.Gallow;

public class GallowTest extends TestCase {

	public void testStringOutput(){
		Gallow test = new Gallow();
		assertEquals(test.hangmanPath(0), "../BetterHangman/data/hangmanfigures/hangman_0.png");
	}
	
}
