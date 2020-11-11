package selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {
	
	private static WebDriver chromeDriver;
	private static WebDriver firefoxDriver;
	
	private static String geckoDriverPath = "src/test/resources/drivers/geckodriver.exe";
	private static String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";
	
	public static WebDriver getDriver(String driverType) {
		switch(driverType.toLowerCase()) {
		case "chrome":
			if (System.getProperty("webdriver.chrome.driver")==null)
				System.setProperty("webdriver.chrome.driver", new File(chromeDriverPath).getAbsolutePath());
			if (chromeDriver == null) chromeDriver = new ChromeDriver();
			return chromeDriver;
		case "firefox":
		case "gecko":
			if (System.getProperty("webdriver.gecko.driver")==null)
				System.setProperty("webdriver.gecko.driver", new File(geckoDriverPath).getAbsolutePath());
			if (firefoxDriver == null) firefoxDriver = new FirefoxDriver();
			return firefoxDriver;
		default:
			throw new IllegalArgumentException("Unrecognized driver type: "+driverType);
		}
	}

}
