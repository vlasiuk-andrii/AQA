package test.ui.flow;

import main.core.annotation.Parameters;
import test.ui.fragments.AgileProjectMenuFragment;
import test.ui.fragments.AgileProjectTableFragment;
import test.ui.pages.AgileProjectPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class AgileProjectFlow extends BaseFlow {

    AgileProjectPage agileProjectPage = new AgileProjectPage();

    public void logIn(String user, String password) {
        page(AgileProjectPage.class).getUserInputE().sendKeys(user);
        page(AgileProjectPage.class).getPasswordInputE().sendKeys(password);
        page(AgileProjectPage.class).getLogInButtonE().click();
        page(AgileProjectPage.class).getCustomerMenuE().waitUntil(visible, defaultTimeoutSeconds);
    }

    public void refreshPageUrl(String url) {
        AgileProjectPage.class.getAnnotation(Parameters.class).url();
    }

    public String getWelcomeMessage(){
        return page(AgileProjectPage.class).getWelcomeMessageE().getText();
    }

    public AgileProjectMenuFragment getAgileProjectMenuFragment(){
        return agileProjectPage.getAgileProjectMenuFragment();
    }

    public AgileProjectTableFragment getAgileProjectTableFragment(){
        return agileProjectPage.getAgileProjectTableFragment();
    }
}
