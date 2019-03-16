package processing;

/**
 * 
 * This abstract superclass contains some general methods used in GameLoop, AccountManager, ReadoutDatabase,
 *  and GuessesTest.
 *
 */

public abstract class Utilities {
	
	/**
	 * Turns a string array into a readable String.
	 * Mutator method.
	 */
	public String makeArrayIntoString (String[] array, String spacer) {
		String outputString = spacer;
		int i = 0;
		while (i<array.length && array[i]!=null) {
			if (spacer!="\n") {
				outputString += array[i] + spacer;
				i++;
				} 
			else {
				if ((i+1)%4!=0) {
					outputString += array[i] + "   ";
					i++;
				} 
				else {
					outputString += array[i] + spacer;
					i++;
				}
			}

		}
		
		return outputString;
	}
	
	/**
	 * Overloaded method.
	 * Turns a character array into a readable String.
	 * Mutator method.
	 */
	public String makeArrayIntoString (char[] array, String spacer) {
		String outputString = spacer;
		for (char letter : array)
			outputString += letter + spacer;
		return outputString;
	}
	
	/**
	 * Pads a String to the length of the padding value.
	 * So far only used to make the database readout a little prettier.
	 * Mutator method.
	 */
	public static String padLine (String word, int padding) {
		int addSpace = padding - word.length();
		String paddedWord = word;
		while (addSpace != 0)
				{
					paddedWord += " ";
					addSpace --;
				}
		return paddedWord;
	}
}
