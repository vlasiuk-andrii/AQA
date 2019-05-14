package ui;

import driver.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseUiTest {

    protected WebDriver webDriver = CustomWebDriverManager.getWebDriver();

    @BeforeSuite
    public void startUp() {
        System.out.println("BEFORE UI SUITE");
    }

    @AfterSuite
    public void stopDriverAndService() {
        webDriver.quit();
        System.out.println("AFTER UI SUITE");
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
