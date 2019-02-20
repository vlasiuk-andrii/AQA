package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import properties.PropertiesHolder;
import selenium.annotations.Fragment;
import ui.fragments.MainMenuFragment;

public class NewToursPage extends BasicPage {

    @Fragment
    private MainMenuFragment mainMenuFragment = new MainMenuFragment(driver);

    @FindBy(css = "body>div>table")
    private WebElement mainFragment;

    public NewToursPage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/test/newtours/";
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public void navigate(){
        driver.get(url);
    }

    public boolean isMainFragmentPresent(){
        return mainFragment.isDisplayed();
    }
}
