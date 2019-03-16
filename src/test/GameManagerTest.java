package test;


import junit.framework.TestCase;
import processing.GameManager;

// testing whether an object GameManager is created. 6 is a random number.
public class GameManagerTest extends TestCase {
		public void testGameManagerCreation()  {
			GameManager test = new GameManager(6);
			assertNotNull(test);
		}
}
