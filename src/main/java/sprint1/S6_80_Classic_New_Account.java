package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_80_Classic_New_Account {
	@Test
	public void test58() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");

		// Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and
		// click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Choose 'Account' from the dropdown
		driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();

		// Click on the 'Go!' button.
		driver.findElement(By.xpath("(//input [@title='Go!'])[3]")).click();

		// Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
		driver.findElement(By.xpath("//input [@title='New Account']")).click();
		driver.findElement(By.xpath("(//td[@class='labelCol requiredInput']//following::input)[1]"))
				.sendKeys("BootCamp Puppeteer_<Rajeswari>");

		// Enter the Billing Address
		driver.findElement(By.xpath("//textarea[@id='acc17street']")).sendKeys("Mohanur");

		// Click Copy Billing Address to Shipping Address link
		driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();

		// Verify the Shipping Address reflects the Billing Address
		WebElement shipping = driver.findElement(By.xpath("//textarea[@id='acc18street']"));
		String text = shipping.getAttribute("value");
		System.out.println(text);
		String expected = new String("Mohanur");
		System.out.println(text.contains(expected));

		// Enter the SLA Expiration Date as Current Date + 20 days
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//label[text()='SLA Expiration Date']"));
		
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//label[text()='SLA Expiration Date']//following::input")).click();
		driver.findElement(By.xpath("//img[@class='calRight']")).click();
		driver.findElement(By.xpath("(//tr[@class='calRow'])[3]//td[7]")).click();
		Thread.sleep(5000);
		

		// Click on Save button.
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		
		// Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
		String text1 = driver.findElement(By.xpath("//h2[@class='topName']")).getText();
		System.out.println(text1);
		Thread.sleep(3000);
		
		// Navigate to Accounts tab and Verify the newly Created account is displayed
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		String text2 = driver.findElement(By.xpath("//h3[text()='Recent Accounts']//following::a")).getText();
		System.out.println(text2);
		
		// Close the browser
		driver.quit();

	}
}
