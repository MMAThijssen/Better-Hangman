package test;
import junit.framework.TestCase;
import processing.Lives;

public class LivesTest extends TestCase 
{
		
	// test default constructor
	public void testLives()
	{
		Lives test = Lives.getInstance();
		test.setLives(7);
		assertEquals(7, test.getLives());
	}
	
	public void testSetGetLives()
	{
		Lives testLives = Lives.getInstance();
		testLives.setLives(3);
		assertEquals(testLives.getLives(),3);
	}
	
	//
	public void testSetInitialLives()   {
		Lives testLives = Lives.getInstance();
		testLives.setInitialLives(8);
		assertEquals(testLives.getInitialLives(),8);
		assertEquals(testLives.getLives(),8);
	}
	
	public void testSubtractLife()
	{
		Lives testSubtract = Lives.getInstance();
		testSubtract.setLives(3);
		testSubtract.subtract();
		assertEquals(testSubtract.getLives(),2);
	}
	
	public void testSubtractLifeOverload() {
		Lives test = Lives.getInstance();
		test.setLives(7);
		test.subtract(3);
		assertEquals(test.getLives(), 4);
		
		test.setLives(7);
		test.subtract(8);
		assertEquals(test.getLives(), 0);
	}
	
	
}
