package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bai16_LoginTest {
    @Test
    public void loginTestSuccess() throws Exception {
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("trang1234@gmail.com");
        Thread.sleep(1000); // Wait for 1 second

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("tr123456789@@");
        Thread.sleep(1000);

        // Click Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();
        Thread.sleep(3000);

        // Verify 
        WebElement successMessage = driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content > p"));
        String message = successMessage.getText();
        System.out.println(message);

        Assert.assertTrue(message.contains("Xin chào"));

        //driver.quit(); // Close browser
    }

    
}
