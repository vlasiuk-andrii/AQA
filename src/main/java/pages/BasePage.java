package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected AppiumDriver appiumDriver;
    protected String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void navigate(){
        if (driver != null){
            driver.get(url);
        } else if (appiumDriver != null){
            appiumDriver.get(url);
        } else throw new WebDriverException("All drivers are null");
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUrl(){
        return url;
    }

}
