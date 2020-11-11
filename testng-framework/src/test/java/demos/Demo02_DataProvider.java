package demos;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Demo02_DataProvider {
	
	@Test(dataProvider = "credentials")
	public void f(String username, String password) {
		System.out.println("username: "+username);
		System.out.println("password: "+password);
	}
	
	// A data provider must return either Object[][] or Iterator<Object[]>
	@DataProvider(name = "credentials")
	public Object[][] dp() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "donhere";
		data[0][1] = "don@123";
		
		data[1][0] = "donhere1";
		data[1][1] = "don@123";
		
		data[2][0] = "donhere2";
		data[2][1] = "don@123";
		
		return data;
	}
}
