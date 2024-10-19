package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SF_035CreateOrder extends  BaseClass {

    @Test
    public void tc_035CreateOrder() throws InterruptedException {
        String contractName = "00000133";
        String accountName = "Testleaf Software";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Service console");
        driver.findElement(By.xpath("//p/mark[text()='Service Console']")).click();
        driver.findElement(By.xpath("//div[@title='New']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(),'Contract Number')]//following-sibling::div//input")).sendKeys(contractName);
        driver.findElement(By.xpath("(//ul[@role='group']/li)[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).sendKeys(accountName);
        driver.findElement(By.xpath("(//ul[@role='group'])[2]/li")).click();
        driver.findElement(By.xpath("//input[@name='EffectiveDate']")).click();
        driver.findElement(By.xpath("//button[@title='Next Month']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td/span[contains(text(),'10')]")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();




    }
}
