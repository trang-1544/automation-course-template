package com.pages_hta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.utils.Utils;
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver givenDriver) { //constructor to initialize the WebDriver
        this.driver = givenDriver;
        this.wait = new WebDriverWait(driver, 15); // Initialize WebDriverWait with a timeout of 15 seconds
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    public void open(String url) {
        this.driver.get(url);
    }
    public String getTitle() {
        return this.driver.getTitle();
    }
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    public WebElement waitElementVisible(By by) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementPresence(By by) {
        return this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitElementClickable(By by) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean waitElementInvisible(By by) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public void clickElement(By by)  {
        // this.driver.findElement(by).click();
        waitElementClickable(by).click();
    }

    public void enterText(By by, String text) {
        WebElement element = waitElementVisible(by);
        element.clear(); // Clear the field before sending keys
        element.sendKeys(text);
    }

    public boolean isElementVisible(By locator) {
    try {
        return waitElementVisible(locator).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}
public boolean getTextAndCompare(By locator, String expectedText) {
    try {
        WebElement element = waitElementVisible(locator);
        String actualText = element.getText().trim();
        return actualText.contains(expectedText);
    } catch (Exception e) {
        System.out.println("❌ Không tìm thấy phần tử hoặc lỗi khi getText: " + e.getMessage());
        return false;
    }
}
public void hoverToMenu(String menuText) {

            //dynamic locator
            String dynamicLocator = "//*[contains(text(),'" + menuText + "')]";
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicLocator)));
            actions.moveToElement(element).perform();
            Utils.hardWait(3000); // Wait for 1 second to simulate hover action
    }
public void verifyElementVisible(By locator, String expectedText) {
    WebElement element = driver.findElement(locator);
    Assert.assertTrue(element.isDisplayed(), "Phần tử không hiển thị: " + locator.toString());

}
}


