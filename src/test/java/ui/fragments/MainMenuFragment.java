package ui.fragments;

import base.BaseFragment;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainMenuFragment extends BaseFragment {

    private By rootElement = By.cssSelector("div#navbar-brand-centered");
    private By newTourButton = By.cssSelector("a[href*='newtours']");
    private By seleniumDropDown = By.cssSelector("a.dropdown-toggle");
    private By tableDemoLink = By.cssSelector("a[href*='table']");

    public MainMenuFragment() {
        super.rootElement = rootElement;
    }


    public void clickOnNewToursButton(){
        $(rootElement).find(newTourButton).click();
    }

    public void clickOnSeleniumDropDown(){
        $(rootElement).find(seleniumDropDown).click();
    }

    public void clickOnTableDemoLink(){
        $(rootElement).find(tableDemoLink).click();
    }
}
