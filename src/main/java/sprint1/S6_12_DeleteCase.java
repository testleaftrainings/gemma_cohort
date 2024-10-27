package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S6_12_DeleteCase {
	

@Test
	
	public void createAccount() throws InterruptedException {
		//	WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
		//  driver.get("http://leaftaps.com/opentaps/control/main");
			
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
		// Step 1: Login to Salesforce
			
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
			
		//Click on toggle menu button from the left corner
			//Click on toggle menu button from the left corner
			driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

			//Click view All and click Sales from App Launcher

			driver.findElement(By.xpath("//button[text()='View All']")).click();
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			//driver.findElement(By.xpath("//a[@title='Cases']")).click();
			WebElement eleCases = driver.findElement(By.xpath("//a[@title='Cases']"));
			driver.executeScript("arguments[0].click();", eleCases);
			  // Step 5: Click on the Dropdown icon and select Delete from the case you created
            //WebElement caseDropdown = driver.findElement(By.xpath("//span[text()='Case Owner Alias']/ancestor::tr//button"));
            Thread.sleep(3000);
            WebElement eleDropDown =  driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//td[7]/span//a"));
            eleDropDown.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@title='Delete']")).click();

            // Confirm deletion
           driver.findElement(By.xpath("//button[@title='Delete']")).click();

            // Step 6: Verify the case with your name is deleted or not
            boolean isCaseDeleted = driver.findElements(By.xpath("//span[text()='Case Owner Alias']")).isEmpty();
            if (isCaseDeleted) {
                System.out.println("The case is deleted.");
            } else {
                System.out.println("The case is present.");
            }
        
			
}


}
