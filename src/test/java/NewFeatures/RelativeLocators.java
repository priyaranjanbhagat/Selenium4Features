package NewFeatures;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RelativeLocators {

	private WebDriver driver;
	private WebElement ele;
	private String baseUrl;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "https://youtube.com/@digitalfiverr";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void test() {

		
	}

}
