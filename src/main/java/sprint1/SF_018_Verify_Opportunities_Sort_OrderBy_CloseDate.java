package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SF_018_Verify_Opportunities_Sort_OrderBy_CloseDate extends BaseClass {

    @Test
    public void tc_018018_Verify_Opportunities_Sort_OrderBy_CloseDate() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']")));
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Sales']")));
        WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Opportunities']"));
        js.executeScript("arguments[0].click();", eleAccounts);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@title='Select list display']//lightning-primitive-icon)[2]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Table')]")).click();
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//th[@title='Close Date'])//a")));
        scrollToLastRowTable();
        Thread.sleep(3000);
        List<WebElement> listOfCloseDate = driver.findElements(By.xpath("//span[@class='uiOutputDate']"));
        List<LocalDate> myDateList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // create a LocalDate object and
        for (WebElement element : listOfCloseDate) {
            String text = element.getText();
            LocalDate lt = LocalDate.parse(text, formatter);
            myDateList.add(lt);
        }
        //myDateList.removeIf(String::isEmpty);
        Collections.sort(myDateList);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//th[@title='Close Date'])//a")));
        Thread.sleep(3000);
        scrollToLastRowTable();
        Thread.sleep(3000);
        List<WebElement> listOfCloseDate1 = driver.findElements(By.xpath("//span[@class='uiOutputDate']"));
        List<LocalDate> myDateList1 = new ArrayList<>();
        for (WebElement element : listOfCloseDate1) {
            String text = element.getText();
            LocalDate lt = LocalDate.parse(text, formatter);
            myDateList1.add(lt);
        }

        if (myDateList.equals(myDateList1)) {
            Assert.assertTrue(true, "Opportunity is Ascending order");
        } else {
            Assert.fail("Opportunity is not ascending order");
        }
    }

    public void scrollToLastRowTable() {
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
