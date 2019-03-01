package ui.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment(driver);

    @FindBy(css = "form[name='frmLogin']")
    private WebElement loginForm;

    public HomePage(WebDriver driver) {
        super(driver);
        url = getHomePageUrl();
    }

    public HomePage(AppiumDriver appiumDriver){
        super(appiumDriver);
        url = getHomePageUrl();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isLoginFormPresent(){
        return loginForm.isDisplayed();
    }

    private String getHomePageUrl(){
        return PropertiesHolder.getProperty("baseUrl")  + "/";
    }
}
