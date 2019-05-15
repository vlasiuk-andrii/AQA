package ui.pages;

import base.BasePage;
import org.openqa.selenium.By;
import ui.enums.PagePaths;
import ui.enums.PageTitles;
import ui.fragments.MainMenuFragment;

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
