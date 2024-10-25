package Assignment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Create_New_Chart {

	@Test
public void createNewChart() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		
		
		
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		
		WebElement eleAppLaunch = driver.findElement(By.xpath("//span[text()='App Launcher']"));
		driver.executeScript("arguments[0].click();", eleAppLaunch);
		WebElement eleViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
	    eleViewAll.click();
	    
	    
	    WebElement eleServiceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].click();", eleServiceConsole);
		
		
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//span[text()='Refunds']")).click();
		
		
		driver.findElement(By.xpath("//button[@title='Select a List View: Refunds']")).click();
		driver.findElement(By.xpath("//a[@role='option']//span[text()='All Refunds']")).click();
		
		driver.findElement(By.xpath("//button[@title='Charts']")).click();
		driver.findElement(By.xpath("//span[text()='New Chart']")).click();
		driver.findElement(By.xpath("//label[text()='Chart Name']/following::input[1]")).sendKeys("Test01");
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//driver.findElement(By.xpath("//label[text()='Aggregate Type']/following::button[1]")).click();
		driver.findElement(By.xpath("//label[text()='Aggregate Type']/following::button[@data-value='Count']")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//span[@title='Average']")).click();
		//WebElement eleAverage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Average']")));
		//WebElement eleAverage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='Avg']")));
		
		WebElement eleAverage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-media__body']/span[@title='Average']")));
		js.executeScript("arguments[0].scrollIntoView(true);", eleAverage);
		eleAverage.click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//label[text()='Aggregate Field']/following::button[@name='aggregateFieldPicklist']")).click();
		
		WebElement eleAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-base-combobox-item[@data-value='Refund.Amount']")));
		js.executeScript("arguments[0].click;", eleAmount);
				
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		
		Thread.sleep(4000);
		//a[@title='Settings']
		//a[@title='Settings']//span[text()='Settings']
		/*WebElement eleSettings = driver.findElement(By.xpath("//a[@class='trigger']//span[1]"));
		js.executeScript("arguments[0].click;", eleSettings);*/
		driver.findElement(By.xpath("//a[@class='trigger']//span[1]")).click();
		Thread.sleep(5000);
		
		
		/*WebElement eleChartType= driver.findElement(By.xpath("//div[@role='menu']//a[@title='Donut Chart']"));
		js.executeScript("arguments[0].click;", eleChartType);*/
		driver.findElement(By.xpath("//div[@role='menu']//a[@title='Donut Chart']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
