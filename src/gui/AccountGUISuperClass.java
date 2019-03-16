package gui;

import sql.AccountManager;

/**
 * Class AccountGUISuperClass is superclass to Account GUI
 * screens. Contains methods for enabling communication with the database.
 *
 */
public class AccountGUISuperClass extends GUISuperClass {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AccountManager activeAccount = new AccountManager();

	protected void guiSetUserName (String userName) {
		activeAccount.setUserName(userName);
	}
	
	protected void guiSetPassWord (char[] passWord) {
		activeAccount.setPassWord(passWord);
	}
	
	protected boolean guiLogIntoAccount() {
		return activeAccount.logIntoAccount();
	}
	
	protected void guiDeleteAccount() {
		activeAccount.deleteAccount();
	}
	
	protected void guiEditPassword(char[] newPassWord) {
		activeAccount.editPassword(newPassWord);
	}
	
	protected void guiEditUsername(String username) {
		activeAccount.editUserName(username);
	}
	
	protected boolean guiFindAccount(String username) {
		return activeAccount.findAccount(username);
	}
	
	protected void guiCreateNewAccount() {
		activeAccount.createNewAccount();
	}
	
	protected void guiEditAvatar(int avatarInt) {
		activeAccount.editAvatar(avatarInt);
	}
	
	protected int guiGetAvatar() {
		return activeAccount.getAvatar();
	}
	
	/**
	 * Method to go back to account menu. A sound is played.
	 * Mutator method.
	 */
	@Override
	public void backToMenu() {
		playSound.click();
		AccountScreen accountWindow = new AccountScreen();
		accountWindow.setLocationRelativeTo(null);
		accountWindow.setVisible(true);
		disposeCurrentScreen();
	}
	
	
	/**
	 * Method to return to start menu (the startscreen).
	 */
	protected void backToStartMenu() {
		super.backToMenu();
	}
	
	

	

	
	

}
