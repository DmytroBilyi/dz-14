package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void clickMeVerification() {
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dmytro\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");
        driver.findElement(By.xpath("//span[text()='Buttons']")).click();
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        String clickText = driver.findElement(By.xpath("//*[@id=\"dynamicClickMessage\"]")).getText();
        Assert.assertEquals(clickText , "You have done a dynamic click", "Text is wrong");
        driver.close();
        driver.quit();
    }
}
