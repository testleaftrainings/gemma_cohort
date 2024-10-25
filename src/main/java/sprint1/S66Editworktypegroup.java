package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S66Editworktypegroup {
	
	@Test
	public void editWorkTypeGroup() throws InterruptedException, MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		//ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//Click on the toggle menu button from the left corne
		driver.findElement(By.xpath("//button[@title='App Launcher']/child::div")).click();
		//Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement worktype = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", worktype);
		worktype.click();
		//Search the Work Type Group 'Salesforce Automation by *Your Name*
		WebElement worktypegrpname = driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list')]"));
		worktypegrpname.sendKeys("Salesforce Automation by Senthil");
		worktypegrpname.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//Click on the Dropdown icon and Select Edit
		WebElement showactions = driver.findElement(By.xpath("(//td[@role='gridcell'])[5]/span/div/a"));
		wait.until(ExpectedConditions.elementToBeClickable(showactions));
		js.executeScript("arguments[0].click();", showactions);
		driver.findElement(By.xpath("//a[contains(@data-target-selection-name,'Edit')]")).click();
		//Enter Description as 'Automation'.
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).clear();
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Automation");
		//Select Group Type as 'Capacity'
		WebElement grouptype = driver.findElement(By.xpath("(//label[text()='Group Type']/following::button)[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", grouptype);
		grouptype.click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement wtname = driver.findElement(By.xpath("//a[text()='Salesforce Automation by Senthil']"));
		wait.until(ExpectedConditions.elementToBeClickable(wtname));
		js.executeScript("arguments[0].click();", wtname);
		WebElement descr = driver.findElement(By.xpath("//span[text()='Description']/parent::div/following::lightning-formatted-text[text()='Automation']"));
		descr.isDisplayed();
		
		
		
		
	}

}
