package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public final By avatarImage = By.xpath("//img[contains(@src,'avatar-default-white.png')]");
    public HomePage(WebDriver givenDriver) {
        // Constructor for HomePage
        super(givenDriver);
    }

    public boolean isElementVisible(By element) {
        return super.isElementVisible(element); // gọi lại hàm gốc từ BasePage
    }

    
}

