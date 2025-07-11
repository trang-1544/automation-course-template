package com;

import com.utils.BasicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages_hta.BasePage;
import com.pages_hta.CartPage;
import com.pages_hta.HomePage;
import com.pages_hta.LoginPage;
import com.utils.Constants;

public class ShopPommTest extends BasicTest{
    CartPage cartPage ;
    LoginPage loginPage ;
    BasePage basePage ; 
@Test
public void addToCartTest(){
    driver.get(Constants.URL_HTA);  // driver đã có từ BasicTest

        loginPage = new LoginPage(driver);  // truyền driver đã sẵn
        cartPage = new CartPage(driver);
        cartPage
          .search("mer")
          .clickProduct()
          .click_chonxuatxu()
          .clickPlus()
          .clickAddProduct()
          .verifyAddProduct();
        System.out.println("hi");
}
    
}
    
