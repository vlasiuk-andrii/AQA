package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.UiDriverManager;

import java.io.IOException;

public class BaseUiTest {

    private static DriverService service;
    protected WebDriver driver;

    @BeforeTest
    public void createServiceAndDriver() throws IOException {
        service = UiDriverManager.startService();
        driver = UiDriverManager.startDriver();
        System.out.println("TEST RUN STARTED");
    }

    @AfterTest
    public void stopDriverAndService() {
        System.out.println("\nTEST RUN FINISHED");
        driver.quit();
        service.stop();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
