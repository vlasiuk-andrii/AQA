package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;
import ui.enums.Titles;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class AndroidChromeTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        URL serverAddress = new URL(PropertiesHolder.getProperty("appiumServerUrl"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_28");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

        driver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void smokeTest() {
        driver.get(PropertiesHolder.getProperty("baseUrl"));
        assertEquals(Titles.HOME_PAGE.getValue(), driver.getTitle());
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
