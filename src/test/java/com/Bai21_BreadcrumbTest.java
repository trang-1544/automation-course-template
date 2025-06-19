package com;

import com.utils.BasicTest;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bai21_BreadcrumbTest extends BasicTest {

    @Test
    public void breadcrumbTest() throws Exception {
            String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
            driver.get(url);
        // Create an instance of Actions class
        Actions actions = new Actions(driver);
        // hover to He thong truyen dong 
        WebElement hoverHeThongTruyenDong_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hệ thống truyền động')]")));
        actions.moveToElement(hoverHeThongTruyenDong_1).perform();
        // hover to he thong phanh 
        WebElement hoverHeThongPhanh_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hệ thống phanh')]")));
        actions.moveToElement(hoverHeThongPhanh_2).perform();
        // hover to phanh tay oto 
        WebElement PhanhTayOto_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Phanh tay ô tô')]")));
        PhanhTayOto_3.click();
        // Verify 
        WebElement breadcrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='woocommerce-breadcrumb']")));
        String breadcrumbText = breadcrumb.getText();

    
        Assert.assertTrue(breadcrumbText.contains("Phanh tay ô tô"));
        
      

        
    }

    }
