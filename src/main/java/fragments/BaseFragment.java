package fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseFragment {

    protected WebElement rootElement;
    WebDriver driver;

    public BaseFragment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
