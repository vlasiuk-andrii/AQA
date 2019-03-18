package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "table>tbody")
    private WebElement table;

    public TablePage(){
        url = getTablePageUrl();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isTablePresent(){
        return table.isDisplayed();
    }

    private String getTablePageUrl(){
        return PropertiesHolder.getProperty("base.url")  + "/test/table.html";
    }
}
