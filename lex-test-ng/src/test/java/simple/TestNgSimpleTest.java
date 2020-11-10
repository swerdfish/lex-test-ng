package simple;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestNgSimpleTest {
	
	@Test
	public void f() {
		String str = "TestNG is working fine";
		assertEquals(str, "TestNG is working fine");
	}
	
}
