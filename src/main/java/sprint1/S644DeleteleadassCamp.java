package sprint1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S644DeleteleadassCamp {
	
	@Test
	public void deleteleadasswithcampaign() throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		WebElement appLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(appLauncher));
		js.executeScript("arguments[0].click();", appLauncher);
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.elementToBeClickable(viewAll));
		js.executeScript("arguments[0].click();", viewAll);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement lead = driver.findElement(By.xpath("//span[text()='Leads']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(lead));
		js.executeScript("arguments[0].click();", lead);
		WebElement searchlead = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
		searchlead.sendKeys("Senthil");
		searchlead.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement delteicon = driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]"));
		js.executeScript("arguments[0].click();", delteicon);
		WebElement deletebtn = driver.findElement(By.xpath("//a[@title='Delete']"));
		wait.until(ExpectedConditions.elementToBeClickable(deletebtn));
		js.executeScript("arguments[0].click();", deletebtn);
		WebElement deltecnf = driver.findElement(By.xpath("//span[text()='Delete']/parent::button"));
		wait.until(ExpectedConditions.elementToBeClickable(deltecnf));
		js.executeScript("arguments[0].click();", deltecnf);
		driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/ancestor::div[@role='alert']")).isDisplayed();
		WebElement alertclose = driver.findElement(By.xpath("//button[contains(@class,'close')]"));
		wait.until(ExpectedConditions.elementToBeClickable(alertclose));
		js.executeScript("arguments[0].click();", alertclose);
		WebElement campaigns = driver.findElement(By.xpath("//span[text()='Campaigns']/parent::a"));
		js.executeScript("arguments[0].click();", campaigns);
		driver.findElement(By.xpath("//a[@title='Senthil Campaign Test']")).click();
		WebElement campaignmem = driver.findElement(By.xpath("//span[text()='Campaign Members']/parent::a"));
		wait.until(ExpectedConditions.elementToBeClickable(campaignmem));
		js.executeScript("arguments[0].click();", campaignmem);
		try {
			driver.findElement(By.xpath("//span[text()='Name']/following::a[@title='Senthil Kumar Lead']")).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found so test case is passed");
		}
		
	}

}
