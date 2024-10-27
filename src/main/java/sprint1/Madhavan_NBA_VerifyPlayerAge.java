package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Madhavan_NBA_VerifyPlayerAge {

    RemoteWebDriver driver;
    WebDriverWait wait;
    @Test
    public void verifyPlayerAge() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome"); //
        dc.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("https://www.nba.com/stats");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'See All Player Stats')]"))).click();
        WebElement SeasonDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(text(),'Season')]/parent::label//select)[1]")));
        Select dropdownSesson = new Select(SeasonDropDown);
        dropdownSesson.selectByValue("2023-24");
        Thread.sleep(2000);
        WebElement SeasonType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(text(),'Season Type')]/parent::label//select)[1]")));
        Select dropdownSeasonType = new Select(SeasonType);
        dropdownSeasonType.selectByVisibleText("NBA Cup");
        Thread.sleep(2000);
        WebElement perModeDropdwon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(text(),'Per Mode')]/parent::label//select)[1]")));
        Select dropdownPerMode = new Select(perModeDropdwon);
        dropdownPerMode.selectByValue("PerGame");
        Thread.sleep(2000);
        WebElement seasonSegmentDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(text(),'Season Segment')]/parent::label//select)[1]")));
        Select dropdownSeasonSegment = new Select(seasonSegmentDropdown);
        dropdownSeasonSegment.selectByVisibleText("Last Game");
        WebElement adPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@id,'bx-close')])[3]")));
        adPopUp.click();
        List<WebElement> listOfPlayerAgeWebElement = driver.findElements(By.xpath("//th[contains(text(),'Age')]//ancestor::table//td[4]"));
        List<String> listPlayerAge = new ArrayList<>();
        for (WebElement element : listOfPlayerAgeWebElement) {
            System.out.println("Player Age--> " + element.getText());
            listPlayerAge.add(element.getText());
        }
        Collections.sort(listPlayerAge);
        System.out.println(listPlayerAge.get(0));
        WebElement playerName =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[contains(text(),'Player')]//ancestor::table//td[4][contains(text(),'" + listPlayerAge.get(0) + "')]//preceding-sibling::td[2]")));

        playerName.click();
        WebElement playerExperience = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),'EXPERIENCE')])[1]//parent::div/p[2]")));
        playerExperience.getText();
        if (playerExperience.getText().contains("1")) {
            Assert.assertTrue(true);
            System.out.println("Pass");
        } else {
            Assert.fail("not matched");

        }
        driver.quit();
    }
}
