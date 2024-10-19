package week2.Assignment;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditCampaign {

	public ChromeOptions options = new ChromeOptions();

	@Test
	public void test() {
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement campaign = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaign);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		driver.findElement(By.xpath("//span[text()='Details']")).click();
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.xpath("//span[text()='Num Sent in Campaign']"))).perform();
		driver.findElement(By.xpath("//button[@title='Edit End Date']")).click();
		driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]")).click();
		
		Actions ax = new Actions(driver);
		ax.scrollToElement(driver.findElement(By.xpath("(//span[text()='Num Sent in Campaign'])[2]"))).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int lastdate = day+4;
  		driver.findElement(By.xpath("//td[@data-datevalue='2024-10-"+lastdate+"']")).click();
		

		driver.findElement(By.xpath("//span[text()='Expected Revenue in Campaign']//parent::label//following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='Expected Revenue in Campaign']//parent::label//following::input[1]")).clear();

		driver.findElement(By.xpath("//span[text()='Expected Revenue in Campaign']//parent::label//following::input[1]")).sendKeys("1000000");

		driver.findElement(By.xpath("//span[text()='Budgeted Cost in Campaign']//parent::label//following::input[1]")).clear();

		driver.findElement(By.xpath("//span[text()='Budgeted Cost in Campaign']//parent::label//following::input[1]")).sendKeys("100000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[@title='Cancel']//following-sibling::button[@title='Save']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		boolean camp = driver.findElement(By.xpath("//span[text()='₹10,00,000']")).isDisplayed();
		System.out.println(camp);
	}
}