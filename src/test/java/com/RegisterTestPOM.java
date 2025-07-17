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
            .enterEmail(Constants.EMAIL_HTA)
            .enterPass(Constants.PASSWORD_HTA)
            .clickLoginButton();
    // Chờ phần tử xuất hiện
WebElement welcomeElement = driver.findElement(By.xpath("//p[contains(., 'Xin chào')]"));
// Kiểm tra nội dung chứa từ khoá mong muốn
Assert.assertTrue(welcomeElement.getText().contains("không phải tài khoản"), "❌ Đăng nhập KHÔNG thành công: Không thấy tên người dùng!");
    }
}
   

    