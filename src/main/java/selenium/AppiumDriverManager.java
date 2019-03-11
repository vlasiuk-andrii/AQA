package selenium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class AppiumDriverManager {

    public static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }
}
