package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.DriverManager;

import java.io.IOException;

public class BasicTest {

    private static DriverService service;
    protected WebDriver driver;

    @BeforeTest
    public void createServiceAndDriver() throws IOException {
        service = DriverManager.startService();
        driver = DriverManager.startDriver();
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
