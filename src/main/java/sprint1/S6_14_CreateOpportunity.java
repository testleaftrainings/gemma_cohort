package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_14_CreateOpportunity extends BaseClass {

	public ChromeOptions options = new ChromeOptions();

	@Test
	public void test() throws InterruptedException {
		
//		options.addArguments("--disable-notifications");
//		ChromeDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://login.salesforce.com");
//		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
//		driver.findElement(By.id("password")).sendKeys("Leaf$321");
//		driver.findElement(By.id("Login")).click();
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement applauncher = driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(applauncher));
		applauncher.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement account = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", account);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Raja");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();

		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
		if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[@title='Salesforce Automation by Raja']//div"));
			System.out.println("Expected result");
		}
		else
			System.out.println("Not Expected result");
		driver.close();
	}
}
