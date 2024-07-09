package NewFeatures;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumFeatures {

	private WebDriver driver;
	private WebElement ele;
	private String baseURL;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		baseURL = "https://www.digitalfiverr.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void screenShot() throws IOException {
		driver.get(baseURL);
		WebElement logo = driver.findElement(By.id("logo"));

		File src = logo.getScreenshotAs(OutputType.FILE);
		File des = new File("logo.png");

		FileUtils.copyFile(src, des);

	}

	@Test
	public void openNewTab() throws InterruptedException {
		driver.get(baseURL);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(3000);
	}
	
	@Test
	public void openNewWindow() throws InterruptedException {
		driver.get(baseURL);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://www.youtube.com");
		Thread.sleep(3000);
	}

	@Test
	public void location() {
		driver.get(baseURL);
		WebElement logo = driver.findElement(By.id("logo"));
		System.out.println("Height : "+ logo.getRect().getDimension().getHeight());
		System.out.println("Width : "+ logo.getRect().getDimension().getWidth());	
		
		System.out.println("X location "+ logo.getRect().getX());
		System.out.println("Y location "+ logo.getRect().getY());
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
