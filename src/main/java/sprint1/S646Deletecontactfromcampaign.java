package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S646Deletecontactfromcampaign {
	
	@Test
	public void deletecontactCampaign() throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Login to https://login.salesforce.com 
		driver.get("https://login.salesforce.com ");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on toggle menu button from the left corner 
		WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		js.executeScript("arguments[0].click();", menu);
		//Click view All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Click on Contacts tab 
		WebElement contacts = driver.findElement(By.xpath("//a[@title='Contacts']"));
		wait.until(ExpectedConditions.elementToBeClickable(contacts));
		js.executeScript("arguments[0].click();", contacts);
		//Search for Contact with name as <your name> 
		WebElement contactsearch = driver.findElement(By.xpath("//input[@name='Contact-search-input']"));
		contactsearch.click();
		contactsearch.sendKeys("Senthil Test Case 07");
		contactsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//Click on dropdown icon for the Lead and Select Delete 
		driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")).click();
		WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
		wait.until(ExpectedConditions.elementToBeClickable(delete));
		js.executeScript("arguments[0].click();", delete);
		//Confirm the Delete for Lead 
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		WebElement closeicon = driver.findElement(By.xpath("//span[text()='Close']/parent::button"));
		wait.until(ExpectedConditions.elementToBeClickable(closeicon));
		js.executeScript("arguments[0].click();", closeicon);
		//Click on Campaign tab 
		WebElement campaings = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		wait.until(ExpectedConditions.elementToBeClickable(campaings));
		js.executeScript("arguments[0].click();", campaings);
		//Click Bootcamp link 
		driver.findElement(By.xpath("//a[@title='Senthil Campaign Test']")).click();
		WebElement campaignmembers = driver.findElement(By.xpath("//span[text()='Campaign Members']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(campaignmembers));
		js.executeScript("arguments[0].click();", campaignmembers);
		//Verify the associated Contact
		driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		
		
	}

}
