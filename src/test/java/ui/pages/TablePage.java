package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import properties.PropertiesHolder;
import selenium.annotations.Fragment;
import ui.fragments.MainMenuFragment;

public class TablePage extends BasicPage {

    @Fragment
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

    public void navigate(){
        driver.get(url);
    }

    public boolean isTablePresent(){
        return table.isDisplayed();
    }
}
