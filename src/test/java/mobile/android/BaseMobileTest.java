package mobile.android;

import io.appium.java_client.AppiumDriver;

public class BaseMobileTest {

    protected AppiumDriver appiumDriver;

    protected String getCurrentUrl(){
        return appiumDriver.getCurrentUrl();
    }
}
