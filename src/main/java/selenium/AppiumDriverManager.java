package selenium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.PropertiesHolder;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverManager {

    public static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() {
        if (appiumDriver == null){
            initAppiumDriver();
        }
        return appiumDriver;
    }

    public static AppiumDriver initAppiumDriver() {
        if (WebDriverManager.webDriver == null) {
            URL serverAddress = null;
            try {
                serverAddress = new URL(PropertiesHolder.getProperty("appiumServerUrl"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_28");
            capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

            appiumDriver = new AndroidDriver(serverAddress, capabilities);
            return appiumDriver;
        }
        return null;
    }

    public static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(AppiumDriverManager.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
                return ste.getClassName();
            }
        }
        return null;
    }
}
