package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_56_FilterTask {

	@Test
	public void test56() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

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
		driver.findElement(By.xpath("//button[@title='Select list display'] ")).click();
		driver.findElement(By.xpath("//span[text()='Table']")).click();

		// Click on Filter icon
		driver.findElement(By.xpath("//button[@title='Filters']")).click();

		// Click on Filter by Owner, select All Tasks and click on Done
		driver.findElement(By.xpath("//span[text()='All tasks']")).click();
		driver.findElement(By.xpath("(//span[text()='All tasks'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();

		// Click on Add Filter and Select Field as Status
		driver.findElement(By.xpath("//a[text()='Add Filter']")).click();
		driver.findElement(By.xpath("//button[@data-value='Assigned Alias']")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//lightning-base-combobox-item[25]"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		// Select Operator as equals and select Value as In Progress
		driver.findElement(By.xpath("(//label[text()='Operator']//following::button)[1]")).click();
		driver.findElement(By.xpath("//span[@title='equals']")).click();
		driver.findElement(By.xpath("//div[text()='Value']//following::a[1]")).click();
		driver.findElement(By.xpath("//a[@title='In Progress']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();

		// Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// Verify whether the status field contains only the value as In Progress
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		
		/*Actions actions = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("(//canvas[@class='chart'])[2]"));
		actions.moveToElement(element1).perform();*/

	}
}
