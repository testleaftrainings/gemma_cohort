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

public class S645Createcontactforcompaign {
	
	@Test
	public void createcontactcompaign() throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		//Login to https://login.salesforce.com 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		JavascriptExecutor js=(JavascriptExecutor) driver; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on toggle menu button from the left corner 
		WebElement applauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(applauncher));
		js.executeScript("arguments[0].click();", applauncher);
		//Click view All and click Sales from App Launcher 
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.elementToBeClickable(viewAll));
		viewAll.click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Click on Campaigns tab 
		WebElement compaign = driver.findElement(By.xpath("//span[text()='Campaigns']/parent::a"));
		js.executeScript("arguments[0].click();", compaign);
		//Click Bootcamp link 
		WebElement bootcamp = driver.findElement(By.xpath("//a[text()='Senthil Campaign Test']"));
		wait.until(ExpectedConditions.elementToBeClickable(bootcamp));
		bootcamp.click();
		//Click on New Contact under Search field 
		driver.findElement(By.xpath("//div[text()='New Contact']/parent::a")).click();
		WebElement salutation = driver.findElement(By.xpath("//span[text()='Salutation']/following::div[contains(@class,'salutation')]"));
		wait.until(ExpectedConditions.elementToBeClickable(salutation));
		salutation.click();
		//Pick Salutation as 'Mr.' 
		WebElement mr = driver.findElement(By.xpath("//a[@title='Mr.']/parent::li"));
		mr.click();
		//Enter first name as <your First Name>
		driver.findElement(By.xpath("//span[text()='First Name']/following::input")).sendKeys("Senthil");
		//Enter last name as <your last name>
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input")).sendKeys("Test Case 07");
		//Click Save 
		driver.findElement(By.xpath("//span[text()='Title']/following::span[text()='Save']")).click();
		WebElement contactalert = driver.findElement(By.xpath("//span[text()='Success']/ancestor::lightning-icon/parent::div"));
		contactalert.isDisplayed();
		driver.findElement(By.xpath("//span[text()='Close']/ancestor::button")).click();
		//Click on Add Contact from Campaign member 
		WebElement addcontact = driver.findElement(By.xpath("//span[text()='Campaign Members']/following::a[@title='Add Contacts']"));
		js.executeScript("arguments[0].scrollIntoView(true)", addcontact);
		js.executeScript("arguments[0].click();", addcontact);
		//Select the Created Contact 
		WebElement search = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
		System.out.println("Element Clicked Successfully");
		Thread.sleep(3000);
		search.sendKeys("Senthil Test Case 07");
		WebElement searchicon = driver.findElement(By.xpath("//input[@title='Search Contacts']/following::lightning-icon"));
		wait.until(ExpectedConditions.elementToBeClickable(searchicon));
		WebElement contvalue = driver.findElement(By.xpath("//div[@title='Senthil Test Case 07']"));
		wait.until(ExpectedConditions.elementToBeClickable(contvalue));
		js.executeScript("arguments[0].click();", contvalue);
		//Click Next 
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		//Click Submit on the Add to Campaign pop up 
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		driver.findElement(By.xpath("//div[text()='Senthil Campaign Test was successfully updated.']")).isDisplayed();
		WebElement close = driver.findElement(By.xpath("//span[text()='Close']/ancestor::button"));
		js.executeScript("arguments[0].click();", close);
		//verify the created Contact under Campaign by clicking 'View All' 
		WebElement compall = driver.findElement(By.xpath("//span[text()='Campaign Members']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(compall));
		js.executeScript("arguments[0].scrollIntoView(true)", compall);
		compall.click();
		WebElement newcomp = driver.findElement(By.xpath("//a[@title='Senthil Test Case 07']"));
		newcomp.isDisplayed();
		//Navigate to Contacts tab 
		WebElement contacts = driver.findElement(By.xpath("//a[@title='Contacts']"));
		wait.until(ExpectedConditions.elementToBeClickable(contacts));
		js.executeScript("arguments[0].click();", contacts);
		Thread.sleep(3000);
		//Search for Cantact with your Name
		WebElement searchcontact = driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list')]"));
		wait.until(ExpectedConditions.elementToBeClickable(searchcontact));
		js.executeScript("arguments[0].click();", searchcontact);
		searchcontact.sendKeys("Senthil Test Case 07");
		searchcontact.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		newcomp.isDisplayed();
		}

}
