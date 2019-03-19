package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import driver.AppiumDriverManager;
import driver.WebDriverManager;

public abstract class BasePage {

    protected WebDriver webDriver = WebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = AppiumDriverManager.getAppiumDriver();
    protected String url;

    public BasePage(){
        if (webDriver != null){
            PageFactory.initElements(webDriver, this);
        } else if (appiumDriver != null){
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else throw new WebDriverException("All drivers are null");
    }

    public void navigate(){
        if (webDriver != null){
            webDriver.get(url);
        } else if (appiumDriver != null){
            appiumDriver.get(url);
        } else throw new WebDriverException("All drivers are null");
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public String getTitle(){
        if (webDriver != null){
            return webDriver.getTitle();
        } else if (appiumDriver != null){
            return appiumDriver.getTitle();
        } else throw new WebDriverException("All drivers are null");
    }

    public String getUrl(){
        return url;
    }

}
