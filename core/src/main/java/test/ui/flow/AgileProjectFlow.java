package test.ui.flow;

import test.ui.pages.AgileProjectPage;

import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AgileProjectFlow extends AgileProjectPage {

    public void logIn(String user, String password) {
        $(userInput).sendKeys(user);
        $(passwordInput).sendKeys(password);
        $(logInButton).click();
        $(customerMenu).waitUntil(visible, defaultTimeoutSeconds);
    }

    public void rememberNewPageUrl(URL url) {
        this.url = url;
    }

    public String getWelcomeMessage(){
        return $(welcomeMessage).getText();
    }
}
