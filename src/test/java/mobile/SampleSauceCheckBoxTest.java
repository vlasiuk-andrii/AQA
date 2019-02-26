package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SampleSauceCheckBoxTest {

    public static void main(String[] args) throws Exception {

        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Pixel_API_28");
        capabilities.setCapability("udid", "emulator-5556");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("noReset", true);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Andrii_Vlasiuk\\Documents\\Andrii Vlasiuk\\AQA\\src\\test\\resources\\webdriver\\mobile\\chromedriver.exe");

        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(serverAddress, capabilities);

        driver.get("http://www.google.com");
        Thread.sleep(3000);

        driver.quit();
    }
}
