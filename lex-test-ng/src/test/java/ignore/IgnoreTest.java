package ignore;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class IgnoreTest {
	
	String message = "Ben";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test(enabled = false)
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "Ben";
		Assert.assertEquals(message, messageUtil.printMessage());
	}
	
	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!Ben";
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}

}
