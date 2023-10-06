package com.bit.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
    }


}
