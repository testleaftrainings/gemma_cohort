package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S625CreateLeagalEntitywithoutmandfiekds {
	
	@Test
	public void createLeagalentwithoutmandfields() throws InterruptedException, MalformedURLException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		//ChromeDriver driver = new ChromeDriver(option);
		//Login to https://login.salesforce.com
		driver.get("https://testleaf-7b-dev-ed.develop.my.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on the toggle menu button from the left corner
		WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		menu.click();
		//Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement entity = driver.findElement(By.xpath("//p[text()='Legal Entities']/parent::span"));
		wait.until(ExpectedConditions.elementToBeClickable(entity));
		action.moveToElement(entity).perform();
		js.executeScript("arguments[0].click();", entity);
		//Click on the Dropdown icon in the legal Entities tab
		try {
			WebElement Legalentdd=driver.findElement(By.xpath("//a[@title='Legal Entities']/following::lightning-icon"));
			wait.until(ExpectedConditions.elementToBeClickable(Legalentdd));
			js.executeScript("arguments[0].click();", Legalentdd);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			WebElement Legalentdd=driver.findElement(By.xpath("//a[@title='Legal Entities']/following::lightning-icon"));
			wait.until(ExpectedConditions.elementToBeClickable(Legalentdd));
			
		}
		//Click on New Legal Entity
		WebElement legalentity = driver.findElement(By.xpath("//span[text()='New Legal Entity']/ancestor::a"));
		Thread.sleep(2500);
		js.executeScript("arguments[0].click();", legalentity);
		//Enter the Company name as 'Tetsleaf'.
		WebElement cname = driver.findElement(By.xpath("//label[text()='Company Name']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(cname));
		cname.sendKeys("TestLeaf");
		//Enter Description as 'SalesForce'.
		WebElement desc = driver.findElement(By.xpath("//label[text()='Description']/following::textarea"));
		desc.sendKeys("SalesForce");
		//Select Status as 'Active'
		WebElement stat = driver.findElement(By.xpath("//label[text()='Status']/following::button"));
		js.executeScript("arguments[0].scrollIntoView(true)", stat);
		wait.until(ExpectedConditions.elementToBeClickable(stat));
		js.executeScript("arguments[0].click();", stat);
		WebElement act = driver.findElement(By.xpath("//span[text()='Active']/parent::span"));
		wait.until(ExpectedConditions.elementToBeClickable(act));
		act.click();
		//save
		driver.findElement(By.xpath("//button[text()='Save']/ancestor::li")).click();
		driver.findElement(By.xpath("//a[text()='Legal Entity Name']")).click();
		WebElement errorfield = driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following::div[text()='Complete this field.']"));
		errorfield.isDisplayed();
		
	
		
		
	}

}
