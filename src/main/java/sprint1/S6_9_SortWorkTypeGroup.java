package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S6_9_SortWorkTypeGroup {
	

	@Test
	public void sortWorkType() throws InterruptedException {
		
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
		
		WebElement element = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Use JavaScript to scroll the element into view
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//click on WorkTypeGroup 
		
		element.click();
		
		
		WebElement parentElement = driver.findElement(By.xpath("//span[@title='Work Type Group Name']"));

        // Use JavaScript to trigger the click event on the parent element
     
        js.executeScript("arguments[0].click();", parentElement);
        
        driver.findElement(By.xpath("//span[text()='Work Type Group Name']/preceding-sibling::span[text()='Sort']")).click();
        
        String pseudoElementContent = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');",
                parentElement);
        
     // Print the content of the ::after pseudo-element
        
        System.out.println("Content of ::after pseudo-element: " + pseudoElementContent);
	    
        
        
        
        /*
	    
	    Thread.sleep(2000);
	    String phoneNum = driver.findElement(By.xpath("//labeltest()='Phone']/following::input[1]")).getText();
	    
	    if(phoneNum=="8765432190") {
	     	
	    	String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
	    	System.out.println(text);
	    }
	    else
	    	System.out.println("Phone number not matching.");
	    */
	    
	}

}
