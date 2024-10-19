package week1.Assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class VerifySorting {

	public ChromeOptions options = new ChromeOptions();
	ChromeDriver driver = new ChromeDriver(options);

	@Test
	public void test() throws AWTException {
		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement account = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		method();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@data-refid='recordId']"));
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText();
			textList.add(text);
		}
		textList.removeIf(String::isEmpty);
		Collections.sort(textList,String.CASE_INSENSITIVE_ORDER);
		
		System.out.println(textList);
		WebElement accountName = driver.findElement(By.xpath("//span[@title='Account Name']"));
		driver.executeScript("arguments[0].click();", accountName);
		method();
		List<WebElement> elements1 = driver.findElements(By.xpath("//a[@data-refid='recordId']"));
		List<String> textList1 = new ArrayList<>();
		for (WebElement element : elements1) {
			String text1 = element.getText();
			textList1.add(text1);
		}
		textList1.removeIf(String::isEmpty);
		System.out.println(textList1);
		boolean isEqual = textList.equals(textList1);
		System.out.println(isEqual);
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
