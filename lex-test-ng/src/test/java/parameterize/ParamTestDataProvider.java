package parameterize;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ParamTestDataProvider {
	
	private PrimeNumberChecker primeNumberChecker;
	
	@BeforeMethod
	public void initialize() {
		primeNumberChecker = new PrimeNumberChecker();
	}
	
	// DataProvider must always return Object[][]
	@DataProvider(name = "test1")
	public static Object[][] primNumbers() {
		return new Object[][] {{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
	}
	
	// This test will run 5 times since we have 5 parameters defined
	// Note the object array is downcast to the appropriate class in the method (no primitives)
	@Test(dataProvider = "test1")
	public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
		System.out.println(inputNumber + " " + expectedResult);
		Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
	}

}
