package com.bit.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bit.utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTestUI {
    protected static WebDriver driver;
    protected ChromeOptions chromeOptions;
    protected FirefoxOptions firefoxOptions;
    protected URL remoteURL;

    //From Datadrivenframework
//    protected Properties config = new Properties();
    protected Properties config;
//    protected Properties OR = new Properties();
    protected Properties OR;
    FileInputStream fis = null;
    protected static Logger log;
//    public ExcelReader excel;

    protected String userDir = System.getProperty("user.dir");
    public String path = userDir + "/src/test/resources/excel/Testdata.xlsx";
    public ExcelReader excel = new ExcelReader(path);
    public ExtentReports extent = null;

    public ExtentTest test = null;

    protected static String browser, appUrl;

    public WebDriverWait wait = null;

    @BeforeSuite
    public void setUp() {
        try {
            if (driver == null) {
                log = LogManager.getLogger(BaseTestUI.class);
                log.info("In start of the setUp()");
                userDir = System.getProperty("user.dir");
                log.info("UserDir: " + userDir);
//                path = userDir + "/src/test/resources/excel/Testdata.xlsx";
//                log.info("path: " + path);
//                excel = new ExcelReader(path);
                config = new Properties();
                fis = new FileInputStream(userDir + "/src/test/resources/properties/Config.properties");
                config.load(fis);
                log.info("Config file is loaded!");
                OR = new Properties();
                fis = new FileInputStream(userDir + "/src/test/resources/properties/OR.properties");
                OR.load(fis);
                log.info("OR file is loaded!");
                browser = config.getProperty("browser");
                log.info("browser: " + browser);
                if (browser.equalsIgnoreCase("CHROME")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                } else if (browser.equalsIgnoreCase("FIREFOX")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                } else if (browser.equalsIgnoreCase("EDGE")) {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                } else {
                    System.out.println("Please select valid browser!\n");
                }
                wait = new WebDriverWait(driver, Duration.ofMinutes(5));
                log.info("'" + browser + "' browser is loaded!");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
            log.info("In end of the setUp()");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @AfterSuite
    public void tearDown() {
        log.info("In start of the tearDown()");
        if (driver != null) {
            driver.quit();
            log.info("'" + browser + "' browser is closed!");
        }
        log.info("In end of the tearDown()");
    }

    public WebDriver getDriver() {
        return driver;
    }


}
