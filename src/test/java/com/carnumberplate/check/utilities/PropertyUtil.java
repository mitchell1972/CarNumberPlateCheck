package com.carnumberplate.check.utilities;

import org.hamcrest.core.IsInstanceOf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class PropertyUtil {

    private String propertyFilePath = "src/test/resources/properties/config.properties";
    private String url="";
    private long timeOut=0;
    private String browser="";


    public long getTimeOut(){
        return timeOut;
    }

    public String getUrl(){
        return url;
    }

    public String getBrowser(){
        return browser;
    }

    public void loadConfigData(){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        timeOut = Integer.parseInt(prop.getProperty("timeout"));
        url = prop.getProperty("url");
        browser = prop.getProperty("browser");
    }





}
