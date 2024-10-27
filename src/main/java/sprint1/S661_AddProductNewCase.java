package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class S661_AddProductNewCase {
	
	@Test
	public void addnewcaseinProduct() throws InterruptedException, MalformedURLException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//ChromeDriver driver = new ChromeDriver(option);
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"),dc);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
//		Click on toggle menu button from the left corner
		WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		js.executeScript("arguments[0].click();", menu);
//		Click view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//  		Click on Content tab 
		WebElement content = driver.findElement(By.xpath("//p[text()='Content']"));
		wait.until(ExpectedConditions.elementToBeClickable(content));
		js.executeScript("arguments[0].click();", content);
//		Click View All Key Deals in Key Deals 		
		WebElement viewKey = driver.findElement(By.xpath("//span[text()='View All Key Deals']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(viewKey));
		js.executeScript("arguments[0].click();", viewKey);
//		Click the dropdown from Opportunities and select All Opportunities
		WebElement selectoppor = driver.findElement(By.xpath("//span[text()='Recently Viewed']/parent::h1"));
		wait.until(ExpectedConditions.elementToBeClickable(selectoppor));
		js.executeScript("arguments[0].click();", selectoppor);
		WebElement allOpr = driver.findElement(By.xpath("//span[text()='All Opportunities']"));
		wait.until(ExpectedConditions.elementToBeClickable(allOpr));
		js.executeScript("arguments[0].click();", allOpr);
		Thread.sleep(3000);
		WebElement oprSearch = driver.findElement(By.xpath("//label[contains(text(),'Search this list')]/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(oprSearch));
		js.executeScript("arguments[0].click();", oprSearch);
		oprSearch.sendKeys("SRM Steels");
		Thread.sleep(3000);
		oprSearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement oprName = driver.findElement(By.xpath("//span[text()='Opportunity Name']/following::a[text()='SRM Steels']"));
		wait.until(ExpectedConditions.elementToBeClickable(oprName));
		js.executeScript("arguments[0].click();", oprName);
//		Click on New Case, Click inside the Contact Name and select the first contact
		WebElement newcase = driver.findElement(By.xpath("//button[contains(text(),'New Case')]"));
		wait.until(ExpectedConditions.elementToBeClickable(newcase));
		js.executeScript("arguments[0].click();", newcase);
		WebElement contact = driver.findElement(By.xpath("//span[text()='Contact Name']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(contact));
		js.executeScript("arguments[0].click();", contact);
		WebElement contactName = driver.findElement(By.xpath("//span[text()='Contact Name']/following::input/following::div[@title]"));
		wait.until(ExpectedConditions.elementToBeClickable(contactName));
		js.executeScript("arguments[0].click();", contactName);
		WebElement statusdrop = driver.findElement(By.xpath("//span[text()='Status']/following::a"));
		wait.until(ExpectedConditions.elementToBeClickable(statusdrop));
		js.executeScript("arguments[0].click();", statusdrop);
		WebElement statusdropval = driver.findElement(By.xpath("//li[@role='presentation']/following::a[@title='New']"));
		wait.until(ExpectedConditions.elementToBeClickable(statusdropval));
		js.executeScript("arguments[0].click();", statusdropval);
		WebElement subject = driver.findElement(By.xpath("//span[text()='Subject']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(subject));
		subject.sendKeys("New Case for SRM Steels");
		WebElement save = driver.findElement(By.xpath("//span[text()='Description']/following::span[text()='Save']/parent::button"));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		js.executeScript("arguments[0].click();", save);
		driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).isDisplayed();
		
		
		;
	}

}
