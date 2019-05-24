package test.ui.flow;

import test.ui.fragments.MainMenuFragment;

import static com.codeborne.selenide.Selenide.$;

public class MainMenuFlow extends MainMenuFragment {

    public void clickOnNewToursButton(){
        $(rootElement).find(newTourButton).click();
    }

    public void clickOnAgileProjectButton(){
        $(rootElement).find(agileProjectButton).click();
    }

    public void clickOnSeleniumDropDown(){
        $(rootElement).find(seleniumDropDown).click();
    }

    public void clickOnTableDemoLink(){
        $(rootElement).find(tableDemoLink).click();
    }
}
