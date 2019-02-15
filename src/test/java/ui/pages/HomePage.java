package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import properties.PropertiesHolder;

public class HomePage extends BasicPage {

    @FindBy(css = "body>div>table")
    private WebElement mainFragment;

    public HomePage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/";
    }

    public void navigate(){
        driver.get(url);
    }

    public boolean isMainFragmentPresent(){
        return mainFragment.isDisplayed();
    }
}
