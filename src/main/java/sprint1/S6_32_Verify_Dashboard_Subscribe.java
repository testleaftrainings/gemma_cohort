package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_32_Verify_Dashboard_Subscribe {
	@Test
public void verifyDashboardSubscribe() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		
		
		
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		//Thread.sleep(1000);
		//WebElement eleAppLaunch = driver.findElement(By.xpath("//span[text()='App Launcher']/div[1]"));
		WebElement eleAppLaunch = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		driver.executeScript("arguments[0].click();", eleAppLaunch);
		WebElement eleViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
	    eleViewAll.click();
	    
	    
	   WebElement eleDashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
	    driver.executeScript("arguments[0].scrollIntoView(true);", eleDashboards);
	    eleDashboards.click();
	    
	    //WebElement eleSearch = driver.findElement(By.xpath("//label[text()='Search...']/following::input[@type='search']"));
	   // WebElement eleSearch = driver.findElement(By.xpath("//div[@type='search']"));
	   // WebElement eleSearch = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
	    //eleSearch.sendKeys("Kiruthika");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Kiruthika");
	    Thread.sleep(2000);
	   /* JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    WebElement eleSubsDropDown = driver.findElement(By.xpath("//table[@aria-label='Recent Dashboards']//tr/td[6]//div"));
        js.executeScript("arguments[0].click();", eleSubsDropDown);*/
        driver.findElement(By.xpath("//table[@aria-label='Recent Dashboards']//tr/td[6]//div")).click();
	    Thread.sleep(2000);
	   driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Subscribe']")).click();
	    
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//legend[text()='Frequency']/following::span[text()='Daily']")).click();
	   driver.findElement(By.xpath("//button[@title='Save']/span[text()='Save']")).click(); 
	   
	  String textMsg = driver.findElement(By.xpath("//table[@aria-label='Recent Dashboards']//tr/td[5]//span[text()='True']")).getText().trim();
	   System.out.println(textMsg);
	 
	   if(textMsg.equals("True")) 
		   System.out.println("Test Passed: Subscribed Successfully");
	   else 
		   System.out.println("Test Failed: Subscribtion UnSuccessful");
	   
	  
	   
	}    
}
