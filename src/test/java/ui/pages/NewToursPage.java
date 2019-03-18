package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

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

    private String getNewToursPageUrl(){
        return PropertiesHolder.getProperty("base.url")  + "/test/newtours/";
    }
}
