package selenium;

import com.sun.javafx.fxml.PropertyNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import properties.PropertiesHolder;

import java.io.File;
import java.io.IOException;

public class DriverManager {

    static ChromeDriverService chromeService;
    static GeckoDriverService firefoxService;
    static String browser;
    static private WebDriver driver;
    static private String driverPath = System.getProperty("user.dir") + PropertiesHolder.getProperty("driverPath");


    public static DriverService startService() throws IOException {
        browser = PropertiesHolder.getProperty("browser");
        if (browser.equals("CHROME")){
            driverPath+=PropertiesHolder.getProperty("chromeDriverPath");
            chromeService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverPath))
                    .usingAnyFreePort()
                    .build();
            chromeService.start();
            return chromeService;
        } else if (browser.equals("FIREFOX")){
            driverPath+=PropertiesHolder.getProperty("firefoxDriverPath");
            firefoxService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(driverPath))
                    .usingAnyFreePort()
                    .build();
            firefoxService.start();
            return firefoxService;
        } else throw new PropertyNotFoundException("No DriverService for such Browser found");
    }

    public static WebDriver startDriver(){
        if (browser.equals("CHROME")){
            return new RemoteWebDriver(chromeService.getUrl(), DesiredCapabilities.chrome());
        } else if (browser.equals("FIREFOX")){
            return new RemoteWebDriver(firefoxService.getUrl(), DesiredCapabilities.firefox());
        } else throw new WebDriverException("No such browser found");

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = startDriver();
        }
        return driver;
    }
}
