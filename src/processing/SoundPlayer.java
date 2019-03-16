package processing;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Class SoundPlayer controls the playing of the sounds and the volume of 
 * the sounds played.
 *
 */
public class SoundPlayer
{
	private static SoundPlayer instance;
	private int volume = 50;
	
	private SoundPlayer(){
	}
	
	/**
	 * Singleton constructor
	 */
	public static SoundPlayer getInstance() {
		if (instance == null) {
			instance = new SoundPlayer();
		}
		return instance;
	}
	
	/**
	 * Method for setting the volume to a new value
	 * Mutator method
	 * @param newVolume
	 */
	public void setVolume(int newVolume) {
		volume = newVolume;	
	}
	
	/**
	 * Method for getting the current value of the volume
	 * Accessor method
	 */
	public int getVolume() {
		return this.volume;
	}
	
	/**
	 * Overloaded alternative Play method with volume control
	 * @param soundFileString
	 */
	private void Play(String soundFileString) {
		try {
			File soundFile = new File("../BetterHangman/data/sounds/" + soundFileString);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			float factor = 2;
			float range = gainControl.getMaximum() - (gainControl.getMinimum()/factor);
			float denominator = 100;
			float gain = (range * volume/denominator) + (gainControl.getMinimum()/factor);
			if (volume == 0.0){
				gainControl.setValue(gainControl.getMinimum());
			}
			else{
				gainControl.setValue(gain);
			}
			clip.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Method for playing the described sound
	 */
	public void wrongGuess() {
		Play("NFF-disabled.wav");
	}
	
	/**
	 * Method for playing the described sound
	 */
	public void correctGuess() {
		Play("NFF-bubbly.wav");
	}
	
	/**
	 * Method for playing the described sound
	 */
	public void youWin() {
		Play("NFF-win.wav");
	}
	
	/**
	 * Method for playing the described sound
	 */
	public void youLose() {
		Play("NFF-death-bell.wav");
	}
	
	/**
	 * Method for playing the described sound
	 */
	public void click() {
		Play("NFF-menu-04-b.wav");
	}

	/**
	 * Method for playing the described sound
	 */
	public void background(){
		Play("NFF-background.wav");
	}
}
