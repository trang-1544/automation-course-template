package com;

import com.utils.BasicTest;
import com.utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bai17_ShoppingCartTest {

    @Test
    public void shoppingCartTest() throws Exception {
        // Thiết lập WebDriver cho Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10); 

            // Mở website
            String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
            driver.get(url);
            driver.manage().window().maximize();

            // Đăng nhập
            WebElement emailField = driver.findElement(By.id("username"));
            emailField.sendKeys("trang1234@gmail.com");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("tr123456789@@");

            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

            // Kiểm tra đăng nhập thành công
            WebElement successMessage = driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content > p"));
            String message = successMessage.getText();
            System.out.println(message);
            Assert.assertTrue(message.contains("Xin chào"));

            // Tìm kiếm sản phẩm "merc"
            WebElement searchInput = driver.findElement(By.id("s"));
            searchInput.sendKeys("merc");
            searchInput.sendKeys(Keys.ENTER);
            // Click vào  "Bơm nước xe"
            Utils.hardWait(3000);
            WebElement product1 = driver.findElement(By.xpath("//a[contains(@href,'bom-nuoc-xe-mercedes-slk200-slk300')]"));
            product1.click();

            // Thêm sản phẩm vào giỏ hàng 
            WebElement dropdown = driver.findElement(By.id("pa_xuat-xu"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("England");
            driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
            // verify thêm vào giỏ thành công
            WebElement Addcart = driver.findElement(By.cssSelector(".woocommerce-message"));
            String m_AddcartSucssess = Addcart.getText();
            Assert.assertTrue(m_AddcartSucssess.contains("đã được thêm vào giỏ hàng."));
            //driver.quit();
        }
    }

