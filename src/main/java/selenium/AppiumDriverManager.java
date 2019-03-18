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
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesHolder.getProperty("mobile.device.name"));
            capabilities.setCapability(MobileCapabilityType.UDID, PropertiesHolder.getProperty("mobile.device.udid"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesHolder.getProperty("mobile.platform.version"));

            try {
                serverAddress = new URL(PropertiesHolder.getProperty("appium.server.url"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            if (getCallerClassName().equals("mobile.android.browser.AndroidChromeTest")){
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
                appiumDriver = new AndroidDriver(serverAddress, capabilities);

            } else if (getCallerClassName().equals("mobile.android.app.AndroidNativeAppTest")){
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
                capabilities.setCapability("appPackage", "com.android.calculator2");
                capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                appiumDriver = new AndroidDriver(serverAddress, capabilities);
            }


            return appiumDriver;
        }
        return null;
    }

    public static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(AppiumDriverManager.class.getName()) &&
                    ste.getClassName().indexOf("java.lang.Thread")!=0 &&
                    ste.getClassName().indexOf("mobile.android.BaseMobileTest")!=0) {
                return ste.getClassName();
            }
        }
        return null;
    }
}
