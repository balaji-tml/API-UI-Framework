package com.bit.pages.swaglabs;

import com.bit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
//    private final WebElement usernameTXT = driver.findElement(By.xpath("//*[@id='user-name']"));
//    private final WebElement passwordTXT = driver.findElement(By.xpath("//*[@id='password']"));
//    private final WebElement loginBTN = driver.findElement(By.xpath("//*[@id='login-button']"));
    private final WebElement usernameTXT = driver.findElement(By.xpath("//*[@id='user-name']"));
    private final WebElement passwordTXT = driver.findElement(By.xpath("//*[@id='password']"));
    private final WebElement loginBTN = driver.findElement(By.xpath("//*[@id='login-button']"));


    public void login(String user, String pwd) {
        enterValue(usernameTXT,user);
        enterValue(passwordTXT,pwd);
        click(loginBTN);
    }
}
