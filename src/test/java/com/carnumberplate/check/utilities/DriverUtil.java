package com.carnumberplate.check.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverUtil {
    static WebDriver driver;
    static PropertyUtil propertyUtil = new PropertyUtil();

    public DriverUtil(WebDriver driver) {

    }

    public DriverUtil() {

    }


    public static WebDriver getDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = chromeDriver();
                break;
            case "firefox":
                driver = firefoxDriver();
                break;
            default:
                System.out.println("Not a recognised browser type");
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @BeforeAll
    static void setup() throws IOException {
        ReadFile.inputFileReader();
        propertyUtil.loadConfigData();
        getDriver(propertyUtil.getBrowser()).manage().window().maximize();

    }

    @AfterAll
    public static void closeBrowser() {
        getDriver().quit();
    }

}

