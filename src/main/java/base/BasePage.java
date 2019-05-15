package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import driver.CustomAppiumDriverManager;
import driver.CustomWebDriverManager;
import properties.PropertiesHolder;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public abstract class BasePage {

    protected WebDriver webDriver = CustomWebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = CustomAppiumDriverManager.getAppiumDriver();
    protected URL url;
    protected String title;

    public BasePage(){
        if (webDriver != null){
            //PageFactory.initElements(getWebDriver(), this);
        } else if (appiumDriver != null){
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else throw new WebDriverException("Can't init elements on Page. All drivers are null");
    }

    public void navigate(){
        if (webDriver != null){
            open(url);
        } else if (appiumDriver != null){
            appiumDriver.get(url.toString());
        } else throw new WebDriverException("Can't navigate URL. All drivers are null");
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public String getTitleFromBrowser(){
        if (webDriver != null){
            return title();
        } else if (appiumDriver != null){
            return appiumDriver.getTitle();
        } else throw new WebDriverException("Can't get title of page. All drivers are null");
    }

    public String getDefaultTitle(){
        return title;
    }

    public URL getDefaultUrl(){
        return url;
    }

    protected URL getExpectedPageUrl(String expectedUrl) {
        URL url = null;
        try {
            url = new URL( PropertiesHolder.getProperty("base.url") + expectedUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
