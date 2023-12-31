package com.bit.pages.swaglabs;

import com.bit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By checkout = By.id("checkout");

    public void clickOnCheckout()
    {
        click(checkout);
    }
}
