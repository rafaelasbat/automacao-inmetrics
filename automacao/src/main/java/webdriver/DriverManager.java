package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	static WebDriver driver;

	public static WebDriver getChromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void quitChromeDriver() {
		if (driver != null) {
			driver = null;
			driver.quit();			
		}
	}
}
