package ui.pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import properties.PropertiesHolder;
import ui.enums.PagePaths;
import ui.enums.PageTitles;
import ui.fragments.MainMenuFragment;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "form[name='frmLogin']")
    private WebElement loginForm;

    public HomePage(){
        url = getHomePageUrl();
        title = getHomePageTitle();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isLoginFormPresent(){
        return loginForm.isDisplayed();
    }

    private URL getHomePageUrl(){
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url")  + PagePaths.HOME_PAGE.getValue());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getHomePageTitle(){
        return PageTitles.HOME_PAGE.getValue();
    }
}
