package sprint1;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Raja_Assessment {

	@Test
	public void casewoMandatory() throws MalformedURLException, InterruptedException {
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-notifications");
//		DesiredCapabilities dc = new DesiredCapabilities(option);
//		dc.setBrowserName("chrome");
//		dc.setPlatform(Platform.LINUX);
//		// ChromeDriver driver = new ChromeDriver(option);
//		@SuppressWarnings("deprecation")
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nba.com/stats");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement I_Accept = driver.findElement(By.xpath("//button[text()='I Accept']"));
		wait.until(ExpectedConditions.elementToBeClickable(I_Accept));
		I_Accept.click();
		driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();
		WebElement season = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[1]"));
		Select select = new Select(season);
		select.selectByVisibleText("2023-24");
		WebElement seasonType = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[2]"));
		Select select1 = new Select(seasonType);
		select1.selectByVisibleText("NBA Cup");
		WebElement perMode = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[3]"));
		Select select2 = new Select(perMode);
		select2.selectByVisibleText("Per Game");
		WebElement seasonSegment = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[4]"));
		Thread.sleep(3000);
		WebElement elementx = driver.findElement(By.xpath("(//button[@class='bx-close bx-close-link bx-close-inside'])[2]"));
		elementx.click();
		WebElement element3 = driver.findElement(By.xpath("//select[@class='SplitComboDropDown_select__G7wsG']"));
		Select select3 = new Select(element3);
		select3.selectByVisibleText("Last Game");
		List<WebElement> elements = driver.findElements(By.xpath("//td[@class='Crom_text__NpR1_']"));
		List<Integer> s = new ArrayList<Integer>();
		for(int i=1; i<elements.size();i++) {
			String text = driver.findElement(By.xpath("(//td[@class='Crom_text__NpR1_'])["+i+"]//following-sibling::td[1]")).getText();
			int z = Integer.parseInt(text);
			s.add(z);
			System.out.println(s);
		}
		int lowest = Collections.min(s);
		System.out.println(lowest);
		String text = driver.findElement(By.xpath("(//td[text()='" + lowest + "'])[1]/preceding-sibling::td[2]//a")).getText();
		System.out.println(text);
		WebElement eleServiceConsole = driver.findElement(By.xpath("(//td[text()='"+lowest+"'])[1]/preceding-sibling::td[2]//a"));
		driver.executeScript("arguments[0].click();", eleServiceConsole);
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("(//p[@class='PlayerSummary_playerInfoValue__JS8_v']//preceding-sibling::p[text()='EXPERIENCE'])[1]//following-sibling::p")).getText();
		if(text2.equals("1 Year")) 
			System.out.println("True, the player has 1 year of experience");
		else
			System.out.println("False, the player has more than 1 year of experience");
	}
}
