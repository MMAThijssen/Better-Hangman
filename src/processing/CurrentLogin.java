package processing;

/**
 * Class CurrentLogin holds current username and methods to log in and log out.
 *
 */
public class CurrentLogin {
	
	private static CurrentLogin current = null;
	private static String userName;
	
	private CurrentLogin() {	
	}
	
	/**
	 * Singleton constructor
	 */
	public static CurrentLogin getInstance(){
		if (current == null) {
			current = new CurrentLogin();
		}
		return current;
	}
	
	/**
	 * Method for resetting the userName field to null
	 * Mutator method
	 */
	public void logout()
	{
		CurrentLogin.userName = null;
	}

	/**
	 * Method for setting the userName string to the inserted userNAme
	 * Mutator method
	 * @param userName
	 */
	public void login(String userName) {
		CurrentLogin.userName = userName;
	}
	
	/**
	 * Method for getting the current userName
	 * Accessor method
	 */
	public String getLogin(){
		return userName;
	}
	
}
