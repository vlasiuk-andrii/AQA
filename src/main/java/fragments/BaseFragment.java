package fragments;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseFragment {

    protected WebElement rootElement;
    protected WebDriver driver;
    protected AppiumDriver appiumDriver;

    public BaseFragment(WebDriver driver, AppiumDriver appiumDriver) {
        this.driver = driver;
        this.appiumDriver = appiumDriver;
        if (driver != null){
            PageFactory.initElements(driver, this);
        } else if (appiumDriver != null){
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        } else throw new WebDriverException("All drivers are null. No @FindBy element are initialized on Fragments");
    }

    public boolean isRootElementDisplayed(){
        return rootElement.isDisplayed();
    }
}
