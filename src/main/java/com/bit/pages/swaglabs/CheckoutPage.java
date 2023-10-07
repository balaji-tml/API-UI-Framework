package com.bit.pages.swaglabs;

import com.bit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameTxt =By.id("first-name");
    private By lastNameTxt =By.id("last-name");
    private By postalCodeTxt =By.id("postal-code");

    private By continueBtn =By.id("continue");

    public void checkOut(String firstName,String lastName,String postalCode)
    {
          enterValue(firstNameTxt,firstName);
          enterValue(lastNameTxt,lastName);
          enterValue(postalCodeTxt,postalCode);
          click(continueBtn);

    }

}
