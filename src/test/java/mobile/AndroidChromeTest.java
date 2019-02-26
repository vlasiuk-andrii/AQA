package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;
import selenium.DriverManager;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidChromeTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        URL serverAddress = new URL(PropertiesHolder.getProperty("appiumServer"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_API_28");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("noReset", true);

        System.setProperty("webdriver.chrome.driver", DriverManager.getDriverPath());
        driver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void smokeTest() {
        driver.get(PropertiesHolder.getProperty("baseUrl"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
