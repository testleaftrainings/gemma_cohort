package Assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditAccount {

	@Test
	public void editAcct() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	// Step 1: Login to Salesforce
		
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		
		//driver.executeScript("argument[0].click();",eleAccounts);
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		
		driver.findElement(By.xpath("//div[@type='search']/input[1]")).sendKeys("Kiruthika");
		
		
		//Click on the displayed Account Dropdown icon and select Edit
		////a[@title='Kiruthika R']/ancestor::tr//button
		 WebElement accountDropdown = driver.findElement(By.xpath("//a[@title='Kiruthika R']/ancestor::tr//button"));
         accountDropdown.click();
         driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		
		
		driver.findElement(By.xpath("//div[1851:0")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		//Select Type as Technology Partner
		
	    driver.findElement(By.xpath("//label[text()='Type']/following::button[1]")).click();
	    driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
	    
		
		//Select Industry as Healthcare 
		
	    driver.findElement(By.xpath("//label[text()='Industry']/following::button[1]")).click();
	    driver.findElement(By.xpath("//span[text()='Healthcare']")).click();
		
	    //Enter Billing Address
		
	    driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea[1]")).sendKeys("XXX Street");
	    driver.findElement(By.xpath("//label[text()='Billing City']/following::input[1]")).sendKeys("YYY City");
	    driver.findElement(By.xpath("//label[text()='Billing Zip/Postal Code']/following::input[1]")).sendKeys("YYYY");
	    driver.findElement(By.xpath("//label[text()='Billing State/Province']/following::input[1]")).sendKeys("ZZ State");
	    driver.findElement(By.xpath("//label[text()='Billing Country']/following::input[1]")).sendKeys("XYZ Country");
	    
	    
	    //Enter Shipping Address
	    
	    driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea[1]")).sendKeys("XXXX Street");
	    driver.findElement(By.xpath("//label[text()='Shipping City']/following::input[1]")).sendKeys("YYYY City");
	    driver.findElement(By.xpath("//label[text()='Shipping Zip/Postal Code']/following::input[1]")).sendKeys("CCCC");
	    driver.findElement(By.xpath("//label[text()='Shipping State/Province']/following::input[1]")).sendKeys("SS State");
	    driver.findElement(By.xpath("//label[text()='Shipping Country']/following::input[1]")).sendKeys("XYZ Country");
	    
	    
	    
	    //Select Customer Priority as Low
	    driver.findElement(By.xpath("//label[text()='Customer Priority']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
	    
	    //Select SLA as Silver
	    driver.findElement(By.xpath("//label[text()='SLA']/following::button[1]")).click();
	    driver.findElement(By.xpath("//span[text()='Silver']")).click();
	    
	    
	    //Select Active as NO
	    driver.findElement(By.xpath("//label[text()='Active']/following::button[1]")).click();
	    driver.findElement(By.xpath("//span[text()='No']")).click();
	    
	    //Enter Unique Number in Phone Field
	    
	    driver.findElement(By.xpath("//label[text()='Phone']/following::input[1]")).sendKeys("8765432190");
	    
	    //Select Upsell Oppurtunity as No
	    driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following::button[1]")).click();
	    driver.findElement(By.xpath("//span[text()='No']")).click();
	    
	   
	    
	    
	    
	    // Click on save and verfiy Phone number
	    driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
	    
	  
	    
	    
	    
	    //Verify phone number
	    Thread.sleep(2000);
	    String phoneNum = driver.findElement(By.xpath("//label[text()='Phone']/following::input[1]")).getText();
	    
	    if(phoneNum=="8765432190") 
	     	
	    	System.out.println("Test Passed: Phone number  matching.");
	    
	    else
	    	System.out.println("Test Failed: Phone number not matching.");
	    
	    String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
    	System.out.println(text);
	    
	}
}
