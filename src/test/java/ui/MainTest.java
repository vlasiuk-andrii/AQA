package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;

import java.io.File;
import java.io.IOException;

public class MainTest {

    private static ChromeDriverService service;
    private WebDriver driver;
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

    @Test
    public void firstTest() {
        String baseUrl = PropertiesHolder.getProperty("baseUrl");
        String expectedTitle = "Welcome: Mercury Tours";

        driver.get(baseUrl);

        Assert.assertEquals(expectedTitle, driver.getTitle());
    }
}
