package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selenium.WebDriverManager;

public class BaseUiTest {

    private DriverService service = WebDriverManager.startService();
    protected WebDriver webDriver = WebDriverManager.startDriver();;

    @BeforeClass
    public void startUp() {
        System.out.println("WEBDRIVER CREATED");
    }

    @AfterClass
    public void stopDriverAndService() {
        webDriver.quit();
        service.stop();
        System.out.println("\nWEBDRIVER CLOSED");
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

}
