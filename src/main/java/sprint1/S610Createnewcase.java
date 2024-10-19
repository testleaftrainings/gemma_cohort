package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S610Createnewcase {
	
	@Test
	public void addNewCase() {
	
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//click app launcher and view all
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click sales and more arrow button
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement morebutton = driver.findElement(By.xpath("//span[text()='More']/ancestor::div[@role='listitem']"));
		wait.until(ExpectedConditions.elementToBeClickable(morebutton));
		morebutton.click();
		//click cases from more option
		driver.findElement(By.xpath("//span[text()='Cases']/ancestor::one-app-nav-bar-menu-item")).click();
		//click cases to select new case
		WebElement casedd = driver.findElement(By.xpath("//a[@title='Cases']/following::a[@role='button']"));
		wait.until(ExpectedConditions.elementToBeClickable(casedd));
		js.executeScript("arguments[0].click();", casedd);
		WebElement newcase = driver.findElement(By.xpath("//span[text()='New Case']/ancestor::a"));
		wait.until(ExpectedConditions.elementToBeClickable(newcase));
		js.executeScript("arguments[0].click();", newcase);
		//click contact and select contact value
		WebElement contact = driver.findElement(By.xpath("//label[text()='Contact Name']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(contact));
		contact.click();
		WebElement contactname = driver.findElement(By.xpath("(//ul[@aria-label='Recent Contacts']/ancestor::div/ul/li)[2]"));
		contactname.click();
		//click status drop and select escalated
		WebElement status = driver.findElement(By.xpath("//label[text()='Status']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(status));
		js.executeScript("arguments[0].click();", status);
		WebElement escalated = driver.findElement(By.xpath("//span[@title='Escalated']/ancestor::lightning-base-combobox-item"));
		wait.until(ExpectedConditions.elementToBeClickable(escalated));
		js.executeScript("arguments[0].click();", escalated);
		//click case orgin and select email
		WebElement caseorigin = driver.findElement(By.xpath("//label[text()='Case Origin']/following::button"));
		wait.until(ExpectedConditions.elementToBeClickable(caseorigin));
		js.executeScript("arguments[0].click();", caseorigin);
		WebElement email = driver.findElement(By.xpath("//span[@title='Email']/ancestor::lightning-base-combobox-item"));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		js.executeScript("arguments[0].click();", email);
		//navigate to subject and enter testing
		WebElement subject = driver.findElement(By.xpath("//label[text()='Subject']/following::input"));
		js.executeScript("arguments[0].scrollIntoView(true)", subject);
		subject.sendKeys("Testing");
		//navigate to description and enter dummy
		WebElement descrip = driver.findElement(By.xpath("//label[text()='Description']/following::textarea"));
		js.executeScript("arguments[0].scrollIntoView(true)", descrip);
		descrip.sendKeys("Dummy");
		//click save and verify message
		driver.findElement(By.xpath("//button[text()='Save & New']/following::button")).click();
		WebElement completalt = driver.findElement(By.xpath("//span[text()='Case']/ancestor::div[@role='alert']"));
		completalt.isDisplayed();
		
	}

}
