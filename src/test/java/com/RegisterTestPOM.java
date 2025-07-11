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


public class RegisterTestPOM extends BasicTest{
    LoginPage loginPage ;
    HomePage homePage ;
    
    @Test
    public void testRegisterSuccess() {
        driver.get(Constants.URL_HTA_TK);  // driver đã có từ BasicTest

        loginPage = new LoginPage(driver);  // truyền driver đã sẵn
        homePage = new HomePage(driver);

        loginPage
            .enterMailRegister(Constants.EMAIL_HTA_1)
            .enterPassRegister(Constants.PASSWORD_HTA)
            .clickRegisterButton();
    // Chờ phần tử xuất hiện
    try {
    loginPage.verifyLogin_RegisterSuccess();
    System.out.println("RegisterSuccess");
} catch (Exception e) {
    try {
        loginPage.verifyRegisterFail_existemail();
        System.out.println("⚠️ Email existed");
    } catch (Exception ex) {
        System.out.println("❌ Lỗi không xác định khi đăng ký");
    }
}

    }
}
   

    