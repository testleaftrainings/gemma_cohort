package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6_81_CreatedPostDeleted {
	@Test
	public void test58() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		

	
	//Step 1. Navigate to Salesforce login page
		driver.get("https://login.salesforce.com/");
		
	//Step 2. Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	//Step 3. Click on the 'File'
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='File']"))).click();
		
	//Step 4. Click on 'Select a file from Salesforce'
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Select a file from Salesforce']")).click();
		WebElement link = driver.findElement(By.xpath("//a[text()='Select a file from Salesforce']"));
        link.click();
		
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
        // Switch to the child window
                driver.switchTo().window(windowHandle);
           
    //Step 5. Click on 'Owned by Me'    
        driver.findElement(By.xpath("//a[@title='Owned by Me']")).click();
        
    //Step 6. Search for 'Maven'
        driver.findElement(By.xpath("//input[@title='Search Files I Own...']")).sendKeys("maven", Keys.ENTER);
        //driver.findElement(By.xpath("//a[@title='Search']")).click();
        
	//Step 7. Click on the 'Attach' for Maven file
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Attach']")).click();
        
     // Return to the main window
        driver.switchTo().window(mainWindow);
        
        
	//Step 8. Click on the 'Share' Button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@title='Share']")).click();
        Thread.sleep(3000);
        
	//Step 9. Click on the 'More Actions'
        driver.findElement(By.xpath("//span[text()='More Actions']")).click();
        Thread.sleep(3000);
        
        
	//Step 10. Click on the 'File Sharing Settings'
        driver.findElement(By.xpath("(//span[text()='File Sharing Settings'])[1]")).click();
        
	//Step 11. Change permissions as 'Collaborators'
        driver.findElement(By.xpath("(//span[@class='permissionLabel'])[1]")).click();
        
	//Step 12. Enable the checkBox for 'Prevent others from sharing and unsharing'
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='sharingOption']"));
        
        
	//Step 13. Verify the checkbox is Enabled
        checkbox.isEnabled();
        System.out.println(checkbox);
        
	//Step 14. Click on the 'Close' button.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Close']")).click();
        
	//Step 15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
        driver.findElement(By.xpath("//a[text()='Click to add topics:']")).click();
        driver.findElement(By.xpath("//textarea[@class='input ghost']")).sendKeys("Maven Rajeswari");
        driver.findElement(By.xpath("//input[@title='Done']")).click();
        
	//Step 16. Verify the Topics as 'Maven Installtion Guide'
        String topics = driver.findElement(By.xpath("//a[text()='Topics:']//following::a")).getText();
        String expected =new String("Maven Rajeswari");
        System.out.println(topics.equals(expected));
        
	//Step 17. Click on the widget dropdown for post and click 'Delete'
        String mainWindow1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@title='More Actions']")).click();
        driver.findElement(By.xpath("//a[text()='Delete']")).click(); 
        Thread.sleep(5000);
        
        for (String windowHandle1 : driver.getWindowHandles()) {
            if (!windowHandle1.equals(mainWindow1)) {
        // Switch to the child window
                driver.switchTo().window(windowHandle1);
                          
	//Step 18. Click on the 'Ok' Button.
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        		wait1.until(ExpectedConditions
        				.visibilityOfElementLocated(By.xpath("(//div[@class='buttons'])//input[1]")));
                WebElement ok = driver.findElement(By.xpath("(//div[@class='buttons'])//input[1]"));
                ok.click();
        driver.switchTo().window(mainWindow1);
        Thread.sleep(5000);
	//Step 19. Verify the post is Deleted.
        String topics1 = driver.findElement(By.xpath("//a[text()='Topics:']")).getText();
        if (topics1.equals(expected)) {
        	System.out.println("Post is not deleted");
        } else {
            System.out.println("Post is deleted");
		}

	
}

}
}
}
}
}




