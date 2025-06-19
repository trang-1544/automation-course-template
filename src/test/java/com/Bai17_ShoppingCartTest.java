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

public class Bai17_ShoppingCartTest extends BasicTest {

    @Test
    public void shoppingCartTest() throws Exception {
            String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
            driver.get(url);
            driver.manage().window().maximize();
            Bai16_LoginTest login = new Bai16_LoginTest();
            login.loginTestSuccess();

            // Tìm kiếm sản phẩm "merc"
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
            // verify thêm vào giỏ thành công
            
            WebElement Addcart = driver.findElement(By.cssSelector(".woocommerce-message"));
            String m_AddcartSucssess = Addcart.getText();
            Assert.assertTrue(m_AddcartSucssess.contains("đã được thêm vào giỏ hàng."));
            //driver.quit();
        }
    }

