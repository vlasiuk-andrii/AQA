package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;
import ui.fragments.AgileProjectMenuFragment;
import ui.fragments.AgileProjectTableFragment;

public class AgileProjectPage extends BasePage {

    private AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment(driver);
    private AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment(driver);

    @FindBy(css = "input[name='uid']")
    private WebElement userInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[name='btnLogin']")
    private WebElement logInButton;

    public AgileProjectPage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/Agile_Project/Agi_V1/";
    }

    public void logIn(String user, String password) {
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        logInButton.click();
        waitABit(100);
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
}
