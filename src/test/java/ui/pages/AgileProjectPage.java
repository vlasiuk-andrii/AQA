package ui.pages;


import base.BasePage;
import driver.CustomWebDriverManager;
import org.openqa.selenium.By;
import ui.enums.PagePaths;
import ui.enums.PageTitles;
import ui.fragments.AgileProjectMenuFragment;
import ui.fragments.AgileProjectTableFragment;

import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class AgileProjectPage extends BasePage {

    private AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment();
    private AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment();

    private By userInput = By.cssSelector("input[name='uid']");
    private By passwordInput = By.cssSelector("input[name='password']");
    private By logInButton = By.cssSelector("input[name='btnLogin']");

    public AgileProjectPage() {
        url = getExpectedPageUrl(PagePaths.AGILE_PROJECT_PAGE.getValue());
        title = PageTitles.AGILE_PROJECT_PAGE.getValue();;
    }

    public void logIn(String user, String password) {
        $(userInput).sendKeys(user);
        $(passwordInput).sendKeys(password);
        $(logInButton).click();
        CustomWebDriverManager.waitForPageToLoad(webDriver);
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
}
