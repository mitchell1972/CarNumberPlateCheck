package com.carnumberplate.check.pageactions;

import com.carnumberplate.check.utilities.DriverUtil;
import com.carnumberplate.check.utilities.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Controller extends DriverUtil {
    PropertyUtil propertyUtil = new PropertyUtil();

    public Controller(WebDriver driver) {
        super(driver);
    }


    public boolean exist(WebElement element, WebDriver driver) {
        propertyUtil.loadConfigData();
        long timeOut = propertyUtil.getTimeOut();
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


}
