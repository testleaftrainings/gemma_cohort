package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_41_CreateNewOpportunityCampaign {
	@Test
	public void test41() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//Login to Login | Salesforce
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on  Campaigns tab 
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		driver.executeScript("arguments[0].click();", element);
		
		//Click Bootcamp link 
		driver.findElement(By.xpath("//a[@title='Bootcamp'] ")).click();
		
		//Click on 'New' from Oppurtunities tab
		driver.findElement(By.xpath("//div[@title='New Opportunity'] ")).click();
		
		//Enter Opportunity name as 'Opportunity from Your Name' 
		driver.findElement(By.xpath("//span[text()='Opportunity Name']//following::input[1]")).sendKeys("Opportunity from Rajeswari");
		
		//Choose close date as Tomorrow 
		driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		driver.findElement(By.xpath("(//tr//td)[105]")).click();
		
		//Select 'Stage' as Need Analysis 
		driver.findElement(By.xpath("//span[text()='Stage']//following::a")).click();
		driver.findElement(By.xpath("//a[@title='Needs Analysis']")).click();
		
		//click Save 
		driver.findElement(By.xpath("(//span[text()='Next Step']//following::button)[2]")).click();
		
		//Verify new Oppurtunity in Campaign 
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
		System.out.println(text);
		
		//Click on Opportunities Tab 
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", element1);
		
		//Verify the newly created Opportunity (Oppotunity from your name) 
		Thread.sleep(2000);
		String text1 = driver.findElement(By.xpath("(//tr//td//following::th)[1]")).getText();
		System.out.println(text1);
		String expected = new String("Opportunity from Rajeswari");
		System.out.println(text1.equals(expected));
	
	}
}
