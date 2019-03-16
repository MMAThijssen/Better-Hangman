package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;


import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.SoundPlayer;

/**
 * Class GUISuperClass contains methods and variables for settings of a screen.
 *
 */
public class GUISuperClass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected final String FONT = "Dialog";
	protected final int TEXTSIZE = 22;
	protected final int BUTTONSIZE = 22;
	protected final int CORRECTWORDSIZE = 30;
	protected final Color BUTTONCOLOUR = new Color(168,198,116);
	
	Font textFont = new Font(FONT, Font.PLAIN, TEXTSIZE);
	Font buttonFont = new Font(FONT, Font.PLAIN, BUTTONSIZE);
	Font correctWordFont = new Font(FONT, Font.PLAIN, CORRECTWORDSIZE);		
	
	SoundPlayer playSound = SoundPlayer.getInstance();
	
	public void setScreenSize()  {
		setSize(1000, 680);
	}
	
	public GUISuperClass() throws HeadlessException {
		super();
	}

	public GUISuperClass(GraphicsConfiguration gc) {
		super(gc);
	}

	public GUISuperClass(String title) throws HeadlessException {
		super(title);
	}

	public GUISuperClass(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	protected void openScreen() {
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void disposeCurrentScreen() {
		this.dispose();
	}
	
	/**
	 * Method to go back to the start screen.
	 * Accessor method.
	 */
	public void backToMenu() {
		playSound.click();
		StartScreen startScreen = new StartScreen();
		startScreen.setLocationRelativeTo(null);
		startScreen.setVisible(true);
		disposeCurrentScreen();
	}

	
}