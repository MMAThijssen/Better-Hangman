package test;

import gui.PopUpScreen;
import processing.Vocabulary;

public class PopUpTest {
	//testing the class PopUpWindow by first picking a random word from the vocabulary database followed by testing the winning and losing popups.
	public static void main(String[] args) {
	
	Vocabulary animal = new Vocabulary();
	int score = 100;
	
	PopUpScreen testPopUp = PopUpScreen.getInstance(animal.getWord());
	testPopUp.youWin(score);
	testPopUp.youLose(score);

	}

}
