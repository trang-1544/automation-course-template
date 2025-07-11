package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages_hta.BasePage;
import com.pages_hta.HomePage;
import com.pages_hta.LoginPage;
import com.utils.BasicTest;
import com.utils.Constants;

public class LoginTestPOM extends BasicTest {
    LoginPage loginPage ;
    HomePage homePage ;
    
    @Test
    public void testLoginSuccess() {
        driver.get(Constants.URL_HTA_TK);  // driver đã có từ BasicTest

        loginPage = new LoginPage(driver);  // truyền driver đã sẵn
        homePage = new HomePage(driver);

        loginPage
            .enterEmail(Constants.EMAIL_HTA)
            .enterPass(Constants.PASSWORD_HTA)
            .clickLoginButton();
    // Chờ phần tử xuất hiện
try {
    loginPage.verifyLogin_RegisterSuccess();
    System.out.println("LoginSuccess");
} catch (Exception e) {
    try {
        loginPage.verifyForgotMeg();
        System.out.println("⚠️ Fogot Password");
    } catch (Exception ex) {
        try {
            loginPage.verifyEmailNotExist();  // TH3: Email chưa từng đăng ký
            System.out.println("❌ Email chưa được đăng ký");
        } catch (Exception ex2) {
            System.out.println("❌ Không rõ nguyên nhân");
       }
            }
        }
    }
}



