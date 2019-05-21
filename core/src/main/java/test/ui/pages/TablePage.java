package test.ui.pages;

import main.base.BasePage;
import org.openqa.selenium.By;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.fragments.MainMenuFragment;

import static com.codeborne.selenide.Selenide.$;

public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    private By table = By.cssSelector("table>tbody");

    public TablePage(){
        url = getExpectedPageUrl(PagePaths.TABLE_PAGE.getValue());
        title = PageTitles.TABLE_PAGE.getValue();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isTablePresent(){
        return $(table).isDisplayed();
    }

}
