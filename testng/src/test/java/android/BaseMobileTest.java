package android;

import io.appium.java_client.AppiumDriver;
import main.driver.CustomAppiumDriverManager;

public class BaseMobileTest {

    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();

    protected String getCurrentUrl(){
        return appiumDriver.getCurrentUrl();
    }
}
