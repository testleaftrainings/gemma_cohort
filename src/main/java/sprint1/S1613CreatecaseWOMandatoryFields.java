package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class  S1613CreatecaseWOMandatoryFields {
	
	@Test
	public void casewoMandatory() throws MalformedURLException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
	   //ChromeDriver driver = new ChromeDriver(option);
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on toggle menu button from the left corner and click view All and click Sales from App Launcher
		WebElement appluancher = driver.findElement(By.xpath("//button[@title='App Launcher']/div"));
		wait.until(ExpectedConditions.elementToBeClickable(appluancher));
		appluancher.click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		wait.until(ExpectedConditions.elementToBeClickable(sales));
		sales.click();
		Thread.sleep(3000);
		try {
			WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']/parent::a"));
			wait.until(ExpectedConditions.elementToBeClickable(cases));
			js.executeScript("arguments[0].click();", cases);
		} 
		catch (TimeoutException e) {
			WebElement more = driver.findElement(By.xpath("//span[text()='More']/parent::a"));
			wait.until(ExpectedConditions.elementToBeClickable(more));
			js.executeScript("arguments[0].click();", more);
			WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']/ancestor::a[@role='menuitem']"));
			wait.until(ExpectedConditions.elementToBeClickable(cases));
			js.executeScript("arguments[0].click();", cases);
		}
		
		//Click on New button
		driver.findElement(By.xpath("//div[text()='New']/ancestor::li")).click();
		//Choose Contact Name from DropDown
		WebElement contact = driver.findElement(By.xpath("//label[text()='Contact Name']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(contact));
		contact.click();
		WebElement contactname = driver.findElement(By.xpath("(//ul[@aria-label='Recent Contacts']/ancestor::div/ul/li)[2]"));
		contactname.click();
		//Select status as None
		WebElement status = driver.findElement(By.xpath("//label[text()='Status']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(status));
		js.executeScript("arguments[0].click();", status);
		WebElement none = driver.findElement(By.xpath("//span[contains(@title,'None')]/ancestor::lightning-base-combobox-item"));
		wait.until(ExpectedConditions.elementToBeClickable(none));
		js.executeScript("arguments[0].click();", none);
		//Enter Subject as 'Testing' and description as 'Automation testing'
		WebElement subject = driver.findElement(By.xpath("//label[text()='Subject']/following::input"));
		js.executeScript("arguments[0].scrollIntoView(true)", subject);
		subject.sendKeys("Testing");
		WebElement descrip = driver.findElement(By.xpath("//label[text()='Description']/following::textarea"));
		js.executeScript("arguments[0].scrollIntoView(true)", descrip);
		descrip.sendKeys("Automation testing");
		//Click 'Save'
		driver.findElement(By.xpath("//button[text()='Save & New']/following::button")).click();
		//Get the text of Error message Displayed and Verify the message
		WebElement errorpop = driver.findElement(By.xpath("//h2[text()='We hit a snag.']/parent::div"));
		errorpop.isDisplayed(); 
		//click status link and validate error message
		WebElement statuslink = driver.findElement(By.xpath("//div/strong[text()='Review the following fields']/following::a[text()='Status']"));
		wait.until(ExpectedConditions.elementToBeClickable(statuslink));
		statuslink.click();
		System.out.println("status link clicked successfully");
		WebElement statuserror = driver.findElement(By.xpath("//label[text()='Status']/following::div[text()='Complete this field.']"));
		js.executeScript("arguments[0].scrollIntoView(true)", statuserror);
		statuserror.isDisplayed();
		//click orgin link and validate error message
		driver.findElement(By.xpath("//button[text()='Save & New']/following::lightning-button")).click();
		System.out.println("Save clicked successfully");
		WebElement caseorgin = driver.findElement(By.xpath("//div/strong[text()='Review the following fields']/following::a[text()='Case Origin']"));
		wait.until(ExpectedConditions.elementToBeClickable(caseorgin));
		caseorgin.click();
		System.out.println("case orgin link clicked successfully");
		WebElement caseorginerr = driver.findElement(By.xpath("//label[text()='Case Origin']/following::div[text()='Complete this field.']"));
		js.executeScript("arguments[0].click();", caseorginerr);
		caseorginerr.isDisplayed();
		
		
		
	}

}
