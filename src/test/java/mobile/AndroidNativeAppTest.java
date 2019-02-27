package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidNativeAppTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        URL serverAddress = new URL(PropertiesHolder.getProperty("appiumServer"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_28");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void smokeTest() {
        driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_2')]")).click();
        driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'op_add')]")).click();
        driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_3')]")).click();
        driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'eq')]")).click();

        Assert.assertEquals("5", driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id, 'result')]")).getText());
    }

    @AfterTest
    public void tearDown(){
        driver.closeApp();
        driver.quit();
    }

}
