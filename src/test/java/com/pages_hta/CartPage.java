package com.pages_hta;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import com.utils.Utils;

public class CartPage extends BasePage {

    public CartPage(WebDriver givenDriver) { //constructor to initialize the WebDriver
        super(givenDriver);
    }
    
   By searchInput = By.xpath("//form[contains(@class,'form-search-head')]//input[@type='text']"); 
   By produc_1  = By.xpath("//*[contains(text(),'Bơm nước xe Mercedes SLK200')]");
   By xuat_xu   = By.xpath("//option[@value='england']");
   By plusBtton = By.xpath("//button[@class='plus']");
   By addTocart = By.xpath("//*[contains(text(),'Thêm vào giỏ hàng')]");
   By successAddMeg = By.xpath("//*[contains(text(),'Tiếp tục xem sản phẩm')]");
//     public CartPage enterTextSearch(String text) {
//         // findElement(emailField).sendKeys(email);
//         enterText(searchInput, text);
//         return this;
//     }
//     public CartPage sendEnterKey() {
//     WebElement input = waitElementVisible(searchInput);
//     input.sendKeys(Keys.ENTER);
//     return this;
// }
    public CartPage search(String keyword) {
    // Gọi lại hàm có sẵn từ BasePage
    enterText(searchInput, keyword + Keys.ENTER);  
    return this;
}
    public CartPage clickProduct(){
        clickElement(produc_1);
        return this;
}
    public CartPage click_chonxuatxu(){
        clickElement(xuat_xu);
        return this;
    }

    public CartPage clickPlus(){
        clickElement(plusBtton);
        return this;
    }
    public CartPage clickAddProduct(){
        clickElement(addTocart);
        return this;
    }
    public CartPage verifyAddProduct(){
        verifyElementVisible(successAddMeg, "Tiếp tục xem sản phẩm");
        return this;
    }

}