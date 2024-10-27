package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class SF_052CreateNewTask extends  BaseClass {

    @Test
    public void tc_052CreateNewTask() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[2]")).sendKeys("Content");
        driver.findElement(By.xpath("//p/mark[contains(text(),'Content')]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'View All')])[2]")).click();
        driver.findElement(By.xpath("//a[@title='Show 2 more actions']")).click();
        driver.findElement(By.xpath("//a[@title='New Task']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Press Delete to Remove')]//parent::a")).click();
        driver.findElement(By.xpath("//input[@title='Search People']")).sendKeys("jeyagokul sekar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@title='Search People']/parent::div//div//li")).click();
        driver.findElement(By.xpath("(//label[contains(text(),'Subject')]//following-sibling::div)[1]//input")).sendKeys("Email");
        driver.findElement(By.xpath("(//span[contains(text(),'Priority')])[3]/parent::span//following-sibling::div//a")).click();
        driver.findElement(By.xpath("//a[contains(text(),'High')]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Status')])[3]/parent::span//following-sibling::div//a")).click();
        driver.findElement(By.xpath(" //a[contains(text(),'In Progress')]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Name')])[3]/parent::label//following-sibling::div//a//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@title='Contacts']")).click();
        driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("praveena");
        driver.findElement(By.xpath("//input[@title='Search Contacts']/parent::div//div//li")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Related To')])[3]/parent::label//following-sibling::div//a//img")).click();
        driver.findElement(By.xpath("//span[@title='Products']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("JeyaGokul");
        driver.findElement(By.xpath("//input[@title='Search Products']/parent::div//div//li")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Save']")).click();
    }
}
