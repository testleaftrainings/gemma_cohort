package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SF_023CreateLeagalEntity extends  BaseClass{

    @Test
    public void tc_023CreateLegalEntity() throws InterruptedException {
        String legelName="Madhavan";
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("legal entities");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p/mark[text()='Legal Entities']")).click();
        Thread.sleep(5000);
        WebElement dropdownIcon=driver.findElement(By.xpath("(//a[@title='Recently Viewed | Legal Entities']//following-sibling::one-app-nav-bar-item-dropdown)[2]//one-app-nav-bar-menu-button/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdownIcon);
        WebElement newLegal=driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
        js.executeScript("arguments[0].click();", newLegal);
        driver.findElement(By.xpath("//label[contains(text(),'Legal Entity Name')]//following-sibling::div/input")).sendKeys("Salesforce Automation by "+legelName);
        driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
        if (actualText.toLowerCase().replaceAll("[^A-Za-z0]", " ").contains(legelName.toLowerCase())) {
            System.out.println("Pass");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Account is not created");
        }
    }
}
