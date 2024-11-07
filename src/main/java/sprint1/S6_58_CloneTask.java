package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class S6_58_CloneTask {
	@Test
	public void test58() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		  String apikeylistapi;

		// Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(3000);

		// Click view All from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Click on Content tab
		driver.findElement(By.xpath("//P[text()='Content']")).click();

		// Click View All from Today's Task
		driver.findElement(By.xpath("//span[@title='Today’s Tasks']//following::span[text()='View All']")).click();

		// Click on dropdown in Task and Select a task List view as Open Task
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Open Tasks']")).click();

		// Click On display as list icon and select Table view
		driver.findElement(By.xpath("//button[@title='Select list display'] ")).click();
		driver.findElement(By.xpath("//span[text()='Table']")).click();

		// Click on settings icon and click clone
		driver.findElement(By.xpath("//button[@title='List View Controls']")).click();
		driver.findElement(By.xpath("//span[text()='Clone']")).click();

		// Give the list name as New open tasks and List API Name as New_open_tasks
		driver.findElement(By.xpath("(//h1[text()='Clone List View']//following::input)[1]")).clear();
		driver.findElement(By.xpath("(//h1[text()='Clone List View']//following::input)[1]"))
				.sendKeys("New open tasks");
		driver.findElement(By.xpath("(//h1[text()='Clone List View']//following::input)[2]")).clear();

		driver.findElement(By.xpath("(//h1[text()='Clone List View']//following::input)[2]")).sendKeys("Test_Task16");
		

		// Select All users can see this list view and click Save
		WebElement element = driver.findElement(By.xpath("(//h1[text()='Clone List View']//following::input)[4]"));
		driver.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("(//h1[text()='Clone List View']//following::button)[6]")).click();

		// Save the open task subject field as map
		WebElement element2 = driver.findElement(By.xpath("(//tr//th//a)[11]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element2).perform();
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//span[@class='triggerContainer'])[10]")).click();
		Thread.sleep(7000);
	    driver.findElement(By.xpath("//label[text()='Subject']//following::input")).click();
	    Thread.sleep(7000);
	    WebElement element3=driver.findElement(By.xpath("//label[text()='Subject']//following::input"));
	    element3.clear();
		driver.findElement(By.xpath("//label[text()='Subject']//following::input")).sendKeys("map", Keys.TAB);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		Thread.sleep(500);

		// Click on dropdown in Task and Select a task List view as New Open Tasks
		driver.findElement(By.xpath("(//span[text()='New open tasks'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='New Open'])[1]")).click();

		// Compare with Open Task field map values.
		String text1 = driver.findElement(By.xpath("(//tr//th//a)[11]")).getText();
		String expected = new String("map");
		System.out.println(text1.contains(expected));

		// Verify both are same Expected result:

	}
}
