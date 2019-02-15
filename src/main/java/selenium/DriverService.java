package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import properties.PropertiesHolder;

import java.io.File;
import java.io.IOException;

public class DriverService {

    static ChromeDriverService service;
    static private String driverPath = System.getProperty("user.dir") + PropertiesHolder.getProperty("driverPath");


    public static ChromeDriverService startService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverPath))
                .usingAnyFreePort()
                .build();
        service.start();
        return service;
    }

    public static WebDriver startDriver(){
        return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
    }
}
