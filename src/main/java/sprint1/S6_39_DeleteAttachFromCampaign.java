package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_39_DeleteAttachFromCampaign {

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
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement campaign = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaign);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		driver.findElement(By.xpath("(//span[text()='View All']//parent::div)[1]")).click();
		driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer']//a[@role='button'])[7]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean y = driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		System.out.println(y);
	}
}