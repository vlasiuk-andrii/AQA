package test.ui.flow;

import test.ui.pages.NewToursPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NewToursFlow extends BaseFlow {

    NewToursPage newToursPage = new NewToursPage();

    public boolean isMainFragmentPresent(){
        return page(NewToursPage.class).getMainFragmentE().isDisplayed();
//        return $(mainFragment).isDisplayed();
    }

    public NewToursPage getNewToursPage(){
        return newToursPage;
    }
}
