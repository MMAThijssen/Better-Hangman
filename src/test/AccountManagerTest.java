package test;

import junit.framework.TestCase;
import sql.AccountManager;
import sql.ReadoutDataBase;

public class AccountManagerTest extends TestCase {
	
	public void testAccountManager() {
		char[] password = {'e','d','i','t','e','d'};
		AccountManager newAccount = new AccountManager("test_blah", password);
		newAccount.createNewAccount();
		boolean contains = newAccount.findAccount(newAccount.getUserName());
		assertTrue(contains);
		
		AccountManager newAccount2 = new AccountManager("test", password);
		newAccount2.createNewAccount();
		boolean contains2 = newAccount2.findAccount(newAccount2.getUserName());
		System.out.println(contains2);
		assertTrue(contains2);
	}
	
	public void testCreateNewAccount() {
		char[] password = {'t', 'e', 's', 't'};
		AccountManager newAccount = new AccountManager("testcreate", password);
		newAccount.createNewAccount();
		boolean contains = newAccount.findAccount(newAccount.getUserName());
		assertTrue(contains);
		newAccount.deleteAccount();
	}
	
	public void testCheckPassword() {
		char[] password = {'e','d','i','t','e','d'};
		AccountManager testAccount = new AccountManager("test", password);
		boolean passwordMatches = testAccount.checkPassword();
		assertTrue(passwordMatches);
		
		char[] password2 = {'t', 'e', 's', 't', '1', '2', '3', '4'};
		AccountManager testAccount2 = new AccountManager("test", password2);
		boolean passwordMatches2 = testAccount2.checkPassword();
		assertFalse(passwordMatches2);
		
		char[] password3 = {'a', 'b', 'c', 't', 'e', 's', 't', '1', '2', '3'};
		AccountManager testAccount3 = new AccountManager("test", password3);
		boolean passwordMatches3 = testAccount3.checkPassword();
		assertFalse(passwordMatches3);
		
		
	}
	
	public void testLogIntoAccount() {
		char[] password = {'e','d','i','t','e','d'};
		char[] falsePassword = {'t','e','s','t'};
		AccountManager testAccount = new AccountManager("Harry", password);
		AccountManager testAccount2 = new AccountManager("Harry", falsePassword);
		AccountManager testAccount3 = new AccountManager("test_user_false", password);
		testAccount.createNewAccount();
		assertTrue(testAccount.logIntoAccount());
		assertFalse(testAccount2.logIntoAccount());
		assertFalse(testAccount3.logIntoAccount());
	}
	
	public void testEditUsername(){
		System.out.println("\n\n---------------------------------testEditUsername--------------------------------------");
		char[] password = {'t', 'e', 's', 't', '1', '2', '3'};
		AccountManager testAccount = new AccountManager("edit", password);
		ReadoutDataBase.showDataBase();
		System.out.println();
		testAccount.editUserName("Harry");
		ReadoutDataBase.showDataBase();
		
	}
	
	public void testEditPassword()
	{
		System.out.println("\n\n------------------------------------testEditPassword-----------------------------------");
		char[] password = "[C@300ffa5d".toCharArray();
		AccountManager testAccount = new AccountManager("test", password);
		char[] newPassword = {'e','d','i','t','e','d'};
		ReadoutDataBase.showDataBase();
		testAccount.editPassword(newPassword);
		System.out.println();
		ReadoutDataBase.showDataBase();
		
		
	}
	
	public void testDeleteAccount()
	{
		System.out.println("\n\n------------------------------------testdeleteAccount-----------------------------------");
		AccountManager testAccount = new AccountManager ("testDelete", "testDelete".toCharArray());
		testAccount.createNewAccount();
		ReadoutDataBase.showDataBase();
		testAccount.deleteAccount();
		System.out.println("");
		assertFalse(testAccount.findAccount("testDelete"));
		ReadoutDataBase.showDataBase();
		
	}
	
	public void testEditScore() {
		System.out.println("\n\n------------------------------------testEditScore-----------------------------------");
		int game_score=150;
		int lower_score=140;
		int higher_score=170;
		
		AccountManager tempAccount = new AccountManager("tempAccount", "temp".toCharArray());
		tempAccount.createNewAccount();
		tempAccount.editScore(game_score);
		assertEquals(game_score, tempAccount.getTotalScore());
		assertEquals(game_score, tempAccount.getHighScore());
		
		ReadoutDataBase.showDataBase();
		System.out.println();
		tempAccount.editScore(lower_score);
		assertEquals(game_score+lower_score, tempAccount.getTotalScore());
		assertEquals(game_score, tempAccount.getHighScore());
		
		tempAccount.editScore(higher_score);
		assertEquals(game_score+lower_score+higher_score, tempAccount.getTotalScore());
		assertEquals(higher_score, tempAccount.getHighScore());
		
		ReadoutDataBase.showDataBase();
		
		tempAccount.deleteAccount();
		
		
	}
	
	public void testPrintHighScores()
	{
		char[] password = {};
		AccountManager test = new AccountManager("", password);
		System.out.println(test.showTopTenHighScores());
	}
	
	public void testPrintTotalScores()
	{
		char[] password = {};
		AccountManager test = new AccountManager("", password);
		System.out.println(test.showTopFiveTotalScores());
	}
	
}
