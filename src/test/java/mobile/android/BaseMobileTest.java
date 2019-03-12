package mobile.android;

import io.appium.java_client.AppiumDriver;
import selenium.AppiumDriverManager;

public class BaseMobileTest {

    protected AppiumDriver appiumDriver = AppiumDriverManager.getAppiumDriver();

    protected String getCurrentUrl(){
        return appiumDriver.getCurrentUrl();
    }
}
