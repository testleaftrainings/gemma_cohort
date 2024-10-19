package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_38_AttachCampaign {

	public ChromeOptions options = new ChromeOptions();

	@Test
	public void test() throws InterruptedException {
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement campaign = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaign);
		driver.findElement(By.xpath("//a[@title='GlenBootcamp']")).click();
		WebElement upload = driver.findElement(By.xpath("//input[@name='fileInput']"));
		Thread.sleep(5000);
		String input = "Oct5_To_Oct13_5_Classes";
		upload.sendKeys("C:\\Users\\Raja\\Downloads\\" + input + ".pdf");
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		boolean verify = driver.findElement(By.xpath("(//span[text()='" + input + "'])[2]")).isDisplayed();
		System.out.println(verify);
	}
}