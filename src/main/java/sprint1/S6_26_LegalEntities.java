package sprint1;

import java.awt.AWTException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_26_LegalEntities {
	 public ChromeDriver driver;
	@Test
	public void test() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//p[text()='Legal Entities']"))).click().perform();
		method();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy, h:mm a");
        List<WebElement> datetimeElements = driver
				.findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
		List<LocalDateTime> dateTimes = new ArrayList<>(); 
        for (int i=0; i<datetimeElements.size();i++) {
        	String z = datetimeElements.get(i).getText();
                LocalDateTime dateTime = LocalDateTime.parse(z, dtf); 
                dateTimes.add(dateTime); 
        }
		Collections.sort(dateTimes);
		Thread.sleep(5000);
		WebElement lastModify = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
		driver.executeScript("arguments[0].click();", lastModify);
		driver.executeScript("arguments[0].click();", lastModify);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		method();
		List<WebElement> datetimeElementss = driver
				.findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
		List<String> datees = new ArrayList<String>();
		for (int i = 0; i < datetimeElementss.size(); i++) {
			String qq = datetimeElementss.get(i).getText();
			datees.add(qq);
		}
		boolean compare = dateTimes.equals(datees);
		System.out.println(compare);
	}

	public void method() {
		String noOfCount = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
		String[] s = noOfCount.split(" ");
		int actualCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
		String actualCountStr = "" + actualCount;
		Actions action = new Actions(driver);
		while (!(actualCountStr.equals(s[0]))) {
			List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr"));
			action.moveToElement(elements.get(elements.size() - 1)).perform();
			noOfCount = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
			s = noOfCount.split(" ");
			actualCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
			actualCountStr = "" + actualCount;
		}

	}
}