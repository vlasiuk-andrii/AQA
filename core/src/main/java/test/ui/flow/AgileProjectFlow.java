package test.ui.flow;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import test.ui.fragments.AgileProjectMenuFragment;
import test.ui.fragments.AgileProjectTableFragment;
import test.ui.pages.AgileProjectPage;

import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AgileProjectFlow extends BaseFlow {

    AgileProjectPage agileProjectPage = new AgileProjectPage();

    public void logIn(String user, String password) {
        page(AgileProjectPage.class).getUserInputE().sendKeys(user);
        page(AgileProjectPage.class).getPasswordInputE().sendKeys(password);
        page(AgileProjectPage.class).getLogInButtonE().click();
        page(AgileProjectPage.class).getCustomerMenuE().waitUntil(visible, defaultTimeoutSeconds);

        //WebDriverRunner.getWebDriver();
//        $(userInput).sendKeys(user);
//        $(passwordInput).sendKeys(password);
//        $(logInButton).click();
//        $(customerMenu).waitUntil(visible, defaultTimeoutSeconds);
    }

    public void rememberNewPageUrl(URL url) {
//        this.url = url;
        page(AgileProjectPage.class).setUrl(url);
    }

    public String getWelcomeMessage(){
        return page(AgileProjectPage.class).getWelcomeMessageE().getText();
//        return $(welcomeMessage).getText();
    }

    public AgileProjectMenuFragment getAgileProjectMenuFragment(){
        return agileProjectPage.getAgileProjectMenuFragment();
    }

    public AgileProjectTableFragment getAgileProjectTableFragment(){
        return agileProjectPage.getAgileProjectTableFragment();
    }
}
