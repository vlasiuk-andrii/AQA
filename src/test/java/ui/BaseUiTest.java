package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import driver.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseUiTest {

    private DriverService service = WebDriverManager.getDriverService();
    protected WebDriver webDriver = WebDriverManager.getWebDriver();

    @BeforeSuite
    public void startUp() {
        System.out.println("WEBDRIVER CREATED");
    }

    @AfterSuite
    public void stopDriverAndService() {
        webDriver.quit();
        service.stop();
        System.out.println("WEBDRIVER CLOSED");
    }

    public URL getCurrentUrl() {
        URL url = null;
        try {
            url = new URL( webDriver.getCurrentUrl() );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
