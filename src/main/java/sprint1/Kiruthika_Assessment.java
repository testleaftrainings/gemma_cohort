package sprint1;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Kiruthika_Assessment {
@Test
	
	public void createOpport() throws InterruptedException {

	
	/* 
	 * EdgeOptions options = new EdgeOptions();
	 * DesiredCapabilities dc = new DesiredCapabilities();
	 
	// dc.setBrowserName("MicrosoftEdge");
	 dc.setBrowserName("chrome');
	 dc.setPlatform(Platform.LINUX);
	 RemoteWebDriver driver =new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
    */
					
	//EdgeOptions options = new EdgeOptions();
	//ChromeDriver driver = new ChromeDriver();
	
	// Step 1: Navigate to https://www.nba.com/stats
	
			ChromeDriver driver=new ChromeDriver();
			driver.get(" https://www.nba.com/stats");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
	// Step 2:  Click on 'See All Player Stats'
			
			driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();
			
	// Step 3. Choose 'Season' as '2023-24'

			driver.findElement(By.xpath("//p[text()='Season']//following::div")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[text()='Season']//following::div/select/option[@value='2023-24']")).click();
			
			
	// Step 4: Choose 'Season Type' as 'NBA Cup'
			
			driver.findElement(By.xpath("//p[text()='Season Type']//following::div")).click();
			driver.findElement(By.xpath("//p[text()='Season Type']//following::div/select/option[@value='IST']")).click();
			
	// Step 5: Choose 'Per Mode' as 'Per Game'
			
			driver.findElement(By.xpath("//p[text()='Per Mode']//following::div")).click();
			driver.findElement(By.xpath("//p[text()='Per Mode']//following::div/select/option[@value='PerGame']")).click();
			
	//Step 6: Choose 'Season Segment' as 'Last Game'
			
			driver.findElement(By.xpath("//p[text()='Season Segment']//following::div")).click();
			driver.findElement(By.xpath("//p[text()='Season Segment']//following::option[@value='LastNGames=1']")).click();
			
		driver.findElement(By.xpath("//button[text()='Continue without Deciding']")).click();
		Thread.sleep(1000);
			
	//Step 7:  Click on the player name with lowest age
			
			List<WebElement> elePlayers = driver.findElements(By.xpath("//table[@class='Crom_table__p1iZz']//tr/td[3]//following::td[1]"));
			
			
			int minAge = Integer.parseInt(elePlayers.get(0).getText()); 
			
		   
			
			for (WebElement player : elePlayers) {
			    int age = Integer.parseInt(player.getText());
			    if (age <= minAge) {
			        minAge = age;
			       
			    }
			}
			System.out.println("minAge is " + minAge);
			
			
			driver.findElement(By.xpath("//table[@class='Crom_table__p1iZz']//tr/td[3]//following::td[1][text()='"+minAge+"']/preceding-sibling::td[2]")).click();
			
	// Step 8: Click Profile
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Profile']")).click();
			String expOfYoungPlayer = driver.findElement(By.xpath("//p[text()='EXPERIENCE']//following::p")).getText();
			System.out.println("Experience is " + expOfYoungPlayer);
			
	//Step 9: Verify experience is 1
			if(expOfYoungPlayer.equals("1 Year")) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test failed");
			}
			
				
}
}
