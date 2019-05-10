package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import driver.AppiumDriverManager;
import driver.WebDriverManager;

import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public abstract class BasePage {

    protected WebDriver webDriver = WebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = AppiumDriverManager.getAppiumDriver();
    protected URL url;
    protected String title;

    public BasePage(){
        if (webDriver != null){
            PageFactory.initElements(getWebDriver(), this);
        } else if (appiumDriver != null){
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else throw new WebDriverException("All drivers are null");
    }

    public void navigate(){
        if (webDriver != null){
            open(url.toString());
        } else if (appiumDriver != null){
            appiumDriver.get(url.toString());
        } else throw new WebDriverException("All drivers are null");
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public String getTitleFromBrowser(){
        if (webDriver != null){
            return title();
        } else if (appiumDriver != null){
            return appiumDriver.getTitle();
        } else throw new WebDriverException("All drivers are null");
    }

    public String getDefaultTitle(){
        return title;
    }

    public URL getUrl(){
        return url;
    }

}
