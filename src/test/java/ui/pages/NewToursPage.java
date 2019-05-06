package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import properties.PropertiesHolder;
import ui.enums.PageTitles;
import ui.enums.PagePaths;
import ui.fragments.MainMenuFragment;

import java.net.MalformedURLException;
import java.net.URL;

public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "body>div>table")
    private WebElement mainFragment;

    public NewToursPage(){
        url = getNewToursPageUrl();
        title = getNewToursPageTitle();
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
            url = new URL(PropertiesHolder.getProperty("base.url")  + PagePaths.NEW_TOURS_PAGE.getValue());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getNewToursPageTitle(){
        return PageTitles.NEW_TOURS_PAGE.getValue();
    }
}
