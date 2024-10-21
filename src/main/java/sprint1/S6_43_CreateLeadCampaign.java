package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_43_CreateLeadCampaign {
	@Test
	public void test43() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Login to Login | Salesforce
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Campaigns tab
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		driver.executeScript("arguments[0].click();", element);

		// Click Bootcamp link
		driver.findElement(By.xpath("//a[@title='Bootcamp'] ")).click();

		// Click Add Leads
		WebElement element3 = driver.findElement(By.xpath("//div[@title='Add Leads']"));
		driver.executeScript("arguments[0].click();", element3);
		Thread.sleep(7000);

		// Click on New Lead
		//WebElement element4 = driver.findElement(By.xpath("//h1[text()='Add Leads to Campaign']//following::input[@title='Search Leads']"));
		//driver.executeScript("arguments[0].click();", element4);
		driver.findElement(By.xpath("//h1[text()='Add Leads to Campaign']//following::input[@title='Search Leads']//following::lightning-icon[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='New Lead']")).click();

		// Pick Salutation as 'Mr.'
		driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();

		// Enter first name as <your First Name>
		driver.findElement(By.xpath("(//span[text()='First Name']/following::input)[1]")).sendKeys("Rajeswari");

		// Enter last name as <your last name>
		driver.findElement(By.xpath("(//span[text()='Last Name']/following::input)[1]")).sendKeys("Subramani");

		// Enter company as 'TestLeaf'
		driver.findElement(By.xpath("(//span[text()='Company'])[2]//following::input[1]")).sendKeys("Testleaf");

		// Click Save
		driver.findElement(By.xpath("//span[text()='Description Information']/following::button[@title='Save']"))
				.click();

		// Click Next
		driver.findElement(By.xpath("//div[@class='modal-footer slds-modal__footer']//following::button")).click();

		// Click Submit on the Add to Campaign pop up
		WebElement element2 = driver
				.findElement(By.xpath("//span[text()='Overwrite member status']//following::button[2]"));
		driver.executeScript("arguments[0].click();", element2);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println("Created lead: ");
		System.out.println(text);

		// verify the created Lead under Campaign
		WebElement element5 = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", element5);
		String text1 = driver.findElement(By.xpath("(//tr//th)[2]")).getText();
		System.out.println(text1);

		// Navigate to Leads tab
		WebElement element6 = driver.findElement(By.xpath("//span[text()='Leads']"));
		driver.executeScript("arguments[0].click();", element6);
		
		// Search for Lead with your Name
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Search this list...'])")).sendKeys("Rajeswari Subramani",
				Keys.ENTER);

		// Lead should be created in Leads tab and associated to Campaign
		String text2 = driver.findElement(By.xpath("(//tr//th)[12]")).getText();
		System.out.println("Lead name associated with Campaign: ");
		System.out.println(text2);

	}
}
