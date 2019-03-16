package test;

import junit.framework.TestCase;
import processing.Message;

public class MessageTest extends TestCase {
	
	public void testInstance() {
		Message message = Message.getInstance();
		assertNotNull(message);
	}
	
	public void testGetString() {
		Message message = Message.getInstance();
		assertNotNull(message.getString());
	}
	
	public void testSetMessage() {
		Message message = Message.getInstance();
		String string = "Hello world";
		message.setMessage(string);
		assertEquals(string, message.getString());
	}

}
