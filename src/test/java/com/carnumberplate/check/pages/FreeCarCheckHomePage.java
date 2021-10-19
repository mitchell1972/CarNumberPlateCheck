package com.carnumberplate.check.pages;

import com.carnumberplate.check.pageactions.Controller;
import com.carnumberplate.check.utilities.DriverUtil;
import com.carnumberplate.check.utilities.PropertyUtil;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FreeCarCheckHomePage extends DriverUtil {
    WebDriver driver;

    PropertyUtil propertyUtil = new PropertyUtil();
    Controller controller = new Controller(driver);

    @FindBy(id = "vrm-input")
    private WebElement enterRegistrationField;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div/div/div/div/form/button")
    private WebElement freeCarCheckButton;


    public FreeCarCheckHomePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterVehicleRegistration(String registrationNumber) {
        try {
            if(controller.exist(enterRegistrationField,driver)) {
                enterRegistrationField.sendKeys(registrationNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickFreeCheckButton() {
        if(controller.exist(freeCarCheckButton,driver)) {
            freeCarCheckButton.click();
        }

        else{

            Assert.fail(freeCarCheckButton.getText()+ " is not present");
        }
    }

    public void navigateToHomePage() {
        propertyUtil.loadConfigData();
        driver.get(propertyUtil.getUrl());

    }


}
