package test.ui.flow;

import test.ui.fragments.MainMenuFragment;
import test.ui.pages.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomeFlow extends BaseFlow {

    HomePage homePage = new HomePage();

    public boolean isLoginFormPresent(){
        return page(HomePage.class).getLoginForm().isDisplayed();
//        return $(loginForm).isDisplayed();
    }

    public MainMenuFragment getMainMenuFragment(){
        return homePage.getMainMenuFragment();
    }

    public HomePage getHomePage(){
        return homePage;
    }
}
