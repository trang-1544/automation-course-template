package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.HomePage;
import com.utils.BasicTest;
import com.utils.Constants;
import com.pages.BasePage;


public class Bai22_ivivuTest extends BasicTest {
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage ;
    
    @Test
    public void testLoginSuccess() {
        driver.get(Constants.URL);  // driver đã có từ BasicTest

        loginPage = new LoginPage(driver);  // truyền driver đã sẵn
        homePage = new HomePage(driver);

        loginPage
            .clickAcount()
            .clickLoginButton()
            .enterEmail(Constants.EMAIL)
            .enterPass(Constants.PASSWORD)
            .clickSubmit();
        
        Assert.assertTrue(homePage.isElementVisible(homePage.avatarImage), "Avatar không hiển thị");

    }
}
