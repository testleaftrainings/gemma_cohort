package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class S6_11_EditCase {
	@Test
	public void test11() throws InterruptedException {
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

		// Click on Cases tab visible or select from more.
		WebElement element = driver.findElement(By.xpath("//span[text()='More']"));
		driver.executeScript("arguments[0].click();", element);
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", element1);

		// Click on the Dropdown icon and select Edit from the case you created by
		driver.findElement(By.xpath("//tr//td[7]//div/a")).click();
		driver.findElement(By.xpath("//a [@title='Edit']")).click();

		// Update Status as Working
		driver.findElement(By.xpath("//label[text()='Status']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[@title='Working']")).click();

		// Update Priority to low
		driver.findElement(By.xpath("//label[text()='Priority']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[@title='Low']")).click();

		// Update Case Origin as Phone
		driver.findElement(By.xpath("//label[text()='Case Origin']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[@title='Phone']")).click();

		// Update SLA violation to No
		WebElement element2 = driver.findElement(By.xpath("//label[text()='SLA Violation']/following::button[1]"));
		driver.executeScript("arguments[0].click();", element2);
		WebElement element3 = driver.findElement(By.xpath("//span[@title='No']"));
		driver.executeScript("arguments[0].click();", element3);

		// Click on Save and Verify Status as Working
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		String text1 = driver.findElement(By.xpath("(//tr//td[4]//span/span[@class='slds-truncate'])[1]")).getText();
		System.out.println(text1);
		String expected = new String("Working");
		System.out.println(text1.equals(expected));
		driver.quit();

	}
}
