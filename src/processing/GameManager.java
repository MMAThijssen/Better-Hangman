package processing;

import gui.MainFrame;

/**
 * 
 * Class GameManager contains the method to start the MainFrame and thus initialize the game.
 *
 */

public class GameManager {
	private int initialLives;
	
	
	/**
	 * Constructor of GameManager. 
	 * Takes in integer to represent lives to start game with.
	 * @param lives
	 */
	public GameManager(int lives) {
		this.initialLives = lives;
	}
	
	/**
	 * Starts the MainFrame and thus initializes the game.
	 */
	public void startMainFrame() {
		MainFrame mainFrame = new MainFrame(initialLives);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}
