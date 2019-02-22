package selenium;

import com.sun.javafx.fxml.PropertyNotFoundException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.PropertiesHolder;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class DriverManager {

    static ChromeDriverService chromeService;
    static GeckoDriverService firefoxService;
    static String browser;
    static private WebDriver driver;
    static private String driverPath = System.getProperty("user.dir") + PropertiesHolder.getProperty("driverPath");
    static private Logger LOGGER = LoggerFactory.getLogger(PropertiesHolder.class);

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
        if (chromeService == null && firefoxService == null) {
            try {
                startService();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (driver == null){
                driver = startDriver();
            }
        }
        return driver;
    }

    public static Object evaluateJavascript(String script, Object... params) {
        return ((JavascriptExecutor) driver).executeScript(script, params);
    }

    public static void jsClickElement(WebElement el) {
        if (el.isDisplayed()) {
            evaluateJavascript("arguments[0].click()", el);
        } else {
            throw new RuntimeException("Can't click element. It's not present on the page");
        }
    }

    public static void scrollTo(WebElement el){
        evaluateJavascript("arguments[0].scrollIntoView(true);", el);
    }

    public static void waitForPageToLoad() {
        waitForPageToLoad(Integer.valueOf(PropertiesHolder.getProperty("explicit.dom.timeout")));
    }

    public static void waitForPageToLoad(int seconds) {
        try {
            sleep(500);
            for (int i = 0; i < seconds * 2; i++) {
                if (!evaluateJavascript("return document.readyState").equals("complete")) {
                    sleep(500);
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitABit(long delayInMilliseconds) {
        try {
            Thread.sleep(delayInMilliseconds);
        } catch (InterruptedException e) {
            LOGGER.warn("Wait a bit method was interrupted.", e);
        }
    }
}
