package base;

import driver.CustomAppiumDriverManager;
import driver.CustomWebDriverManager;
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
        if (webDriver != null){
            // ignore initializing elements on fragment
        } else if (appiumDriver != null){
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else throw new WebDriverException("AppiumDriver is null. No @FindBy element are initialized on Fragments");
    }

    public boolean isRootElementDisplayed(){
        return $(rootElement).isDisplayed();
    }
}
