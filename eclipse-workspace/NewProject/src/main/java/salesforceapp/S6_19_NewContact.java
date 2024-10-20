package salesforceapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class S6_19_NewContact {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
//@Test
		// ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("excludeSwitches", new String[] {
		// "enable-automation" });
		// options.addArguments("--disable-notifications");
		// ChromeDriver driver = new ChromeDriver(options);
		// driver.manage().window().maximize();

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("MicrosoftEdge");
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);

		// Step 1: Login to Login | Salesforce
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		// Click on Global Actions SVG icon
		WebElement element = driver
				.findElement(By.xpath("//ul[@class='slds-global-actions']//li[2]//a//lightning-primitive-icon"));
		driver.executeScript("arguments[0].click();", element);

		// After clicking Global Actions SVG icon, Click 'New Contact'.
		WebElement element1 = driver.findElement(By.xpath("//span[text()='New Contact']"));
		driver.executeScript("arguments[0].click();", element1);

		// Pick Salutation as 'Mr.
		driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();

		// Enter First Name as 'Naveen'
		driver.findElement(By.xpath("//span[text()='First Name']/following::input[1]")).sendKeys("Naveen");

		// Enter Last Name as 'Elumalai'
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input[1]")).sendKeys("Elumalai");

		// Enter email as 'naveen@test.com'
		driver.findElement(By.xpath("(//h2[@title='Naveen'])//following::span[text()='Email']//following::input[1]"))
				.sendKeys("naveen@test.com");

		// Create a New Account for Account Name
		driver.findElement(By.xpath("//span[text()='Account Name']//following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='New Account']")).click();

		// Enter account name as 'Credits' and save
		driver.findElement(By.xpath("(//span[text()='Account Name']) [2]//following::input[1]")).sendKeys("Credits");
		driver.findElement(By.xpath("//span[text()='Description Information']/following::button[@title='Save']"))
				.click();
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

		Thread.sleep(10000);
		// Click and save
		WebElement element2 = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click();", element2);

		// Verify contact using Unique name and print the name
		String text1 = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text1);

	}
}
