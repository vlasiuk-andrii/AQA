package mobile.android;

import io.appium.java_client.AppiumDriver;
import driver.CustomAppiumDriverManager;

public class BaseMobileTest {

    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();

    protected String getCurrentUrl(){
        return appiumDriver.getCurrentUrl();
    }
}
