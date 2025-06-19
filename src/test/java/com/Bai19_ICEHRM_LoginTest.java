package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai19_ICEHRM_LoginTest extends BasicTest {
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedErrorMessage) {
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        //username
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys(username);
        //password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(password);
        // click login
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(@onclick,'submitLogin()')]"));
        btnLogin.click();
        // Verify login success
        Assert.assertEquals(isErrorMessageDisplayed(), expectedErrorMessage,
                "Error message does not match expected value.");
    }


    public String isErrorMessageDisplayed() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }

    }

    @DataProvider(name = "loginData")
    public Object[][] testDataFeed() {
        return new Object[][] {
                { "admin", "admin", "" },
                { "admin", "admin123", "Login failed" },
        };
    }
}