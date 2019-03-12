package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverManager;

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
        System.out.println("\nWEBDRIVER CLOSED");
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

}
