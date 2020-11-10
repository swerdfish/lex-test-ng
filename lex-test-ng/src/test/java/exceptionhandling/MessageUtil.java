package exceptionhandling;

public class MessageUtil {
	
	String message;
	
	public MessageUtil() { }
	
	public MessageUtil(String message) {
		this.message = message;
	}

	public void printMessage() {
		System.out.println(message);
		int a = 0;
		int b = 1/a;
		System.out.println(b);
	}

	public String salutationMessage() {
		message = "Hi!"+message;
		System.out.println(message);
		return message;
	}

}
