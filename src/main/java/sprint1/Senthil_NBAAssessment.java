package sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Senthil_NBAAssessment {
	
	@Test
	public void nbaAssessment() throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--disable-popup-blocking");
		option.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.nba.com/stats");
		driver.manage().window().maximize();
		WebElement allplayerStats = driver.findElement(By.xpath("//a[text()='See All Player Stats']"));
		wait.until(ExpectedConditions.elementToBeClickable(allplayerStats));
		js.executeScript("arguments[0].click();", allplayerStats);
		WebElement cookies = driver.findElement(By.xpath("//button[contains(text(),'Accept')]"));
		wait.until(ExpectedConditions.elementToBeClickable(cookies));
		js.executeScript("arguments[0].click();", cookies);
		
		WebElement seasonDrop = driver.findElement(By.xpath("//p[text()='Season']/following::select"));
		wait.until(ExpectedConditions.elementToBeClickable(seasonDrop));
		Select sel = new Select(seasonDrop);
		sel.selectByValue("2023-24");
		
		WebElement seasontypeDrop = driver.findElement(By.xpath("//p[text()='Season Type']/following::select"));
		wait.until(ExpectedConditions.elementToBeClickable(seasontypeDrop));
		Select selseasontypeDrop = new Select(seasontypeDrop);
		selseasontypeDrop.selectByValue("IST");
		
		WebElement perMode = driver.findElement(By.xpath("//p[text()='Per Mode']/following::select"));
		wait.until(ExpectedConditions.elementToBeClickable(perMode));
		Select selperMode = new Select(perMode);
		selperMode.selectByValue("PerGame");
		
		WebElement seasonSegment = driver.findElement(By.xpath("//p[text()='Season Segment']/following::select"));
		wait.until(ExpectedConditions.elementToBeClickable(seasonSegment));
		Select selseasonSegment = new Select(seasonSegment);
		selseasonSegment.selectByVisibleText("Last Game");
		System.out.println("All Dropdowns are selected");
		
		Thread.sleep(3000);
		List<WebElement> ages = driver.findElements(By.xpath("//table[contains(@class,'Crom_table')]//th/following::tr//td[@class='Crom_text__NpR1_']/following::td[1]"));
		List<Integer> agesList = new ArrayList<Integer>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'Crom_table')]//th/following::tr//td[@class='Crom_text__NpR1_']/following::td[1]")));
		for(WebElement ele : ages) {
			agesList.add(Integer.parseInt(ele.getText()));
		}
		System.out.println(agesList);
		Integer min = agesList.get(0);
		for(int num:agesList) {
			if(num<min) {
				min=num;
			}
		}
		System.out.println("Minimum age is "+min);
		WebElement desiredPlayer = driver.findElement(By.xpath("(//td[text()="+min+"])[1]/preceding-sibling::td[2]//a"));
		wait.until(ExpectedConditions.elementToBeClickable(desiredPlayer));
		desiredPlayer.click();
		String expText = driver.findElement(By.xpath("//p[text()='EXPERIENCE']/following-sibling::*")).getText();
		Assert.assertEquals("1 Year", expText);
		
		
	}

}
