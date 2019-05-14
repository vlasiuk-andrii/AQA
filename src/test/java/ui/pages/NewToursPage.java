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

public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    private By mainFragment = By.cssSelector("body>div>table");

    public NewToursPage(){
        url = getNewToursPageUrl();
        title = getNewToursPageTitle();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isMainFragmentPresent(){
        return $(mainFragment).isDisplayed();
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
