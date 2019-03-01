package ui.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment(webDriver, appiumDriver);

    @FindBy(css = "table>tbody")
    private WebElement table;

    public TablePage(WebDriver webDriver) {
        super(webDriver);
        url = getTablePageUrl();
    }

    public TablePage(AppiumDriver appiumDriver){
        super(appiumDriver);
        url = getTablePageUrl();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isTablePresent(){
        return table.isDisplayed();
    }

    private String getTablePageUrl(){
        return PropertiesHolder.getProperty("baseUrl")  + "/test/table.html";
    }
}
