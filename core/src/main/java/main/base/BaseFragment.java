package main.base;

import main.driver.CustomAppiumDriverManager;
import main.driver.CustomWebDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class BaseFragment {

    protected By rootElement;
    protected WebDriver webDriver = CustomWebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();

    public BaseFragment() {
        if (appiumDriver != null) {
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else if (webDriver == null) {
            throw new WebDriverException("All drivers are null");
        }
    }

    public boolean isRootElementDisplayed() {
        return $(rootElement).isDisplayed();
    }
}
