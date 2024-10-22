package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S61CreateAccount{
	
	
	@Test
	public void addAccount() throws InterruptedException, MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		@SuppressWarnings("deprecation")
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		//ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		WebElement menu = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		js.executeScript("arguments[0].click();", menu);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		wait.until(ExpectedConditions.elementToBeClickable(sales));
		js.executeScript("arguments[0].click();", sales);
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		js.executeScript("arguments[0].click();", accounts);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys("Senthilkumar");
		WebElement owner = driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", owner);
		wait.until(ExpectedConditions.elementToBeClickable(owner));
		owner.click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		WebElement accountsa = driver.findElement(By.xpath("//a[@title='Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(accountsa));
		js.executeScript("arguments[0].click();", accountsa);
		WebElement accname = driver.findElement(By.xpath("//a[text()='Senthilkumar']"));
		wait.until(ExpectedConditions.elementToBeClickable(accname));
		accname.isDisplayed();
	
	}

}
