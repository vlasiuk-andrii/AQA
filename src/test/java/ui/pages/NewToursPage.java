package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

import java.net.MalformedURLException;
import java.net.URL;

public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "body>div>table")
    private WebElement mainFragment;

    public NewToursPage(){
        url = getNewToursPageUrl();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isMainFragmentPresent(){
        return mainFragment.isDisplayed();
    }

    private URL getNewToursPageUrl(){
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url")  + "/test/newtours/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
