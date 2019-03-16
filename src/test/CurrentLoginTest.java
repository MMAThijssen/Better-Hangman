package test;

import junit.framework.TestCase;
import processing.CurrentLogin;

public class CurrentLoginTest extends TestCase {

	public void testGetLogin(){
		String userName = "Ton";
		CurrentLogin currentLogin = CurrentLogin.getInstance();
		currentLogin.login(userName);
		assertEquals(currentLogin.getLogin(),userName);
		currentLogin.logout();
	}
	
	public void testNoLogin(){
		CurrentLogin currentLogin = CurrentLogin.getInstance();
		assertNull(currentLogin.getLogin());
	}
}
