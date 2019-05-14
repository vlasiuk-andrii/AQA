package ui.pages;


import base.BasePage;
import driver.CustomWebDriverManager;
import org.openqa.selenium.By;
import properties.PropertiesHolder;
import ui.enums.PagePaths;
import ui.enums.PageTitles;
import ui.fragments.AgileProjectMenuFragment;
import ui.fragments.AgileProjectTableFragment;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class AgileProjectPage extends BasePage {

    private AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment();
    private AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment();

    private By userInput = By.cssSelector("input[name='uid']");
    private By passwordInput = By.cssSelector("input[name='password']");
    private By logInButton = By.cssSelector("input[name='btnLogin']");

    public AgileProjectPage() {
        url = getAgileProjectPageUrl();
        title = getAgileProjectPageTitle();
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

    private URL getAgileProjectPageUrl() {
        URL url = null;
        try {
            url = new URL( PropertiesHolder.getProperty("base.url") + PagePaths.AGILE_PROJECT_PAGE.getValue());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getAgileProjectPageTitle(){
        return PageTitles.AGILE_PROJECT_PAGE.getValue();
    }
}
