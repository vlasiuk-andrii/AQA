package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment(driver);

    @FindBy(css = "table>tbody")
    private WebElement table;

    public TablePage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/test/table.html";
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isTablePresent(){
        return table.isDisplayed();
    }
}
