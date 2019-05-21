package main.driver;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import main.properties.PropertiesHolder;

public class CustomWebDriverManager {

    static String browser;
    static WebDriver webDriver;

    public static WebDriver initWebDriver() {
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

    public static WebDriver getWebDriver() {
        if (webDriver == null)
            initWebDriver();
        return webDriver;
    }
}
