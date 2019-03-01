package ui.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import selenium.UiDriverManager;
import ui.fragments.AgileProjectMenuFragment;
import ui.fragments.AgileProjectTableFragment;

public class AgileProjectPage extends BasePage {

    private AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment(driver, appiumDriver);
    private AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment(driver, appiumDriver);

    @FindBy(css = "input[name='uid']")
    private WebElement userInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[name='btnLogin']")
    private WebElement logInButton;

    public AgileProjectPage(WebDriver driver) {
        super(driver);
        url = getAgileProjectPageUrl();
    }

    public AgileProjectPage(AppiumDriver appiumDriver){
        super(appiumDriver);
        url = getAgileProjectPageUrl();
    }

    public void logIn(String user, String password) {
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        logInButton.click();
        UiDriverManager.waitForPageToLoad();
    }

    public void rememberNewPageUrl(String url) {
        this.url = url;
    }

    public AgileProjectMenuFragment getAgileProjectMenuFragment() {
        return agileProjectMenuFragment;
    }

    public AgileProjectTableFragment getAgileProjectTableFragment() {
        return agileProjectTableFragment;
    }

    private String getAgileProjectPageUrl(){
        return PropertiesHolder.getProperty("baseUrl")  + "/Agile_Project/Agi_V1/";
    }
}
