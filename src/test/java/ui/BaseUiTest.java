package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterTest;
import selenium.WebDriverManager;

import java.io.IOException;

public class BaseUiTest {

    private static DriverService service;
    protected WebDriver webDriver;

    public BaseUiTest() throws IOException {
        service = WebDriverManager.startService();
        webDriver = WebDriverManager.startDriver();
        System.out.println("TEST RUN STARTED");
    }

    @AfterTest
    public void stopDriverAndService() {
        System.out.println("\nTEST RUN FINISHED");
        webDriver.quit();
        service.stop();
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

}
