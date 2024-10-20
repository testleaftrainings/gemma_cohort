package salesforceapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S6_42_Delete_Opportunity_Campaign {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Login to Login | Salesforce
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Campaigns tab
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		driver.executeScript("arguments[0].click();", element);

		// Click Bootcamp link
		driver.findElement(By.xpath("//a[@title='Bootcamp'] ")).click();

		// Click on the dropdown icon in the Opportunities
		driver.findElement(By.xpath("(//div[@title='New'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']/following::input)[1]"))
				.sendKeys("Automation by Rajeswari");
		driver.findElement(By.xpath("(//label[text()='Close Date']//following::input)[1]")).click();
		driver.findElement(By.xpath("//table[@class='slds-datepicker__month']//following::td[@aria-current='date']"))
				.click();
		driver.findElement(By.xpath("//label[text()='Stage']//following::button")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", element2);
		driver.findElement(By.xpath("//span[text()='Description Information']//following::button[text()='Save']"))
				.click();
		// Thread.sleep(2000);
		WebElement dropdownIcon = driver.findElement(By.xpath(
				"//span[@title='Opportunities']//following::a[text()='Automation by Rajeswari']//following::a[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dropdownIcon);
		Thread.sleep(7000);

		// Select Delete and Confirm the delete
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		// Verify the Deleted Opportunity under selected campaign
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

		// Click on Opportunities Tab
		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", element3);

		// Search for created oppurtunity and verify its deleted or not
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Automation by Rajeswari",
				Keys.ENTER);

		// Verify the deleted Opportunity
		String text2 = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		System.out.println(text2);

	}
}
