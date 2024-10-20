package salesforceapp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class S6_5_CreateWorkTypeGroup {
	public static void main(String[] args) throws InterruptedException {
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
		Thread.sleep(3000);

		// Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].click();", element);

		// Click on the Dropdown icon in the Work Type Groups tab
		driver.findElement(By.xpath(
				"(//a[@title='Recently Viewed | Work Type Groups'])[2]//following::one-app-nav-bar-item-dropdown"))
				.click();

		// Click on New Work Type Group
		WebElement element1 = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click();", element1);

		// Enter Work Type Group Name as 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input[1]")).sendKeys("Salesforce Automation by Rajeswari1");

		// Click save and verify Work Type Group Name
		driver.findElement(By.xpath("//span[text()='System Information']/following::button[text()='Save']")).click();
       
		// The Work Type Group is created Successfully
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);

	}
}
