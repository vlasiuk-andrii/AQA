package mobile.android.browser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mobile.android.BaseMobileTest;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import properties.PropertiesHolder;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidChromeTest extends BaseMobileTest {

    public AndroidChromeTest() throws MalformedURLException {
        URL serverAddress = new URL(PropertiesHolder.getProperty("appiumServerUrl"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_28");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @AfterTest
    public void tearDown(){
        appiumDriver.close();
        appiumDriver.quit();
    }

}
