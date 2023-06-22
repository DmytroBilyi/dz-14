package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test2 {
    @Test
    public void webTablesVerification() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Dmytro");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Bilyi");
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("dmytro@email.com");
        driver.findElement(By.xpath("//*[@id=\"age\"]")).sendKeys("53");
        driver.findElement(By.xpath("//*[@id=\"salary\"]")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"department\"]")).sendKeys("QA");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        String row = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]")).getText();
        Assert.assertEquals(row , "dmytro@email.com", "Text is wrong");
        driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Dmytro1");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        String row2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText();
        Assert.assertEquals(row2, "DmytroDmytro1", "Text is wrong");
        driver.close();
        driver.quit();
    }
}
