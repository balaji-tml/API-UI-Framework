package com.bit.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    protected static Logger log;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
        this.log = LogManager.getLogger(BasePage.class);
    }

    //Click on an element
    public void click(WebElement elm) {
        elm.click();
        log.info("Clicked on WebElement");
    }

    public void click(By elm) {
        driver.findElement(elm).click();
        log.info("Clicked on WebElement");
    }

    //Enter value in a Text Box
    public void enterValue(WebElement elm, String value) {
        elm.sendKeys(value);
        log.info("Entered value in WebElement");
    }

    public void enterValue(By elm, String value) {
        driver.findElement(elm).sendKeys(value);
        log.info("Entered value in WebElement");
    }

    //Get Text from an element
    public String getTest(WebElement elm) {
        log.info("Get text from WebElement");
        return elm.getText();

    }

    public String getTest(By elm) {
        log.info("Get text from WebElement");
        return driver.findElement(elm).getText();
    }

    //Clear Text from Text Box
    public void clearTest(WebElement elm) {
        elm.clear();
        log.info("Clear text from WebElement");
    }

    public void clearText(By elm) {
        driver.findElement(elm).clear();
        log.info("Clear text from WebElement");
    }

    //Check if element is displayed
    public boolean isDisplayed(WebElement elm)
    {
        log.info("Check whether the WebElement isDisplayed");
        return elm.isDisplayed();
    }
    public boolean isDisplayed(By elm)
    {
        log.info("Check whether the WebElement isDisplayed");
        return driver.findElement(elm).isDisplayed();
    }
    //Check if element is Enabled
    public boolean isEnabled(WebElement elm)
    {
        log.info("Check whether the WebElement isEnabled");
        return elm.isEnabled();
    }
    public boolean isEnabled(By elm)
    {
        log.info("Check whether the WebElement isEnabled");
        return driver.findElement(elm).isEnabled();
    }
    //Check if element is Selected
    public boolean isSelected(WebElement elm)
    {
        log.info("Check whether the WebElement isSelected");
        return elm.isSelected();
    }
    public boolean isSelected(By elm)
    {
        log.info("Check whether the WebElement isSelected");
        return driver.findElement(elm).isSelected();
    }
    //Select a value from drop-down using value
    public void selectByValue(WebElement elm,String value)
    {
        Select dd = new Select(elm);
        dd.selectByValue(value);
        log.info("Select a value from WebElement");
    }
    public void selectByValue(By elm,String value)
    {
        Select dd = new Select(driver.findElement(elm));
        dd.selectByValue(value);
        log.info("Select a value from WebElement");
    }


}
