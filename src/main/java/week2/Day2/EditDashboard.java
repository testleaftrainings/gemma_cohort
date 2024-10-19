package week2.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditDashboard {

	public ChromeOptions options = new ChromeOptions();

	@Test
	public void test() {
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//p[text()='Dashboards']"))).click().perform();
		driver.findElement(By.xpath("//div[@aria-label='Search recent dashboards...']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Search recent dashboards...']//input[@placeholder='Search recent dashboards...']")).sendKeys("by Devi");
		driver.findElement(
				By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Edit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).clear();
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("SalesForce");

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		boolean xy = driver.findElement(By.xpath("//span[text()='Dashboard saved']")).isDisplayed();
		System.out.println(xy);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		
	}
}