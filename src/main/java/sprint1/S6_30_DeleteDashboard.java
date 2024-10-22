package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_30_DeleteDashboard {
	@Test
	public void test30() throws InterruptedException {
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

		// Click View All and click Dashboards from App Launcher
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", element);

		// Click on the Dashboards tab
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
		driver.executeScript("arguments[0].click();", element1);
		// create New Dashboard
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		Thread.sleep(5000);
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
	    driver.findElement(By.xpath("(//label[text()='Name']//following::input)[1]")).sendKeys("Test_Delete");
		driver.findElement(By.xpath("//button [text()='Create']")).click();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		WebElement element2 = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
		driver.executeScript("arguments[0].click();", element2);

		// Search the Dashboard 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Test_Delete");

		// Click on the Dropdown icon and Select Delete
		Thread.sleep(7000);
		WebElement element3 = driver.findElement(By.xpath("(//tr//td[6]//span)[1]"));
		driver.executeScript("arguments[0].click();", element3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		// Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		// Verify Whether Dashboard is Deleted using Dashboard Name
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

	}
}