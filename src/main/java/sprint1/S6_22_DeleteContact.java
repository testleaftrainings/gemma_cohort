package sprint1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_22_DeleteContact {
@Test
	
	public void deleteContact() throws InterruptedException {

			ChromeDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			
		// Step 1: Login to Salesforce
			
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf$321");
			driver.findElement(By.id("Login")).click();
			
			// Step 2: Click View All
			
			driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
			
			//Thread.sleep(2000);
			WebElement eleViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
			eleViewAll.click();
			//	driver.findElement(By.xpath("//button[text()='View All']")).click();
			
			// Step 3: Click on Contacts under All Items 
			
			WebElement eleContacts = driver.findElement(By.xpath("//p[text()='Contacts']"));
			
			// Use JavaScript to scroll the element into view

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", eleContacts);
			eleContacts.click();
			
			// Step 4: Click Contacts tab
			WebElement eleParent = driver.findElement(By.xpath("//span[text()='Contacts']"));
			js.executeScript("arguments[0].click();", eleParent);
			
			// Step 5: Get the size of contacts available and print the list 
			
			 /*List<WebElement> contactsList = driver.findElements(By.cssSelector(".contactSelector"));
	            System.out.println("Number of Contacts: " + contactsList.size());
	            for (WebElement contact : contactsList) {
	                System.out.println(contact.getText());
	            }*/
			
			String noOfCount = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']")).getText();
	        String[] s = noOfCount.split(" ");
	        int actualCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
	         String actualCountStr = ""+actualCount;
	         Actions action = new Actions(driver);
	        while(!(actualCountStr.equals(s[0]))){
	            List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr"));
	            action.moveToElement(elements.get(elements.size()-1)).perform();
	            noOfCount = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	            s = noOfCount.split(" ");
	            actualCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
	            actualCountStr = ""+actualCount;
	            /*for (WebElement contact : elements) {
	                System.out.println(contact.getText());}
	            System.out.println("Number of Contacts: " + elements.size());*/
	            int nameColumnIndex = 2; // Adjust this index to the column containing contact names
	            for (WebElement row : elements) {
	                List<WebElement> cells = row.findElements(By.xpath("//table/tbody/tr/td"));
	                if (cells.size() > nameColumnIndex) {
	                    WebElement nameCell = cells.get(nameColumnIndex);
	                    // Print the text of the contact name cell
	                    System.out.println(nameCell.getText());
	                }
	            }
	            
	            System.out.println("Number of Contacts: " + elements.size());   
	        }
	        
           
			// Step 6: search for the contact using unique name
			
			 driver.findElement(By.xpath("//label[contains(text(),'Search this list')]/following::input[@type='search']")).sendKeys("Test05");
			 
			 //Step 7: Get the text of Contact name and store it 
			 
			 String uniqueName = "Test05";
			 String contactName = driver.findElement(By.xpath("//a[text()='"+uniqueName+"']")).getText();
			 System.out.println(contactName);
			 //String contactName1 = driver.findElement(By.xpath("//a[@title='Test01']")).getText();
			 String contactName1 = driver.findElement(By.xpath("//a[@data-refid='recordId']")).getText();
			 System.out.println(contactName1);
			 
			 //Step 8: Click on the dropdown icon available in the unique contact and select Delete
			 Thread.sleep(4000);
			 WebElement eleDeleteDropDown = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//tr/td[8]//a"));
		     js.executeScript("arguments[0].click();", eleDeleteDropDown);
		   
		     Thread.sleep(5000);
		     WebElement eleDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Delete']")));
		     eleDelete.click();
		     //driver.findElement(By.xpath("//a[@title='Delete']")).click();
		  
		     
		     WebElement eleDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Delete']")));
		     eleDeleteButton.click();
		     
			 
			 //Step 9: Verify whether the Contact is Deleted 

	         List<WebElement> deletedContact = driver.findElements(By.xpath("//a[text()='"+uniqueName+"']"));           
             
	         if(deletedContact.isEmpty()) {
	        	 System.out.println("Test Passed: Contact is deleted");
	         } else {
	        	 System.out.println("Test Failed: Contact is not deleted");
	         }
}
}