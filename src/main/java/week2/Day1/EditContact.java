package week2.Day1;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditContact {

	public ChromeOptions options = new ChromeOptions();
	ChromeDriver driver = new ChromeDriver(options);

	@Test
	public void test() throws AWTException {
		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//p[text()='Contacts']"))).click().perform();
		List<WebElement> elements = driver.findElements(By.xpath("//th[@scope='row']//a"));
		for (int i = 0; i < elements.size(); i++) {
			String x = elements.get(i).getText();
			System.out.println(x);
			System.out.println(elements.size());
		}
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Singam");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);

		driver.findElement(
				By.xpath("//a[@role='button']//following::span[@class='slds-icon_container slds-icon-utility-down']"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		a.moveToElement(driver.findElement(By.xpath("//input[@name='Birthdate']"))).click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		driver.findElement(By.xpath("//input[@name='Title']")).clear();
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("Automation Automation");
		driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("13579");
		driver.findElement(By.xpath("(//button[text()='Save'])")).click();
		boolean displayed = driver.findElement(By.xpath("//span[text()='Mr.  Singam']")).isDisplayed();
		System.out.println(displayed);
		boolean displayedz = driver.findElement(By.xpath("//span[text()='13579']")).isDisplayed();
		System.out.println(displayedz);
	}
}
