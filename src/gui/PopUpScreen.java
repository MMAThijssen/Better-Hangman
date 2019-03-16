package gui;

import javax.swing.JOptionPane;

import processing.SoundPlayer;

/**
 * Class PopUpScreen creates a popup window that displays a different message when 
 * the win condition is true or false (true = win, false = loss). It also takes a second 
 * variable 'word' so the program can show the user what the word was
 *
 */
public class PopUpScreen {
	
	private static String wordString;
	private static PopUpScreen popUpScreen;
	
	private PopUpScreen() {
	}
	
	private static void setWord(String word) {
		wordString = word;
	}
	
	/**
	 * @param word
	 * @return
	 * Method that creates a new popup screen.
	 */
	public static PopUpScreen getInstance(String word) {
		if (popUpScreen == null) {
			popUpScreen = new PopUpScreen();
		}
		setWord(word);
		return popUpScreen;
	}
	
	/**
	 * Method that plays a losing sound, display a message that you have lost the game and 
	 * shows the correct word and scored points.
	 */
	public void youLose(int score) {
		SoundPlayer playSound = SoundPlayer.getInstance();
		playSound.youLose();
		JOptionPane.showMessageDialog(null, "Oh no! You lost..!\nYou were trying to guess: " + wordString +
				"\nYou scored " + score +" points!");
	}
	
		
	/**
	 * Method that plays a celebratory sound, display a message that you have won the game and 
	 * shows the correct word and scored points.
	 */
	public void youWin(int score) {
		SoundPlayer playSound = SoundPlayer.getInstance();
		playSound.youWin();
		JOptionPane.showMessageDialog(null, "Congratulations! You have won the game! \nThe word was indeed: " + wordString +
				"\nYou scored " + score +" points!");		
	}
}

