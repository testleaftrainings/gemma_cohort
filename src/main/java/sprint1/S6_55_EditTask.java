package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_55_EditTask {

		public ChromeOptions options = new ChromeOptions();

		@Test
		public void test() throws InterruptedException {
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://login.salesforce.com");
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement applauncher = driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(applauncher));
			applauncher.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//p[text()='Content']")).click();
			Actions a = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//a[@aria-label='View All Tasks']"));
			a.scrollToElement(element).perform();
			element.click();
			
			
			driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[1]")).click();
			driver.findElement(By.xpath("//span[text()='(Pinned list)']")).click();
			
			driver.findElement(By.xpath("//input[@aria-label='Search this list...']")).sendKeys("Email");
			driver.findElement(By.xpath("//input[@aria-label='Search this list...']")).sendKeys(Keys.ENTER);
			
			driver.findElement(By.xpath("(//li[@data-aura-class='oneActionsDropDown'])[2]")).click();
			driver.findElement(By.xpath("//a[@title='Edit']")).click();
			
			driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).click();
			driver.findElement(By.xpath("//span[text()='28']")).click();
			
			
			driver.findElement(By.xpath("(//span[@class='deleteIcon'])[3]")).click();
			
			
//			driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[6]")).click();
//			driver.findElement(By.xpath("//span[@title='Contacts']")).click();

			
			//			driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[8]")).click();

			driver.findElement(By.xpath("(//a[@class='entityMenuTrigger slds-button slds-button--icon slds-shrink-none slds-m-vertical--xxx-small slds-grid slds-grid_align-center'])[3]")).click();
			driver.findElement(By.xpath("//span[@title='Accounts']")).click();
			
			driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();

			driver.findElement(By.xpath("(//span[text()='Logeshwari'])[2]")).click();
			
			driver.findElement(By.xpath("(//button[@title='Save & New']//following::button)[2]")).click();
			
			if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[text()='Task']"));
				System.out.println("Expected result task");
			}
			else
				System.out.println("Not Expected result");
			driver.close();
			
		}}