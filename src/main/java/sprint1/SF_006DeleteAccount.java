package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class SF_006DeleteAccount extends BaseClass {
    String myAccountName = "Madhavan";
    @Test
    public void createAccount() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Sales']")));
        WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));

        js.executeScript("arguments[0].click();", eleAccounts);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@title='New']")).click();
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys(myAccountName);
        WebElement element = driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        System.out.println(text);
    }
    @Test(dependsOnMethods = {"createAccount"})
    public void deleteAccount_S6_3() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", eleAccounts);
        driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(myAccountName);
        driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.TAB);
        Thread.sleep(4000);
        WebElement deleteDropDownele = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']//tr/td[6]//a"));
        js.executeScript("arguments[0].click();", deleteDropDownele);
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
        if (actualText.toLowerCase().replaceAll("[^A-Za-z0]", " ").contains(myAccountName.toLowerCase())) {
            System.out.println("Pass");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Expected account not deleted");
        }
    }
}
