package processing;

import java.util.Random;

/**
 * 
 * Class Vocabulary stores the vocabulary that the game knows and makes it accessible to the other
 * classes. Also contains the word the player has to guess. It manages the random picking of a word and methods
 * to make it accessible to the other classes. It contains the word string and the array with the word
 * split into single letters to check the winning conditions.
 *
 */

public class Vocabulary {
	
	private String[] vocabArray;
	private String word;
	private String[] wordArray;
			
	final String[] animalArray = {"dog", "cat", "otter", "alligator",
			"ant", "bear", "chimpanzee", "deer", "lion", "octopus", "panda",
			"turtle", "hamster", "horse", "seastar", "piper", "elephant", "lizard",
			"snake", "alpaca", "buffalo", "beaver", "badger", "crow", "cow", "crocodile", 
			"boar", "pig", "chicken", "parrot", "nightingale", "ladybug", "beetle", "whale",
			"mouse", "fox", "platypus", "tiger", "kiwi", "cockroach", "tarantula", "cobra",
			"dolphin", "crab", "sponge", "clownfish", "seahorse", "gazelle", "antelope", "cougar",
			"leopard", "panther", "cheetah", "shrimp", "lobster", "shark", "hedgehog",
			"goat", "eagle", "urchin", "zebra", "flamingo", "kangaroo", "hippopotamus", "puppy",
			"moose", "goose", "sheep", "duck", "seabass", "bison", "koala", "gibbon", "baboon",
			"giraffe", "owl", "fish", "reindeer", "penguin", "rabbit", "sloth", "pelican",
			"mammoth", "orca", "woodpecker", "roadrunner", "canary", "cuckatoo", "jellyfish",
			"coyote", "worm", "centipede", "bee", "squirrel", "bumblebee", "wildebeest",
			"wallabe", "moth", "bat", "sparrow", "swan", "hummingbird", "swallow", "toucan",
			"stork", "butterfly", "caterpillar", "lemur", "rhinocerus", "louse", "orangutan", "meerkat",
			"capybara", "ostrich", "tapir", "armadillo", "skunk", "anteater", "wombat", "okapi", "camel",
			"lynx", "mandrill", "warthog", "walrus", "jaguar", "manatee"};
	
	/**
	 * Default vocabulary constructor, initializes the vocabArray and uses random word from animal vocabulary
	 */
	public Vocabulary() {
		this.vocabArray = animalArray;
		pickRandomWord();
		wordToArray(word);
	}

	/**
	 *  Alternative word constructor, uses string as word
	 *  Used in testing classes
	 */
	public Vocabulary(String word) {
		this.vocabArray = animalArray;
		this.word = word;
		wordToArray(word);
	}
	
	/**
	 * Returns the vocabulary Array.
	 * Accessor method.
	 */
	public String[] getArray() {
		return vocabArray;
	}
	
	/**
	 * Returns word string.
	 * Accessor method.
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * Sets word to different string.
	 * Mutator method.
	 */
	public void setWord(String word) {
		this.word = word;
		wordToArray(word);
	}
	
	/**
	 * Picks random word from the animals Vocabulary, returns String.
	 * Accessor method.
	 */
	private void pickRandomWord() {
		
		int vocabularySize = vocabArray.length;
		Random randomNumber = new Random();
		
		int randomIndex = randomNumber.nextInt(vocabularySize);
		
		this.word =  vocabArray[randomIndex];
	}
	
	/**
	 * Converts the word string to a String array.
	 * Mutator method.
	 */
	public void wordToArray(String word) {
		String temp = word;
		int leng = temp.length();
		String[] wordArray = new String[leng];
		for(int i=0;i<leng;i++) {
			char c=temp.charAt(i);
			String d="" + c;
			wordArray[i]=d;
		}
		this.wordArray = wordArray;
	}
	
	/**
	 * Returns the word array.
	 * Accessor method.
	 */
	public String[] getWordArray() {
		return this.wordArray;
	}

}
