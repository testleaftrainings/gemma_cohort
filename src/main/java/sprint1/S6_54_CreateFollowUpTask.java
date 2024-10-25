package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_54_CreateFollowUpTask {

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
			Thread.sleep(5000);
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
			
			driver.findElement(By.xpath("//button[@title='Select list display']")).click();
			driver.findElement(By.xpath("//li[@title='Display as table']")).click();
			driver.findElement(By.xpath("(//a[@role='button']//span[@class='slds-icon_container slds-icon-utility-down'])[1]")).click();
//			WebElement elementx = driver.findElement(By.xpath("(//a[@role='button']//span[@class='slds-icon_container slds-icon-utility-down'])[1]"));
//			driver.executeScript("arguments[0].click();", elementx);
			driver.findElement(By.xpath("(//a[@title='Create Follow-Up Task'])[2]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click();
			driver.findElement(By.xpath("//span[@title='Call']")).click();
			
			WebElement element3 = driver.findElement(By.xpath("//span[@id='quickTextKeyboardTip']"));
			a.scrollToElement(element3).perform();
			
			driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[8]")).click();
			driver.findElement(By.xpath("//a[@title='High']")).click();
			
			
			
			driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[5]")).click();
			driver.findElement(By.xpath("//a[@title='In Progress']")).click();
			
			
			driver.findElement(By.xpath("(//span[@class='deleteIcon'])[2]")).click();
			
			
			driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[6]")).click();
			driver.findElement(By.xpath("//span[@title='Contacts']")).click();


			driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click();
			driver.findElement(By.xpath("(//span[text()='Prabhu M']/parent::lightning-formatted-rich-text)[1]")).click();
			
			driver.findElement(By.xpath("(//span[@class='deleteIcon'])[3]")).click();

			
			driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[7]")).click();
			driver.findElement(By.xpath("//span[@title='Products']")).click();

			driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).click();
			driver.findElement(By.xpath("//div[@title='JeyaGokul']")).click();

			
			
			driver.findElement(By.xpath("(//button[@title='Save & New']//following::button)[2]")).click();
			
			if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[text()='Call']"));
				System.out.println("Expected result task");
			}
			else
				System.out.println("Not Expected result");
			driver.close();
			
		}}