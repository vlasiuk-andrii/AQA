package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
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
    }

    @AfterTest
    public void stopDriverAndService() {
        driver.quit();
        service.stop();
    }

}
