package salesforceapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_16_DeleteOpportunity {
	@Test
	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Step 1: Login to Login | Salesforce
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Opportunity tab
		WebElement element = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", element);
		// Create new opportunity
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']//following::input)[1]")).sendKeys("Salesforce Automation by Rajeswari");
		driver.findElement(By.xpath("(//label[text()='Close Date']//following::input)[1]")).click();
		driver.findElement(By.xpath("//table[@class='slds-datepicker__month']//following::td[@aria-current='date']")).click();
		driver.findElement(By.xpath("(//label[text()='Stage']//following::button)[1]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//span[text()='Description Information']//following::button[text()='Save']")).click();
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", element1);

		// Search the Opportunity 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"))
				.sendKeys("Salesforce Automation by Rajeswari", Keys.ENTER);

		// Click on the Dropdown icon and Select Delete
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@title='Salesforce Automation by Rajeswari']")));
		driver.findElement(By.xpath("//tr//td[8]//div/a")).click();
		driver.findElement(By.xpath("//a [@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		// Verify Whether Oppurtunity is Deleted using Oppurtunity Name
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

		// Check the opportunity is not available
		// Search the Opportunity 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"))
				.sendKeys("Salesforce Automation by Rajeswari");
		String text2 = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		System.out.println(text2);
		String expected = new String("No items to display.");
		System.out.println(text2.equals(expected));
		driver.quit();
	}
}
