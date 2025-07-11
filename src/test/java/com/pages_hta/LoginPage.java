package com.pages_hta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utils.BasicTest;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        // Constructor for LoginPage
        super(givenDriver);
    }
    By emailLogin = By.id("username");
    By passLogin= By.id("password");
    By loginButton = By.xpath("//button[@name='login']");
    By successMessage = By.xpath("//p[contains(., 'Xin chào')]");
    By email_Register = By.id("reg_email");
    By pass_Register = By.id("reg_password");
    By registerButton = By.xpath("//button[@name='register']");
    By existedEmailMeg = By.xpath("//li[contains(. ,'An account is already registered')]");
    By forgotPasswordMeg = By.xpath("//a[contains(text(),'Bạn quên mật khẩu')]");
    By EmailNotExistMeg = By.xpath("//li[contains(text(),'Địa chỉ email không xác định')]");

    public LoginPage enterEmail(String email) {
        // findElement(emailField).sendKeys(email);
        enterText(emailLogin, email);
        return this;
    }

    public LoginPage enterPass(String pass) {
        // findElement(emailField).sendKeys(email);
        enterText(passLogin, pass);
        return this;
    }
    public LoginPage clickLoginButton() {
        // findElement(loginButton).click();
        clickElement(loginButton);
        return this;
    }
    public LoginPage enterMailRegister(String email){
        enterText(email_Register, email);
        return this;
    }
    public LoginPage enterPassRegister(String pass){
        enterText(pass_Register, pass);
        return this;
    }
    public LoginPage clickRegisterButton() {
        // findElement(loginButton).click();
        clickElement(registerButton);
        return this;
    }
    public LoginPage verifyLogin_RegisterSuccess(){
        verifyElementVisible(successMessage, "Xin chào");
        return this ;
    }
    public LoginPage verifyRegisterFail_existemail(){
        verifyElementVisible(existedEmailMeg, "An account is already registered");
        return this;
    }
    public LoginPage verifyForgotMeg(){
        verifyElementVisible(forgotPasswordMeg, "Bạn quên mật khẩu");
        return this;
    }
    public LoginPage verifyEmailNotExist(){
        verifyElementVisible(EmailNotExistMeg, "Kiểm tra lại hoặc thử tên người dùng của bạn");
        return this;
    }



}