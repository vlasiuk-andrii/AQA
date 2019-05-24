package test.ui.flow;

import test.ui.pages.HomePage;

import static com.codeborne.selenide.Selenide.$;

public class HomeFlow extends HomePage {

    public boolean isLoginFormPresent(){
        return $(loginForm).isDisplayed();
    }
}
