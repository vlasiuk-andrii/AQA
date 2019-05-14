package ui.pages;

import base.BasePage;
import org.openqa.selenium.By;
import properties.PropertiesHolder;
import ui.enums.PagePaths;
import ui.enums.PageTitles;
import ui.fragments.MainMenuFragment;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    private By loginForm = By.cssSelector("form[name='frmLogin']");

    public HomePage(){
        url = getHomePageUrl();
        title = getHomePageTitle();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isLoginFormPresent(){
        return $(loginForm).isDisplayed();
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
