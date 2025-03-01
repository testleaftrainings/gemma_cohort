package sprint1;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_57_NewChart {
	@Test
	public void test57() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		options.addArguments("--headless");
				

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

    // Click on Chart icon
		driver.findElement(By.xpath("//button[@title='Charts']")).click();

	// Click on setting icon and select New Chart
		driver.findElement(By.xpath("//a[@title='Settings']//lightning-icon")).click();
		driver.findElement(By.xpath("//a[@title='New Chart']")).click();

	// Give Chart Name as Opened Tasks
		driver.findElement(By.xpath("//label[text()='Chart Name']//following::input")).sendKeys("Opened Tasks");

	// Select Chart type as Donut Chart
		driver.findElement(By.xpath("//label[text()='Chart Type']//following::button[1]")).click();
		driver.findElement(By.xpath("//span[text()='Donut Chart']")).click();

	// Select Aggregate Field as Priority
		driver.findElement(By.xpath("//label[text()='Aggregate Field']//following::button[1]")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//lightning-base-combobox-item//span[text()='Priority']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

	// Select Grouping Field as Status and Click Save
		WebElement element2 = driver.findElement(By.xpath("//label[text()='Grouping Field']//following::button"));
		driver.executeScript("arguments[0].click();", element2);
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		WebElement element1 = driver
				.findElement(By.xpath("(//lightning-base-combobox-item//span[@title='Status'])[2]"));
		je1.executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		

	//Mouse over on the chart and print the status and Priority count
		/*Thread.sleep(5000);
		WebElement canvasEle = driver.findElement(By.xpath("//h2[text()='Charts']"));
		Actions action = new Actions(driver);
		action.moveByOffset(1300, 400).pause(2000).click().perform();
		Thread.sleep(5000);*/
		Thread.sleep(5000);
		WebElement donutChart = driver.findElement(By.xpath("(//canvas[@class='chart'])[2]"));
		// Get the coordinates of the donut chart
		int width = donutChart.getSize().getWidth();
		int height = donutChart.getSize().getHeight();
		Actions action = new Actions(driver);
		action.moveToElement(donutChart, (width/4), (height/4)).click().build().perform();
		Thread.sleep(5000);
		 
				
		String status = driver.findElement(By.xpath("(//span[@class='marking']//following::label)[2]")).getText();
		System.out.println("Status of the Chart is " + status);
		String priority = driver.findElement(By.xpath("(//tr//td//label)[2]")).getText();
		System.out.println("priority of the Chart is " + priority);
		
		
	// Mouse over on the status field of first result from task list
		WebElement status1 = driver.findElement(By.xpath("((//tr//th//a)//following::div)[43]"));
		action.moveToElement(status1).perform();
		
	// Click on edit icon and change it as complete
		driver.findElement(By.xpath("(//span[@class='triggerContainer'])[5]")).click();
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Completed']")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(5000);
		
	// Click refresh icon and verify the chart Status and priority count of chart
		driver.findElement(By.xpath("//button[@title='Refresh']")).click();
		Thread.sleep(1000);
		
		donutChart = driver.findElement(By.xpath("(//canvas[@class='chart'])[2]"));			
		action.moveToElement(donutChart, (width/4), (height/4)).click().build().perform();
		Thread.sleep(5000);		
		String status2 = driver.findElement(By.xpath("(//span[@class='marking']//following::label)[2]")).getText();
		System.out.println("Status of the Chart is " + status2);
		String priority1 = driver.findElement(By.xpath("(//tr//td//label)[2]")).getText();
		System.out.println("priority of the Chart is " + priority1);
		
		

	}
}
