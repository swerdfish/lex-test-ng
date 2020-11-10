package exceptionhandling;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class ExpectedException {
	
	String message = "Ben";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		messageUtil.printMessage();
	}
	
	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + message;
		Assert.assertEquals(message, messageUtil.salutationMessage());
	}
	
	public Integer mul(int a, int b) {
		if (a > 10) {
			return a*b;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
}
