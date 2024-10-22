package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S621Updatecontact {
	
	@Test
	public void updateContact() throws InterruptedException, MalformedURLException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		//ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on menu button from the Left corner and click View All
		WebElement appluancher = driver.findElement(By.xpath("//button[@title='App Launcher']/div"));
		wait.until(ExpectedConditions.elementToBeClickable(appluancher));
		appluancher.click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on contacts under 'All Items'
		WebElement contacts = driver.findElement(By.xpath("//p[text()='Contacts']"));
		js.executeScript("arguments[0].scrollIntoView(true);", contacts);
		contacts.click();
		Thread.sleep(4000);
		//Get the size of conatcts available and print the list
		String noOfCount = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText(); //get count of act items table top
		String[] split = noOfCount.split(" "); //splitting items text associated with a value text
		int actualCount = driver.findElements(By.xpath("//th[@scope='row']//a")).size();//finding the actual table content before loading
		String actualCountstr=""+actualCount;// adding string into int value to to get first index of before noOfCounts
		Actions action = new Actions(driver);
		while(!(actualCountstr.equals(split[0])))  // actualcount is not equal to exp count
		{
			List<WebElement> tableelements =null;
			for(int i=0;i<actualCount;i++) {
			List<WebElement> elements = driver.findElements(By.xpath("//th[@scope='row']//a")); //finding elements
			WebElement targetelement = elements.get(elements.size()-1); //navigating to last of before element to reload DOM
			action.moveToElement(targetelement).perform();// movinginto that field
			 tableelements = driver.findElements(By.xpath("//th[@scope='row']//a"));//Printing the values of account
			}
			System.out.println("The actual size of table is "+tableelements.size());
			for(WebElement element: tableelements) {
				System.out.println(element.getText().toString());
			}
			break;
		}

//		search for the contact using unique name
		WebElement input = driver.findElement(By.xpath("//label[contains(text(),'Search this list')]/following::input[contains(@placeholder,'Search this list')]"));
		input.sendKeys("Senthil");
		input.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement more = driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]"));
		js.executeScript("arguments[0].click();", more);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/parent::li"));
		edit.click();
//		Update Email with your personal mail id
		WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.clear();
		email.sendKeys("senthilkumar0013@gmail.com");
//		Update Lead Source as Partner Referral from bottom
		WebElement leadsource = driver.findElement(By.xpath("//label[text()='Lead Source']/following::button"));
		js.executeScript("arguments[0].scrollIntoView(true)", leadsource);
		wait.until(ExpectedConditions.elementToBeClickable(leadsource));
		js.executeScript("arguments[0].click();", leadsource);
		WebElement leadsourceval = driver.findElement(By.xpath("//span[text()='Partner Referral']/parent::span"));
		wait.until(ExpectedConditions.elementToBeClickable(leadsourceval));
		leadsourceval.click();
//		Update MailingAddress with personal address
		WebElement address = driver.findElement(By.xpath("//label[text()='Mailing Street']/following::textarea"));
		js.executeScript("arguments[0].scrollIntoView(true);", address);
		address.clear();
		address.sendKeys("Mela Anuppanadi, Madurai 09");
//      Update Level as Tertiary
		WebElement level = driver.findElement(By.xpath("//label[text()='Level']/following::lightning-base-combobox"));
		js.executeScript("arguments[0].scrollIntoView(true)", level);
		level.click();
		WebElement tertiary = driver.findElement(By.xpath("//span[text()='Tertiary']/parent::span"));
		tertiary.click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement alert = driver.findElement(By.xpath("//span[text()='Success']/ancestor::div[@role='alert']"));
		wait.until(ExpectedConditions.elementToBeClickable(alert));
		alert.isDisplayed();
		WebElement gridEmail = driver.findElement(By.xpath("//a[contains(@class,'emailuiFormattedEmail')]"));
		String stringofEle = gridEmail.getText().toString();
		Assert.assertEquals(stringofEle, "senthilkumar0013@gmail.com", "Email has been verified");
		
		
	}

}
