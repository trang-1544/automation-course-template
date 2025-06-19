package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        // Constructor for LoginPage
        super(givenDriver);
    }
    By Account = By.xpath("//*[contains(text(),'Tài khoản')]");
    By loginButton = By.xpath("//*[contains(text(),'Đăng nhập ngay')]");
    By emailPhone = By.xpath("//input[@name='emailOrPhone']");
    By Password = By.xpath("//input[@type='password']");
    By SubmitButton = By.xpath("//button[@type='submit']");
    


    public LoginPage clickAcount() {
        clickElement(Account);
        return this;
    }

    public LoginPage enterEmail(String email) {
        // findElement(emailField).sendKeys(email);
        enterText(emailPhone, email);
        return this;
    }
    public LoginPage enterPass(String pass) {
        // findElement(emailField).sendKeys(email);
        enterText(Password, pass);
        return this;
    }
    public LoginPage clickLoginButton() {
        // findElement(loginButton).click();
        clickElement(loginButton);
        return this;
    }
     public LoginPage clickSubmit() {
        // findElement(loginButton).click();
        clickElement(SubmitButton);
        return this;
    }

}
    

