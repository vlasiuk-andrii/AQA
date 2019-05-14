package driver;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesHolder;

public class CustomWebDriverManager {

    static String browser;
    static WebDriver webDriver;

    public static WebDriver initWebDriver() {
        if (CustomAppiumDriverManager.appiumDriver == null) {
            browser = PropertiesHolder.getProperty("browser");
            if (browser.equals("CHROME")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            } else if (browser.equals("FIREFOX")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            } else throw new WebDriverException("No such browser found");
            WebDriverRunner.setWebDriver(webDriver);
            return webDriver;
        }
        return null;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null)
            initWebDriver();
        return webDriver;
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

}
