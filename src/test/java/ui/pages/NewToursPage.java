package ui.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment(webDriver, appiumDriver);

    @FindBy(css = "body>div>table")
    private WebElement mainFragment;

    public NewToursPage(WebDriver webDriver) {
        super(webDriver);
        url = getNewToursPageUrl();
    }

    public NewToursPage(AppiumDriver appiumDriver){
        super(appiumDriver);
        url = getNewToursPageUrl();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isMainFragmentPresent(){
        return mainFragment.isDisplayed();
    }

    private String getNewToursPageUrl(){
        return PropertiesHolder.getProperty("baseUrl")  + "/test/newtours/";
    }
}
