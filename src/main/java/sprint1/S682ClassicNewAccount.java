package sprint1;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S682ClassicNewAccount {
	
	@Test
	public void classicNewAccount() throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		WebElement accountsTab = driver.findElement(By.xpath("//a[text()='Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(accountsTab));
		js.executeScript("arguments[0].click();", accountsTab);
		WebElement newButton = driver.findElement(By.xpath("//input[@title='New']"));
		wait.until(ExpectedConditions.elementToBeClickable(newButton));
		js.executeScript("arguments[0].click();", newButton);
		
		
		WebElement accountsName = driver.findElement(By.xpath("//label[text()='Account Name']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(accountsName));
		accountsName.sendKeys("BootCamp Puppeteer_Senthil kumar2");
		WebElement billingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(billingStreet));
		billingStreet.sendKeys("J1Selaiyur");
		WebElement billingCity = driver.findElement(By.xpath("//label[text()='Billing City']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(billingCity));
		billingCity.sendKeys("Chennai");
		WebElement province = driver.findElement(By.xpath("//label[contains(text(),'Province')]/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(province));
		province.sendKeys("Tamil Nadu");
		WebElement country = driver.findElement(By.xpath("//label[contains(text(),'Country')]/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(country));
		country.sendKeys("India");
		WebElement copyAddress = driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']"));
		wait.until(ExpectedConditions.elementToBeClickable(copyAddress));
		js.executeScript("arguments[0].click();", copyAddress);
		String copyshippingAddress = driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea")).getAttribute("value");
//		if(copyshippingAddress.equals("J1-Selaiyur")) {
//			System.out.println("Copied address matched");
//		}
//		else
//			throw new Exception("Copied address does not match");
		Assert.assertEquals(copyshippingAddress, "J1Selaiyur");
		WebElement slaExpdate = driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(slaExpdate));
		js.executeScript("arguments[0].click();", slaExpdate);
		LocalDate currDate = LocalDate.now();
		LocalDate plustwentyDays = currDate.plusDays(20);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedPlusTwentyDays  = plustwentyDays.format(formatter);
		WebElement slaDate = driver.findElement(By.xpath("//span[contains(@class,'dateInput')]/child::input"));
		wait.until(ExpectedConditions.elementToBeClickable(slaDate));
		slaDate.sendKeys(formattedPlusTwentyDays);
		WebElement savebtn = driver.findElement(By.xpath("//td[@id='bottomButtonRow']/child::input[@title='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		js.executeScript("arguments[0].click();", savebtn);
		WebElement account = driver.findElement(By.xpath("//a[text()='Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(account));
		js.executeScript("arguments[0].click();", account);
		WebElement viewDrop = driver.findElement(By.id("hotlist_mode"));
		Select sel = new Select(viewDrop);
		sel.selectByVisibleText("Recently Viewed");
		driver.findElement(By.xpath("//a[contains(text(),'Senthil')]")).isDisplayed();
		
	}

}
