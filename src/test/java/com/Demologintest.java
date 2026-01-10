package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demologintest {
    @Test
    public void loginTestSuccess() throws Exception {
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);

        // Enter Email
        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("testtest@gmail.com");
        Thread.sleep(1000); // Wait for 1 second

        // Enter Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("test1234");
        Thread.sleep(1000);

        // Click Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();
        Thread.sleep(3000);

        // Verify login failed (error message)
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@role='alert']"));
        String message = errorMessage.getText();
        Assert.assertTrue(message.contains("Lỗi"));

        driver.quit(); // Close browser
    }
}


