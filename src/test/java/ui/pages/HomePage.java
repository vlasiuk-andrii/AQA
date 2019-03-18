package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "form[name='frmLogin']")
    private WebElement loginForm;

    public HomePage(){
        url = getHomePageUrl();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isLoginFormPresent(){
        return loginForm.isDisplayed();
    }

    private String getHomePageUrl(){
        return PropertiesHolder.getProperty("base.url")  + "/";
    }
}
