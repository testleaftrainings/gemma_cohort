package week1.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

class TestCase001 {
	
	public ChromeOptions options = new ChromeOptions();

	@Test
	public void test1() throws InterruptedException {
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);	
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Raja");
	    WebElement de = driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
		Actions actions = new Actions(driver);
	    actions.moveToElement(de).click().perform();		
		driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		driver.close();

	}

}
