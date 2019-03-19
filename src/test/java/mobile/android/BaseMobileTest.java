package mobile.android;

import io.appium.java_client.AppiumDriver;
import driver.AppiumDriverManager;

public class BaseMobileTest {

    protected AppiumDriver appiumDriver = AppiumDriverManager.getAppiumDriver();

    protected String getCurrentUrl(){
        return appiumDriver.getCurrentUrl();
    }
}
