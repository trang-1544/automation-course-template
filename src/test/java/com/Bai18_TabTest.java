package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bai18_TabTest extends BasicTest {
    @Test
    public void tabTest() throws Exception{
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        String ulr_1 ="https://bantheme.xyz/hathanhauto";
        //driver.get(url);
        Bai16_LoginTest login = new Bai16_LoginTest();
        login.loginTestSuccess();
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get(ulr_1);
        //  Đóng tab cũ
        driver.switchTo().window(tabs.get(0));
        driver.close();

        // Quay lại tab mới
        driver.switchTo().window(tabs.get(1));

         WebElement searchInput = driver.findElement(By.id("s"));
            searchInput.sendKeys("merc");
            searchInput.sendKeys(Keys.ENTER);
            // Click vào  "Bơm nước xe"
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'bom-nuoc-xe-mercedes-slk200-slk300')]"))).click();
            // Thêm sản phẩm vào giỏ hàng 
            WebElement dropdown = driver.findElement(By.id("pa_xuat-xu"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("England");
            driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
            //driver.findElement(By.cssSelector("a.pos-login")).click();
            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.pos-login")));
            loginLink.click();
            // verify van dang login 
            WebElement successMessage = driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content > p"));
            String message = successMessage.getText();
            System.out.println(message);
            Assert.assertTrue(message.contains("Xin chào"));
    }
    
}
