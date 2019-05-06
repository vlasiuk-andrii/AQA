package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import properties.PropertiesHolder;
import driver.WebDriverManager;
import ui.fragments.AgileProjectMenuFragment;
import ui.fragments.AgileProjectTableFragment;

import java.net.MalformedURLException;
import java.net.URL;

public class AgileProjectPage extends BasePage {

    private AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment();
    private AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment();

    @FindBy(css = "input[name='uid']")
    private WebElement userInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[name='btnLogin']")
    private WebElement logInButton;

    public AgileProjectPage() {
        url = getAgileProjectPageUrl();
    }

    public void logIn(String user, String password) {
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        logInButton.click();
        WebDriverManager.waitForPageToLoad(webDriver);
    }

    public void rememberNewPageUrl(URL url) {
        this.url = url;
    }

    public AgileProjectMenuFragment getAgileProjectMenuFragment() {
        return agileProjectMenuFragment;
    }

    public AgileProjectTableFragment getAgileProjectTableFragment() {
        return agileProjectTableFragment;
    }

    private URL getAgileProjectPageUrl() {
        URL url = null;
        try {
            url = new URL( PropertiesHolder.getProperty("base.url") + "/Agile_Project/Agi_V1/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
