package test.ui.pages;


import main.base.BasePage;
import org.openqa.selenium.By;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.fragments.AgileProjectMenuFragment;
import test.ui.fragments.AgileProjectTableFragment;

import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AgileProjectPage extends BasePage {

    private AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment();
    private AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment();

    private By userInput = By.cssSelector("input[name='uid']");
    private By passwordInput = By.cssSelector("input[name='password']");
    private By logInButton = By.cssSelector("input[name='btnLogin']");
    private By customerMenu = By.cssSelector("ul[class='menusubnav']");
    private By welcomeMessage = By.cssSelector("marquee");

    public AgileProjectPage() {
        url = getExpectedPageUrl(PagePaths.AGILE_PROJECT_PAGE.getValue());
        title = PageTitles.AGILE_PROJECT_PAGE.getValue();;
    }

    public void logIn(String user, String password) {
        $(userInput).sendKeys(user);
        $(passwordInput).sendKeys(password);
        $(logInButton).click();
        $(customerMenu).waitUntil(visible, defaultTimeoutSeconds);
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

    public String getWelcomeMessage(){
        return $(welcomeMessage).getText();
    }
}
