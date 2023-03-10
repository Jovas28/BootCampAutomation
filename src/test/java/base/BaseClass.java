package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	final public String USER_NAME = "";
	final public String EMAIL = "";
	final public String PASS = "";
	
	private final String _driverUrl = "C:\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe";

	public final String pageUrl = "https://academybugs.com/find-bugs/";
	public WebDriver driver;
	
	@BeforeClass
	public void setUpClass() {
		System.setProperty("webdriver.chrome.driver", _driverUrl);
		driver = new ChromeDriver();
		driver.get(pageUrl);
		driver.manage().window().maximize();
	}
}
