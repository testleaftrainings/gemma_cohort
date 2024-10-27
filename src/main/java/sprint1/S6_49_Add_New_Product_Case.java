package sprint1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_49_Add_New_Product_Case {
@Test
	
	public void createOpport() throws InterruptedException {

			ChromeDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			
		// Step 1: Login to Salesforce
			
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
			
			// Step 2: Click View All
			
			driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
			//driver.findElement(By.xpath("//button[text()='View All']")).click();
			WebElement eleViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		    eleViewAll.click();
			
			/*//Step 3: Click Content from App Launcher
			
			driver.findElement(By.xpath("//button[text()='View All']")).click();*/
			
			Thread.sleep(2000);
            driver.findElement(By.xpath("//p[text()='Content']")).click();
			
			//Step 4:  Click View All Key Deals in Key Deals 
			driver.findElement(By.xpath("//span[text()='View All Key Deals']")).click();
			
			
			//Step 5: Click the dropdown from Opportunities and select All Opportunities

			driver.findElement(By.xpath("//button[@title='Select a List View: Opportunities']")).click();
			driver.findElement(By.xpath("//div[@class='listContent']//li[2]//span[text()='All Opportunities']")).click();
			
			//Step 6: Give SRM Steels in Search Box and search
			//WebElement eleSearch = driver.findElement(By.xpath("//input[@aria-label='Search this list...']"));
			WebElement eleSearch = driver.findElement(By.xpath("//div[@type='search']/input[@aria-label='Search this list...']"));
			Thread.sleep(1000);
			eleSearch.sendKeys("SRM Steels");
			Thread.sleep(5000);
			//eleSearch.sendKeys(Keys.ENTER);
			
		    driver.executeScript("arguments[0].click();", eleSearch);
			//driver.findElement(By.xpath("//input[@aria-label='Search this list...']")).sendKeys("SRM Steels");
			Thread.sleep(2000);
		
			//Step 7: Click on the SRM Steels under Opportunity Name 

			driver.findElement(By.xpath("//td[1]//following::a[text()='SRM Steels']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[text()='New Case']")).click();
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//div[@role='listbox']//div[@class='listContent']//li[1]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//a[text()='New']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//li/a[text()='New']")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//label/span[text()='Subject']//following::input")).sendKeys("New Case to SRM Steels");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//footer//following::button/span[text()='Save']")).click();
			
			
			  // Locate the parent element containing the split text
	        WebElement parentElement = driver.findElement(By.xpath("//div[contains(@class,'toastContent')]"));

	        // Find all child elements that contain the split text
	        List<WebElement> childElements = parentElement.findElements(By.xpath("//div[contains(@class,'toastContent')]/div[1]"));

	        // Concatenate text from all child elements
	        StringBuilder fullText = new StringBuilder();
	        for (WebElement element : childElements) {
	            fullText.append(element.getText()).append(" ");
	        }

	        // Print or use the full text
	        System.out.println("Full Text: " + fullText.toString().trim());

			
			

			
			
			
}	

}
