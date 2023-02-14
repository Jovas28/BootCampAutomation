package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	final public String USER_NAME = "";
	final public String EMAIL = "";
	final public String PASS = "";
	
	private final String _driverUrl = "/Users/jovasguzman/Selenium/drivers/chromedriver_mac64/chromedriver";
	public final String pageUrl = "https://advantageonlineshopping.com";
	public WebDriver driver = new ChromeDriver();;
	
	@BeforeClass
	public void setUpClass() {
		System.setProperty("webdriver.chrome.driver", _driverUrl);
		driver.get(pageUrl);
		driver.manage().window().maximize();
	}
}
