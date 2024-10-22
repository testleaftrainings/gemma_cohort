package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static RemoteWebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void preSetup() throws InterruptedException, MalformedURLException {
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--disable-notifications"); driver = new
		 * ChromeDriver(options);
		 */
	
		  EdgeOptions options = new EdgeOptions(); 
		  DesiredCapabilities dc = new DesiredCapabilities(options); 
		  dc.setBrowserName("MicrosoftEdge"); //
		//  dc.setVersion("120.0"); 
		  dc.setPlatform(Platform.LINUX);
		  driver = new RemoteWebDriver(new
		  URL("http://20.40.48.160:4444/wd/hub"), dc);
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public void waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void switchFrame(By locator) {
		driver.switchTo().frame(driver.findElement(locator));
	}
}
