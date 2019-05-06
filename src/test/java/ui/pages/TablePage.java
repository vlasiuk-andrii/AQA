package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import properties.PropertiesHolder;
import ui.enums.PagePaths;
import ui.enums.PageTitles;
import ui.fragments.MainMenuFragment;

import java.net.MalformedURLException;
import java.net.URL;

public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "table>tbody")
    private WebElement table;

    public TablePage(){
        url = getTablePageUrl();
        title = getTablePageTitle();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isTablePresent(){
        return table.isDisplayed();
    }

    private URL getTablePageUrl(){
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url")  + PagePaths.TABLE_PAGE.getValue());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getTablePageTitle(){
        return PageTitles.TABLE_PAGE.getValue();
    }
}
