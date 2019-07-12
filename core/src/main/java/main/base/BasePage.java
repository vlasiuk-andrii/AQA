package main.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import main.driver.CustomAppiumDriverManager;
import main.driver.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.title;

public class BasePage {

    protected WebDriver webDriver = CustomWebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();

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

}
