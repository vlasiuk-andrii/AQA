package ui;

import main.driver.CustomWebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BaseUiJunitTest {

    protected static WebDriver webDriver = CustomWebDriverManager.getWebDriver();

    @BeforeAll
    public static void startUp() {
        System.out.println("BEFORE UI SUITE");
    }

    @AfterAll
    public static void stopDriverAndService() {
        webDriver.quit();
        System.out.println("AFTER UI SUITE");
    }

    public URL getCurrentUrl() {
        URL url = null;
        try {
            url = new URL( url() );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
