package main.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import main.driver.CustomAppiumDriverManager;
import main.driver.CustomWebDriverManager;
import main.properties.PropertiesHolder;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class BasePage {

    protected WebDriver webDriver = CustomWebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();

    @Getter
    @Setter
    protected URL url;

    @Getter
    @Setter
    protected String title;

    public BasePage() {
        if (appiumDriver != null) {
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else if (webDriver == null) {
            throw new WebDriverException("All drivers are null");
        }
    }

    public String getTitleFromBrowser() {
        if (webDriver != null) {
            return title();
        } else if (appiumDriver != null) {
            return appiumDriver.getTitle();
        } else throw new WebDriverException("Can't get title of page. All drivers are null");
    }

    public String getDefaultTitle() {
        return title;
    }

    public URL getDefaultUrl() {
        return url;
    }

    protected URL getExpectedPageUrl(String expectedUrl) {
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url") + expectedUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
