package sprint1;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase_Rajeswari {
	@Test
	public void test() throws InterruptedException, MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		/*
		 * DesiredCapabilities dc = new DesiredCapabilities();
		 * dc.setBrowserName("chrome"); dc.setPlatform(Platform. LINUX); RemoteWebDriver
		 * driver = new RemoteWebDriver( new URL("http://20.40.48.160:4444/wd/hub"),
		 * dc);
		 */

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
		Thread.sleep(3000);
		List<WebElement> Listofage = driver.findElements(By.xpath("(//th[text()='Age'])//ancestor::table//td[4]"));
		List<String> ages = new ArrayList<>();
		for (WebElement element : Listofage) {
			ages.add(element.getText());
		}
		Collections.sort(ages);
		System.out.println("Lowest age in the list is " + ages.get(0));

		// Click on the Profile
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement player = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//th[text()='Age'])//ancestor::table//td[4][contains(text(),'"
						+ ages.get(0) + "')]//preceding-sibling::td[2]")));
		player.click();

		// Get the Experience of the player
		String experience = driver.findElement(By.xpath("(//p[text()='EXPERIENCE']//following::p)[1]")).getText();
		System.out.println(experience);

		// Verify the player experience as 1.
		String expected = new String("1 Year");
		System.out.println(experience.contains(expected));

	}
}