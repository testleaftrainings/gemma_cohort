package Assessments;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheapOAir {
	public static void main(String[] args) throws InterruptedException {
		

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.cheapoair.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement oneway = driver.findElement(By.xpath("//input[@id='onewayTrip']/following::label"));
		wait.until(ExpectedConditions.elementToBeClickable(oneway));
		js.executeScript("arguments[0].click();", oneway);
		WebElement orgincity = driver.findElement(By.xpath("//input[contains(@id,'originCity')]"));
		wait.until(ExpectedConditions.elementToBeClickable(orgincity));
		orgincity.sendKeys("MAA",Keys.TAB);
		WebElement textBox=driver.findElement(By.xpath("//input[contains(@id,'destCity')]"));
		textBox.click();
		textBox.clear();
		textBox.sendKeys("BLR",Keys.ENTER);
		
//		driver.findElement(By.xpath("//div[text()='Traveler']")).click();
//		driver.findElement(By.id("addadults")).click();
//		driver.findElement(By.id("closeDialog")).click();
//		driver.findElement(By.id("searchNow")).click();
//
//		List<WebElement> allElements = driver.findElements(By.xpath("//span[@class='currency text-nowrap']"));
//		List<Double> allPrice = new ArrayList<Double>();
//		for (WebElement eachEle : allElements) {
//			String priceInString = eachEle.getAttribute("title");
//			double priceInDouble = Double.parseDouble(priceInString);
//			allPrice.add(priceInDouble);
//		}
//
//		Collections.sort(allPrice); // Write a logic to find the least price
//		Double least = allPrice.get(0);
//
//		driver.findElement(By.xpath("//span[contains(@title,'" + least + "')]/following::span[text()='Select']"))
//				.click();


	}

}
