package driver;

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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.PropertiesHolder;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class CustomWebDriverManager {

    static ChromeDriverService chromeService;
    static GeckoDriverService firefoxService;
    static String browser;
    static WebDriver webDriver;
    static private String driverPath = System.getProperty("user.dir") + PropertiesHolder.getProperty("driver.path");
    static private Logger LOGGER = LoggerFactory.getLogger(PropertiesHolder.class);

    public static DriverService startService() {
        browser = PropertiesHolder.getProperty("browser");
        if (browser.equals("CHROME")) {
            initChromeService();
            return chromeService;
        } else if (browser.equals("FIREFOX")) {
            initGeckoService();
            return firefoxService;
        } else throw new PropertyNotFoundException("No DriverService for such Browser found");
    }

    public static WebDriver initWebDriver() {
        if (CustomAppiumDriverManager.appiumDriver == null) {
            if (browser.equals("CHROME")) {
                webDriver = new RemoteWebDriver(chromeService.getUrl(), DesiredCapabilities.chrome());
            } else if (browser.equals("FIREFOX")) {
                webDriver = new RemoteWebDriver(firefoxService.getUrl(), DesiredCapabilities.firefox());
            } else throw new WebDriverException("No such browser found");
            setWebDriver(webDriver);
            return webDriver;
        }
        return null;
    }

    private static void initGeckoService() {
        firefoxService = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File(driverPath + PropertiesHolder.getProperty("firefox.driver.path")))
                .usingAnyFreePort()
                .build();
        try {
            firefoxService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initChromeService() {
        chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverPath + PropertiesHolder.getProperty("chrome.driver.path")))
                .usingAnyFreePort()
                .build();
        try {
            chromeService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null)
            initWebDriver();
        return webDriver;
    }

    public static DriverService getDriverService(){
        if (chromeService == null && firefoxService == null){
            return startService();
        } else if (chromeService != null) {
            return chromeService;
        } else if (firefoxService != null){
            return firefoxService;
        }
        return null;
    }

    public static Object evaluateJavascript(String script, Object... params) {
        return ((JavascriptExecutor) webDriver).executeScript(script, params);
    }

    public static void jsClickElement(WebElement el) {
        if (el.isDisplayed()) {
            evaluateJavascript("arguments[0].click()", el);
        } else {
            throw new RuntimeException("Can't click element. It's not present on the page");
        }
    }

    public static void scrollTo(WebElement el) {
        evaluateJavascript("arguments[0].scrollIntoView(true);", el);
    }

    public static void waitForPageToLoad(WebDriver webDriver) {
        waitForPageToLoad(webDriver, Integer.valueOf(PropertiesHolder.getProperty("explicit.dom.timeout")));
    }

    public static void waitForPageToLoad(WebDriver webDriver, int seconds) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, seconds);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public static void waitABit(long delayInMilliseconds) {
        try {
            Thread.sleep(delayInMilliseconds);
        } catch (InterruptedException e) {
            LOGGER.warn("Wait a bit method was interrupted.", e);
        }
    }

    public static String getDriverPath() {
        return driverPath;
    }
}
