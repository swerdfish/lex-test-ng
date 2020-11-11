package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.DriverUtils;

public class Demo08_TestNG_Parameters_Optional {
	
	WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browserName", "url"})
	public void setup(@Optional("Firefox")String browserName, String url) {
		driver = DriverUtils.getDriver(browserName);
		driver.get(url);
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
				{"11", "priya", false},
				{"36", "Gellar", false},
				{"priyanka.chopra@quantico.com", "pChop&&82", true},
				{"nick.jonas@jbros.com", "nJona&&92", true},
		};
	}
	
	@Test(dataProvider="getData")
	public void login(String username, String password, Boolean success) {
		WebElement usernameElement = driver.findElement(By.id("username"));
		WebElement passwordElement = driver.findElement(By.id("password"));
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		driver.findElement(By.id("submit")).submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle']")));
		} catch (TimeoutException e) {
			if (success) throw e;
		}
		
		if (success) {
			driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
			Select menu = new Select(driver.findElement(By.xpath("//a[@class='dropdown-toggle']")));
			menu.selectByVisibleText("Logout");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
