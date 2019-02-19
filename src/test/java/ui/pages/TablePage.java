package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import properties.PropertiesHolder;

public class TablePage extends BasicPage {

    @FindBy(css = "table>tbody")
    private WebElement table;

    public TablePage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/test/table.html";
    }

    public void navigate(){
        driver.get(url);
    }

    public boolean isTablePresent(){
        return table.isDisplayed();
    }
}
