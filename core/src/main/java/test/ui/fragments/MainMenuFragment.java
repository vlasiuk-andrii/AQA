package test.ui.fragments;

import main.base.BaseFragment;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainMenuFragment extends BaseFragment {

    protected By rootElement = By.cssSelector("div#navbar-brand-centered");
    protected By newTourButton = By.cssSelector("a[href*='newtours']");
    protected By agileProjectButton = By.cssSelector("a[href*='Agile']");
    protected By seleniumDropDown = By.cssSelector("a.dropdown-toggle");
    protected By tableDemoLink = By.cssSelector("a[href*='table']");

    public MainMenuFragment() {
        super.rootElement = rootElement;
    }

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
