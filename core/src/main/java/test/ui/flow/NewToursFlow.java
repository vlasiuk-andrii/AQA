package test.ui.flow;

import test.ui.pages.NewToursPage;

import static com.codeborne.selenide.Selenide.$;

public class NewToursFlow extends NewToursPage {

    public boolean isMainFragmentPresent(){
        return $(mainFragment).isDisplayed();
    }
}
