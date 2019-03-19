package fragments;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import driver.AppiumDriverManager;
import driver.WebDriverManager;

public abstract class BaseFragment {

    protected WebElement rootElement;
    protected WebDriver webDriver = WebDriverManager.getWebDriver();
    protected AppiumDriver appiumDriver = AppiumDriverManager.getAppiumDriver();

    public BaseFragment() {
        if (webDriver != null){
            PageFactory.initElements(webDriver, this);
        } else if (appiumDriver != null){
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else throw new WebDriverException("All drivers are null. No @FindBy element are initialized on Fragments");
    }

    public boolean isRootElementDisplayed(){
        return rootElement.isDisplayed();
    }
}
