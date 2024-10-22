package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SF_037CreateCampaign extends  BaseClass {

    @Test
    public void tc_037CreateCampaign() throws InterruptedException {
        String campaignName = "Bootcamp";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Sales");
        driver.findElement(By.xpath("(//p/mark[text()='Sales'])[3]")).click();
       WebElement campaignTab= driver.findElement(By.xpath("//a[@title='Campaigns']"));
        js.executeScript("arguments[0].click();", campaignTab);
        driver.findElement(By.xpath("//div[@title='New']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Campaign Name')]//parent::label//following-sibling::input")).sendKeys(campaignName);
        driver.findElement(By.xpath("//span[contains(text(),'Start Date')]//parent::label//following-sibling::div/a")).click();
        WebElement tmrDate=driver.findElement(By.xpath("//td/span[contains(text(),'"+Utility.getTmrwDate().substring(8)+"')]"));
        js.executeScript("arguments[0].click();", tmrDate);
        driver.findElement(By.xpath("//span[contains(text(),'End Date')]//parent::label//following-sibling::div/a")).click();
        WebElement tmrDatePluse1Date=driver.findElement(By.xpath("//td/span[contains(text(),'"+Utility.getTmrwDatePluse().substring(8)+"')]"));
        js.executeScript("arguments[0].click();", tmrDatePluse1Date);
        driver.findElement(By.xpath("(//button[@title='Save'])[2]/span")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
        if (actualText.toLowerCase().replaceAll("[^A-Za-z0]", " ").contains(campaignName.toLowerCase())) {
            System.out.println("Pass");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Campaign not created");
        }
    }
}
