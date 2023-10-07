package com.bit.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
    }

    //Click on an element
    public void click(WebElement elm) {
        elm.click();

    }

    public void click(By elm) {
        driver.findElement(elm).click();
    }

    //Enter value in a Text Box
    public void enterValue(WebElement elm, String value) {
        elm.sendKeys(value);
    }

    public void enterValue(By elm, String value) {
        driver.findElement(elm).sendKeys(value);
    }

    //Get Text from an element
    public String getTest(WebElement elm) {
        return elm.getText();
    }

    public String getTest(By elm) {
        return driver.findElement(elm).getText();
    }

    //Clear Text from Text Box
    public void clearTest(WebElement elm) {
        elm.clear();
    }

    public void clearText(By elm) {
        driver.findElement(elm).clear();
    }

    //Check if element is displayed
    public boolean isDisplayed(WebElement elm)
    {
        return elm.isDisplayed();
    }
    public boolean isDisplayed(By elm)
    {
        return driver.findElement(elm).isDisplayed();
    }
    //Check if element is Enabled
    public boolean isEnabled(WebElement elm)
    {
        return elm.isEnabled();
    }
    public boolean isEnabled(By elm)
    {
        return driver.findElement(elm).isEnabled();
    }
    //Check if element is Selected
    public boolean isSelected(WebElement elm)
    {
        return elm.isSelected();
    }
    public boolean isSelected(By elm)
    {
        return driver.findElement(elm).isSelected();
    }
    //Select a value from drop-down using value
    public void selectByValue(WebElement elm,String value)
    {
        Select dd = new Select(elm);
        dd.selectByValue(value);
    }
    public void selectByValue(By elm,String value)
    {
        Select dd = new Select(driver.findElement(elm));
        dd.selectByValue(value);
    }


}
