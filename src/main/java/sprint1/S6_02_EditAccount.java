package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class S6_02_EditAccount {

	@Test
	public void editAcct() throws InterruptedException, MalformedURLException {
		
		
		/* 
		 *EdgeOptions options = new EdgeOptions();
		 * DesiredCapabilities dc = new DesiredCapabilities();
		 
		 dc.setBrowserName("MicrosoftEdge");
		 //dc.setBrowserName("chrome');
		 dc.setPlatform(Platform.LINUX);
		 RemoteWebDriver driver =new RemoteWebDriver(new URL(" http://20.40.48.160:4444/wd/hub"), dc);
        */
						
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	// Step 1: Login to Salesforce
		
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		
		//driver.executeScript("argument[0].click();",eleAccounts);
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		
		driver.findElement(By.xpath("//div[@type='search']/input[1]")).sendKeys("Kiruthika");
		driver.findElement(By.xpath("//div[@type='search']/input[1]")).sendKeys(Keys.TAB);
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 WebElement eleDropDown = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//tr/td[6]//a"));
	     js.executeScript("arguments[0].click();", eleDropDown);
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//WebElement eleActions = driver.findElement(By.xpath("//span[text()='Show Actions']"));
		//driver.executeScript("arguments[0].click();", eleActions);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@title='Edit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Type']//following::button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='Industry']//following::button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='Healthcare']")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
		
	/*	//Click on the displayed Account Dropdown icon and select Edit
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
	    driver.findElement(By.xpath("//span[text()='Healthcare']")).click();*/
		
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
	    WebElement eleActive = driver.findElement(By.xpath("//label[text()='Active']/following::button[1]"));
	    js.executeScript("arguments[0].click()", eleActive);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='No']")).click();
	    
	    //Enter Unique Number in Phone Field
	    
	    WebElement elePhone = driver.findElement(By.xpath("//label[text()='Phone']/following::input[1]"));
	    elePhone.clear();
	    elePhone.sendKeys("8765432190");
	    
	    
	    String inputPhoneNum = "8765432190";
	    
	    
	    //Select Upsell Oppurtunity as No
	    WebElement eleUpsell = driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following::button[1]"));
	    js.executeScript("arguments[0].click()",eleUpsell);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='No']")).click();
	    
	   
	    
	    
	    Thread.sleep(2000);
	    // Click on save and verfiy Phone number
	    driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
	    
	    Thread.sleep(4000);
	    
	    String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
    	System.out.println(text);
	    
	    
	    
	    //Verify phone number
	    Thread.sleep(5000);
	    String phoneNum = driver.findElement(By.xpath("//td[4]//span[1]")).getText().trim();
	    System.out.println(phoneNum);
	    
	    //String phoneNum1 = driver.findElement(By.xpath("//tr[1]//td[4]//span[contains(@class,'forceOutputPhone')]")).getText().trim();
	    //System.out.println(phoneNum1);
	    
	    if(phoneNum.equals(inputPhoneNum)) 
	     	
	    	System.out.println("Test Passed: Phone number  matching.");
	    
	    else
	    	System.out.println("Test Failed: Phone number not matching.");
	   
	    
	}
}
