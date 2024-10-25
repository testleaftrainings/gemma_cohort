package sprint1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S6_17_CreateOpportunity {

	@Test
	
	public void createOpport() throws InterruptedException {

			ChromeDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
		// Step 1: Login to Salesforce
			
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf$321");
			driver.findElement(By.id("Login")).click();
			
			// Step 2: Click View All
			
			driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			
			// Step 3: Click Sales
			
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
			//driver.findElement(By.xpath("//a[@title='Opportunities']")).click(); //cannot read properties of undefined
						
			// Step 4: Click Opportunities
			
			WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Opportunities']"));
			driver.executeScript("arguments[0].click();", eleAccounts);
		
			// Step 4: Click New 
			
			driver.findElement(By.xpath("//div[@title='New']")).click();
		
			//driver.findElement(By.xpath("//span[text()='Select a date for Close Date']")).click();
			/*driver.findElement(By.xpath("//label[text()='Close Date']/following::button[1]")).click();
			//String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			WebElement dateField = driver.findElement(By.xpath("//td[@data-value='2024-10-13']"));
			dateField.clear();
            dateField.sendKeys(formattedDate);*/
			
			// Step 5: Calculate Tomorrow's date
			
			LocalDate tomorrow = LocalDate.now().plusDays(1);
            
			String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			WebElement eleCloseDate =driver.findElement(By.xpath("//label[text()='Close Date']/following::button[1]"));
			
			driver.executeScript("arguments[0].click();", eleCloseDate);
			
			// Step 6:send calculated tomorrow's date to data-Value and click tomorrow's date
			
            WebElement date=driver.findElement(By.xpath("//td[@data-value='"+formattedDate+"']/span"));
            driver.executeScript("arguments[0].click();", date);
            Thread.sleep(2000);
            
        	
            // Step 7: click Save
			
            driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
            
            
         // Step 8:Validate error messages are displayed for mandatory fields.
            
            WebElement nameAlert = driver.findElement(By.xpath("//div[contains(text(),'Complete this field')]/span[text()='Opportunity Name']"));
            WebElement stageAlert = driver.findElement(By.xpath("//div[contains(text(),'Complete this field')]/span[text()='Stage']"));
            
            if (nameAlert.isDisplayed() && stageAlert.isDisplayed()) {
                System.out.println("Test Passed: Alert messages are displayed for Name and Stage fields");
            } else {
                System.out.println("Test Failed: Alert messages are not displayed as expected");
            }
            
            
            
            
            
            /*LocalDate tomorrow = LocalDate.now().plusDays(1);
            
			//String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			
			String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
			System.out.println(formattedDate);
            
			
			//td[@data-value='2024-10-13']
			
			
			
			driver.findElement(By.name("save")).click();
			
			
			WebElement nameAlert = driver.findElement(By.xpath("//div[contains(text(),'Complete this field')]"));
            WebElement stageAlert = driver.findElement(By.xpath("//div[contains(text(),'Complete this field')]"));
			
            if (nameAlert.isDisplayed() && stageAlert.isDisplayed()) {
                System.out.println(" Alert messages are displayed for Name and Stage fields");
            } else {
                System.out.println(" Alert messages are not displayed as expected");
            }*/
	}
}
