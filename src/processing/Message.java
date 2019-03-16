package processing;

/**
 * Class Message sets the message strings for message to be displayed in the screens.
 *
 */
public class Message {
	
	private static Message instance;
	private String string = "";

	private Message() {
	}
	
	/**
	 * Singleton constructor
	 * @return
	 */
	public static Message getInstance() {
		if (instance == null) {
			instance = new Message();
		}
		return instance;
	}
	
	/**
	 * Sets the message String
	 * Mutator method
	 * @param message
	 */
	public void setMessage(String message) {
		this.string = message;
	}
	
	/**
	 * Returns the message String
	 */
	public String getString() {
		return this.string;
	}
}
