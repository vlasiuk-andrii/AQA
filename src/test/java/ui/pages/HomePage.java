package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

import java.net.MalformedURLException;
import java.net.URL;

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

    private URL getHomePageUrl(){
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url")  + "/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
