package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.MainMenuFragment;

public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment(driver);

    @FindBy(css = "form[name='frmLogin']")
    private WebElement loginForm;

    public HomePage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/";
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public void navigate(){
        driver.get(url);
    }

    public boolean isLoginFormPresent(){
        return loginForm.isDisplayed();
    }
}
