package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import properties.PropertiesHolder;

import java.io.File;
import java.io.IOException;

public class BasicTest {

    private static ChromeDriverService service;
    protected WebDriver driver;
    private String driverPath = System.getProperty("user.dir") + PropertiesHolder.getProperty("driverPath");

    @BeforeTest
    public void createServiceAndDriver() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverPath))
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
    }

    @AfterTest
    public void stopDriverAndService() {
        driver.quit();
        service.stop();
    }

}
