package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_24_EditLegalEntity {
	@Test
	public void test24() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", element);

		// Click on the legal Entities tab
		WebElement element3 = driver.findElement(By.xpath("//a[@title='Legal Entities']"));
		driver.executeScript("arguments[0].click();", element3);
		
		// Search the Legal Entity 'Salesforce Automation by *Your Name*'
		WebElement element1 = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		driver.executeScript("arguments[0].click();", element1);

		// Click on the Dropdown icon and Select Edit
		driver.findElement(By.xpath("//tr//td[5]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// Enter the Company name as 'Tetsleaf'.
		driver.findElement(By.xpath("//label[text()='Company Name']//following::input[1]"))
				.sendKeys("Salesforce Automation by Rajeswari");

		// Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("SalesForce");

		// Select Status as 'Active'
		driver.findElement(By.xpath("//label[text()='Status']//following::button[1]")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Active']"));
		driver.executeScript("arguments[0].click();", element2);

		// Click on Save and Verify Status as Active
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// The Legal Entity is Edited Successfully
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);

	}

}
