package com.carnumberplate.check.pages;

import com.carnumberplate.check.pageactions.Controller;
import com.carnumberplate.check.utilities.PropertyUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRegPage {
    WebDriver driver;
    Controller controller = new Controller(driver);

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[2]/div/div/span/div/div/dl/a")
    private WebElement getValuationButton;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")
    private WebElement registration;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")
    private WebElement make;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")
    private WebElement model;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd")
    private WebElement colour;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")
    private WebElement year;

    public CarRegPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getRegistration(){
        if(controller.exist(registration,driver)) {
            return registration.getText();
        }
        else{
            Assert.fail(getValuationButton.getText()+ " is not present");

        }
        return "Cannot find element";
    }

    public String getMake(){
        return make.getText();
    }

    public String getModel(){
        return model.getText();
    }

    public String getColour(){
        return colour.getText();
    }

    public String getYear(){
        return year.getText();
    }
}
