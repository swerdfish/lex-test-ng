package priority;

import org.testng.annotations.Test;

public class NewTest {
	
	@Test(priority=6)
	public void c_method() {
		System.out.println("I'm in method C");
	}
	
	// 9 is the lowest priority in this test
	@Test(priority=9)
	public void b_method() {
		System.out.println("I'm in method B");
	}
	
	@Test(priority=1)
	public void a_method() {
		System.out.println("I'm in method A");
	}
	
	// 0 is highest priority in TestNG
	@Test(priority=0)
	public void e_method() {
		System.out.println("I'm in method E");
	}
	
	@Test(priority=3)
	public void d_method() {
		System.out.println("I'm in method D");
	}
	
	// Execution order: E, A, D, C, B

}
