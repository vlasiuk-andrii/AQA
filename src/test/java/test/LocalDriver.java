package test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class LocalDriver {

    WebDriver driver;
    AppiumDriver appiumDriver;

    public LocalDriver(Object object) {
        if (object.getClass().getName().equals("Webdriver")){
            this.driver = (WebDriver) object;
        } else if (object.getClass().getName().equals("io.appium.java_client.android.AndroidDriver")){
            this.appiumDriver= (AppiumDriver) object;
        }
    }

    public LocalDriver() {
    }

    protected String getTitle(){
        if (driver != null){
            return driver.getTitle();
        } else if (appiumDriver != null){
            return appiumDriver.getTitle();
        } else throw new WebDriverException("All webdrivers are null");
    }

    protected LocalDriver getCorrectDriver(){
        if (driver != null){
            return driver;
        } else if (appiumDriver != null){
            return appiumDriver;
        } else throw new WebDriverException("All webdrivers are null");
    }
}
