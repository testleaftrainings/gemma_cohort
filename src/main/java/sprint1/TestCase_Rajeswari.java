package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCase_Rajeswari {
	@Test
	public void test() throws InterruptedException, MalformedURLException {
		/*ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();*/
		
		DesiredCapabilities dc =
				new DesiredCapabilities();
				                dc.setBrowserName("chrome");
				                dc.setPlatform(Platform.
				LINUX);
				                RemoteWebDriver driver = 
				new RemoteWebDriver(
				new URL("http://20.40.48.160:4444/wd/hub"), dc);

		// Navigate to https://www.nba.com/stats
		driver.get("https://www.nba.com/stats");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='I Decline']")).click();

		// Click on 'See All Player Stats'
		driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();

		// Choose 'Season' as '2023-24'
		driver.findElement(By.xpath("(//p[text()='Season']//following::div)[1]")).click();
		driver.findElement(By.xpath("//option[text()='2023-24']")).click();

		// Choose 'Season Type' as 'NBA Cup'
		driver.findElement(By.xpath("(//p[text()='Season Type']//following::div)[1]")).click();
		driver.findElement(By.xpath("//option[text()='NBA Cup']")).click();

		// Choose 'Per Mode' as 'Per Game'
		driver.findElement(By.xpath("(//p[text()='Per Mode']//following::div)[1]")).click();
		driver.findElement(By.xpath("//option[text()='Per Game']")).click();

		// Choose 'Season Segment' as 'Last Game'
		driver.findElement(By.xpath("(//option[text()='Last Game'])")).click();
		

		// Click on the player name with lowest age		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement tableElement = driver.findElement(By.xpath("//a[text()='Jarace Walker']"));	
		je.executeScript("arguments[0].scrollIntoView(true);", tableElement);
		// List<WebElement> columns = tableElement.findElements(By.xpath("//th[text()='Age']"));

		// Click on the Profile
		WebElement element = driver.findElement(By.xpath("//a[text()='Jarace Walker']"));
		driver.executeScript("arguments[0].click();", element);
		// Get the Experience of the player
		 String experience = driver.findElement(By.xpath("(//p[text()='EXPERIENCE']//following::p)[1]")).getText();
		// Verify the player experience as 1.
		 String expected = new String ("1 Year");
		 System.out.println(experience.contains(expected));

	}
}

