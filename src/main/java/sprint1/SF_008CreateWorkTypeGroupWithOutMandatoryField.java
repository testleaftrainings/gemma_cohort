package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SF_008CreateWorkTypeGroupWithOutMandatoryField  extends  BaseClass{

    @Test
    public void TC_006_VerifyWorkTypeGroupMandatoryField() throws InterruptedException {
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Work Type Groups");
        driver.findElement(By.xpath("//mark[contains(text(),'Work Type Groups')]")).click();
        Thread.sleep(5000);
        WebElement dropdownIcon=driver.findElement(By.xpath("(//a[@title='Recently Viewed | Work Type Groups']//following-sibling::one-app-nav-bar-item-dropdown)[2]//one-app-nav-bar-menu-button/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdownIcon);
        WebElement newGroupEle=driver.findElement(By.xpath("//div[@role='menu']//span[text()='New Work Type Group']"));
        js.executeScript("arguments[0].click();", newGroupEle);
        driver.findElement(By.xpath("//label[contains(text(),'Description')]//following-sibling::div/textarea")).sendKeys("From Automation");
        driver.findElement(By.xpath("//label[contains(text(),'Group Type')]//following-sibling::div")).click();
        driver.findElement(By.xpath("//span[@title='Capacity']")).click();
        driver.findElement(By.xpath("//li[@role='presentation'][3]")).click();
        String actualErrorMsg=driver.findElement(By.xpath("//div[contains(@id,'help-message')]")).getText();
        Assert.assertEquals(actualErrorMsg,"Complete this field.");

    }
}
