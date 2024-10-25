package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_33_Create_New_Refund {

	@Test
	
	public void createNewRefund() throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = new	DesiredCapabilities();
				dc.setBrowserName("MicrosoftEdge");
				dc.setPlatform(Platform.LINUX);
				RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
				
			//ChromeDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf$321");
			driver.findElement(By.id("Login")).click();
			
			
			driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
			
			WebElement eleViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		    eleViewAll.click();
		    
		   
		    WebElement eleServiceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		    driver.executeScript("arguments[0].click();", eleServiceConsole);
		    	
		    
		   driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//span[text()='Refunds']")).click();
		   Thread.sleep(1000);
		   WebElement eleNew= driver.findElement(By.xpath("//div[@title='New']"));
		   driver.executeScript("arguments[0].click();", eleNew);
		   
		   
		 //driver.findElement(By.xpath("//span[text()='Account']/following::div[1]")).click();
		   driver.findElement(By.xpath("//span[text()='Account']/following::input[@title='Search Accounts']")).click();
		   // Thread.sleep(4000);
		 // driver.findElement(By.xpath("//input[@title='Search Accounts']/following::li[2]")).click();
		 // driver.findElement(By.xpath("//input[@title='Search Accounts']/following::span[text()='Arun Unique1']")).click();
		  WebElement eleAcctName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Accounts']/following::span[text()='Arun O']")));
		  eleAcctName.click();
		  
		  /*WebElement eleStatus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Status']/following::div[1]")));
		  WebElement eleStatus = driver.findElement(By.xpath("//span[text()='Status']/following::div[1]"));
		  driver.executeScript("arguments[0].scrollIntoView(true);", eleStatus);
		  eleStatus.click();*/
		
		  driver.findElement(By.xpath("//span[text()='Status']/following::a[text()='--None--']")).click();
		  //driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Canceled']")).click();
		  WebElement eleStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select-options']//a[@title='Canceled']")));
		  eleStatus.click();
	
		
	    // driver.findElement(By.xpath("//span[text()='Amount']/following::input[1][@type='text']")).sendKeys("50000");
	     
	    // driver.findElement(By.xpath("//span[text()='Amount']/following::input[1][@data-aura-class='uiInputSmartNumber']")).sendKeys("50000");
	     WebElement eleAmount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Amount']/following::input[1][@data-aura-class='uiInputSmartNumber']")));
	     eleAmount.sendKeys("50000");
	     
	      driver.findElement(By.xpath("//span[text()='Type']/following::a[1][text()='--None--']")).click();
	      WebElement eleType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-options']/following::a[@title='Referenced']")));
	      eleType.click();
	      
	    //  WebElement eleProcessing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Processing Mode']/following::div[1]")));
	      WebElement eleProcessing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Processing Mode']/following::div[1][@class='uiMenu']")));
	      eleProcessing.click();
	      WebElement eleExternal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Processing Mode']/following::a[text()='External']")));
	      eleExternal.click();
	      
	      
	      driver.findElement(By.xpath("//div[@class='inlineFooter']//span[text()='Save']")).click();
	      
	      Thread.sleep(2000);
	      String text=driver.findElement(By.xpath("//div[contains(@id,'toastDescription')/span]")).getText();
	      System.out.println(text);
	      
	      
	      
	}
}
