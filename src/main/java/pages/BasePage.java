package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected AppiumDriver appiumDriver;
    protected String url;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BasePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
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
