package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import driver.CustomAppiumDriverManager;
import driver.CustomWebDriverManager;

import java.net.URL;

public abstract class BasePage {

    protected WebDriver webDriver = CustomWebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();
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
            webDriver.get(url.toString());
        } else if (appiumDriver != null){
            appiumDriver.get(url.toString());
        } else throw new WebDriverException("All drivers are null");
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public String getTitleFromBrowser(){
        if (webDriver != null){
            return webDriver.getTitle();
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
