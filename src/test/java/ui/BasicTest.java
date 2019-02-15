package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.DriverService;

import java.io.IOException;

public class BasicTest {

    private static ChromeDriverService service;
    protected WebDriver driver;

    @BeforeTest
    public void createServiceAndDriver() throws IOException {
        service = DriverService.startService();
        driver = DriverService.startDriver();
    }

    @AfterTest
    public void stopDriverAndService() {
        driver.quit();
        service.stop();
    }

}
