package test.ui.pages;

import main.base.BasePage;
import org.openqa.selenium.By;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.fragments.MainMenuFragment;

import static com.codeborne.selenide.Selenide.$;

public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    private By mainFragment = By.cssSelector("body>div>table");

    public NewToursPage(){
        url = getExpectedPageUrl(PagePaths.NEW_TOURS_PAGE.getValue());
        title = PageTitles.NEW_TOURS_PAGE.getValue();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isMainFragmentPresent(){
        return $(mainFragment).isDisplayed();
    }
}