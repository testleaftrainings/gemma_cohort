package sprint1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_48_Add_Product_With_Opportunity {
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
			
			//Step 8: Click on dropdown of Products under Related and select Add Products 
			driver.findElement(By.xpath("//span[@title='Products']")).click();
			driver.findElement(By.xpath("//div[@title='Add Products']")).click();
			Thread.sleep(5000);
			
			
			//Step 9: Click on List Price to sort the result and select the highest priced product 

			//driver.findElement(By.xpath("//th[@aria-label='List Price']")).click();
			//WebElement eleList = driver.findElement(By.xpath("//span[@title='List Price']"));
			WebElement eleList = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//th[@aria-label='List Price']//span[text()='Sort']"));
			driver.executeScript("arguments[0].click();", eleList);
			Thread.sleep(2000);
			//WebElement eleList = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//th[@aria-label='List Price']//span[text()='Sort']"));
			driver.executeScript("arguments[0].click();", eleList);
			Thread.sleep(2000);
			
			
			
			
			//WebElement eleRow1 = driver.findElement(By.xpath("//td//input[@aria-label='Select item 1']"));
			WebElement eleRow1 = driver.findElement(By.xpath("//th[@title='Product Code']//following::input[@aria-label='Select item 1']//following::span[1]"));
			driver.executeScript("arguments[0].click();", eleRow1);
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button/span[text()='Next']")).click();
			Thread.sleep(8000);
			
			//WebElement eleQuantity = driver.findElement(By.xpath("//button/span[text()='Edit Quantity: Item null']"));
			WebElement eleQuantityc = driver.findElement(By.xpath("//button[@title='Edit Quantity: Item null']"));
			eleQuantityc.click();
			Thread.sleep(2000);
			//WebElement eleQuantity = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//span[text()='Quantity']//following::div[1]"));
			WebElement eleQuantity = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//label[text()='Quantity']//following::div[1]/input"));
			eleQuantity.sendKeys("560");
			//driver.findElement(By.xpath("//label[text()='Quantity']//following::input[@type='text']")).sendKeys("560");
			//driver.findElement(By.xpath("//button[@title='Edit Quantity: Item null']//following::span[text()='Edit Quantity: Item null']")).sendKeys("560.00");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebElement eleEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Edit Quantity: Item null']//following::span[text()='Edit Quantity: Item null']")));
			 
			//WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit Quantity: Item null']//following::span[text()='Edit Quantity: Item null']")));
            //quantityField.clear();
            //quantityField.sendKeys("560");
            
			JavascriptExecutor js = (JavascriptExecutor) driver;
		     //   js.executeScript("arguments[0].scrollIntoView(true);", eleEdit);

		        // Ensure the element is visible and interactable
		      //  wait.until(ExpectedConditions.elementToBeClickable(eleEdit));
		        	
		        // Use JavascriptExecutor to send keys
		      //  js.executeScript("arguments[0].value='560';", eleEdit);
			
			/*	js.executeScript("arguments[0].focus();", eleEdit);

	        // Send keys using Selenium's sendKeys
	        eleEdit.sendKeys(Keys.HOME + "560");
			*/
		        // Clear the element first
		    /*    eleEdit.clear();

		        // Use JavascriptExecutor to set focus on the element
		        js.executeScript("arguments[0].focus();", eleEdit);

		        // Use JavascriptExecutor to send keys
		        js.executeScript("arguments[0].value='';", eleEdit);
		        js.executeScript("arguments[0].value=arguments[0].value + '560';", eleEdit);*/
			//js.executeScript("arguments[0].value='560';",eleEdit);
			//WebElement eleQuantity = driver.findElement(By.xpath("//label[text()='Quantity']//following::div[1]/input[@part='input']"));
			//WebElement eleQuantity = driver.findElement(By.xpath("//button[contains(@title,'Edit Quantity')]"));
			//WebElement eleQuantity = driver.findElement(By.xpath("//label[text()='Quantity']//following::input[@type='text']"));
			//js.executeScript("arguments[0].click();", eleQuantity);
			
			//Thread.sleep(2000);
			//eleQuantity.sendKeys("560.00");
			//js.executeScript("arguments[0].value='560';", eleQuantity);
			
			//eleQuantity.sendKeys("560");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			Thread.sleep(3000);
			
			String textMessage = driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]")).getText();
			
			System.out.println("Test Results :" + textMessage );
			
		
			
			
			
			
			
			
		/*	String productName = driver.findElement(By.xpath("//a[text()='GenWatt Gasoline 2000kW']")).getText();
			String salesPrice = driver.findElement(By.xpath("//button[contains(@title, 'Edit Sales Price')]")).getText();
			Thread.sleep(2000);
		*/	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//	WebElement eleRow = driver.findElement(By.xpath("//table[@aria-label='Products']/tbody//tr[1]"));
			
		//	List<WebElement> items = row.findElement(By.xpath)
			//1 Opportunity Product record was updated.
			/*List<WebElement> items = driver.findElements(By.xpath("//table[@aria-label='Recently Viewed']//tbody//td[4]"));
		
			//code to get highest price
			//List<WebElement> items = driver.findElements(By.cssSelector(""));

	        double highestPrice = 0;
	        for (WebElement item : items) {
	            String priceText = item.getText();
	         // Clean up the currency string
	            String cleanText = priceText.replaceAll("[^\\d.]", "").trim();
	            try {
	                // Parse the cleaned string
	                double price = Double.parseDouble(cleanText);
	                if (price > highestPrice) {
	                    highestPrice = price;
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Number format error for: " + cleanText);
	                e.printStackTrace();
	            }
	            
	        }

	        System.out.println("The highest price is: " + highestPrice);*/

	        
	        
}
}