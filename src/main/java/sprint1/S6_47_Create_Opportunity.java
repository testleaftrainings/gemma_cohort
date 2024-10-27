package sprint1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S6_47_Create_Opportunity {
@Test
	
	public void createOpport() throws InterruptedException {

			ChromeDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
		// Step 1: Login to Salesforce
			
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
			
			// Step 2: Click View All
			
			driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			
			//Step 3: Click Content from App Launcher
			
			Thread.sleep(2000);
            driver.findElement(By.xpath("//p[text()='Content']")).click();
			
            
			
			//Step 4:  Click View All Key Deals in Key Deals 
			driver.findElement(By.xpath("//span[text()='View All Key Deals']")).click();
			
			
			//Step 5: Click the dropdown from Opportunities and select All Opportunities

			driver.findElement(By.xpath("//button[@title='Select a List View: Opportunities']")).click();
			driver.findElement(By.xpath("//div[@class='listContent']//li[2]//span[text()='All Opportunities']")).click();
			
			Thread.sleep(2000);
			//Step 6: Click on New button

			driver.findElement(By.xpath("//a[@title='New']")).click();
			
			//Step 7:Give Opportunity Name as SRM Steels

			driver.findElement(By.xpath("//label[text()='Opportunity Name']//following::input[@name='Name']")).sendKeys("SRM Steels");
			
			//Step 8: Select Type as New Customer and Lead Source as Partner Referral
			driver.findElement(By.xpath("//label[text()='Type']/following::div[1]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@title='New Customer']")).click();
			
			WebElement eleLeadSource = driver.findElement(By.xpath("//label[text()='Lead Source']//following::button[1]"));
			driver.executeScript("arguments[0].click()", eleLeadSource);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
			
			//Step 9: Give Amount as 75000 and Select Close Date as Next month 20th day 
			
			LocalDate nextMonth20th = LocalDate.now().withDayOfMonth(1).plusMonths(1).withDayOfMonth(20);
            
			String formattedDate = nextMonth20th.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Thread.sleep(5000);
			WebElement eleCloseDate =driver.findElement(By.xpath("//label[text()='Close Date']/following::button[1]"));
			
			driver.executeScript("arguments[0].click();", eleCloseDate);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[@title='Next Month']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td/span[text()='20']")).click();
			Thread.sleep(5000);
			
			
			
			/*WebElement date=driver.findElement(By.xpath("//td[@data-value='"+formattedDate+"']/span"));
            driver.executeScript("arguments[0].click();", date);*/
            
			
			//Step 10: Select Stage as Needs Analysis 
			driver.findElement(By.xpath("//label[text()='Stage']//following::button[1]")).click();	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
			
			
			//Step11 : Click in Primary Campaign  Source and Select first option 
			driver.findElement(By.xpath("//records-record-layout-item[@field-label='Primary Campaign Source']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//records-record-layout-item[@field-label='Primary Campaign Source']/div//li[2]")).click();
			Thread.sleep(1000);
			//Step 12: . Click Save and Verify the SRM Steels opportunity is created    
			
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			
			Thread.sleep(4000);
			
			String text = driver.findElement(By.xpath("//span[text()='Success']")).getText();
			
			System.out.println("Test Result " + text );
			
			
			
			
			
			
			
			
			
			
			
}
}
