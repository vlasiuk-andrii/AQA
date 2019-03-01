package ui.fragments;

import fragments.BaseFragment;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgileProjectMenuFragment extends BaseFragment {

    @FindBy(css = "ul.menusubnav")
    private WebElement rootElement;

    By customerButton = By.cssSelector("a[href*='Customerhomepage']");
    By miniStatementButton = By.cssSelector("a[href*='MiniStatement']");

    public AgileProjectMenuFragment(WebDriver driver, AppiumDriver appiumDriver) {
        super(driver, appiumDriver);
        super.rootElement = rootElement;
    }

}
