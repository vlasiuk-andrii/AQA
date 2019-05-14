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

public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    private By table = By.cssSelector("table>tbody");

    public TablePage(){
        url = getTablePageUrl();
        title = getTablePageTitle();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isTablePresent(){
        return $(table).isDisplayed();
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
