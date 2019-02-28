package mobile.android.app;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import mobile.android.BaseMobileTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class AndroidNativeAppTest extends BaseMobileTest {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_2')]")
    public MobileElement digit2;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_3')]")
    public MobileElement digit3;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_add')]")
    public MobileElement plusButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'eq')]")
    public MobileElement equalButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'result')]")
    public MobileElement resultField;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        URL serverAddress = new URL(PropertiesHolder.getProperty("appiumServerUrl"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_28");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(serverAddress, capabilities);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Test
    public void simpleSummTest() {
        digit2.click();
        plusButton.click();
        digit3.click();
        equalButton.click();

        assertEquals("5", resultField.getText());
    }

    @AfterTest
    public void tearDown(){
        driver.closeApp();
        driver.quit();
    }

}
