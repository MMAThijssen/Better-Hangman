
package test;

import java.util.Arrays;

import junit.framework.TestCase;
import processing.Vocabulary;


public class VocabularyTest extends TestCase 
{
	//author Marijke and Hans
	public void testVocabularyCreation()
	{
		 Vocabulary myVocabulary = new Vocabulary();
		 assertNotNull(myVocabulary);
	}
	
	//author Marijke and Hans
	public void testGetArray()
	{
		Vocabulary myVocabulary = new Vocabulary();
		String[] animalArray = new String[]{"dog", "cat", "otter", "alligator",
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
		String[] myArray = myVocabulary.getArray();
		assertEquals(Arrays.toString(animalArray), Arrays.toString(myArray));
	}
	
	public void testWord()   {
		// tests alternative word constructor that takes string as word
		Vocabulary testWord = new Vocabulary("puppy");
		assertEquals(testWord.getWord(),"puppy");
	}
	
	public void testRandomWord()   {
		// tests default word constructor that picks random word from animal vocabulary
		Vocabulary testWord = new Vocabulary();
		assertNotNull(testWord.getWord());
	}
	
	
	public void testWordToArray() {
		Vocabulary testWord = new Vocabulary();
		String[] testArray = {"t","u","r","t","l","e"};
		testWord.wordToArray("turtle");
		String[] array = testWord.getWordArray();
		assertEquals(Arrays.toString(array), Arrays.toString(testArray));
		//System.out.print(Arrays.toString(array));
	}
	
	public void testTypeOutput()
	{
		Vocabulary testWord = new Vocabulary();
		assertTrue(testWord.getWord() instanceof String);
		testWord.wordToArray(testWord.getWord());
		String[] testArray = testWord.getWordArray();
		assertTrue(testArray instanceof String[]);
	}
}
