package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.ui.flow.DragAndDropFlow;
import test.ui.flow.HomeFlow;
import test.ui.flow.NewToursFlow;
import test.ui.flow.TableFlow;
import test.ui.pages.DragAndDropPage;
import test.ui.pages.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.*;

public class SmokeNavigationSteps {

    HomeFlow homeFlow = new HomeFlow();
    NewToursFlow newToursFlow = new NewToursFlow();
    TableFlow tableFlow = new TableFlow();

    @When("user navigate to homePage")
    public void userNavigateToHomePage(){
        homeFlow.navigate(page(HomePage.class).getUrl());
    };

    @Then("title of homePage is correct")
    public void titleOfHomePageIsCorrect(){
        assertEquals(homeFlow.getHomePage().getDefaultTitle(), homeFlow.getHomePage().getTitleFromBrowser());
    };

    @Then("login form is present")
    public void loginFormIsPresent(){
        assertTrue(homeFlow.isLoginFormPresent());
    }

    @Given("user is on homePage")
    public void userIsOnHomePage(){
        homeFlow.navigate(page(HomePage.class).getUrl());
        assertEquals(homeFlow.getHomePage().getDefaultUrl().toString(), url());
    }

    @When("user click on newToursButton")
    public void userClickOnNewToursButton(){
        homeFlow.getMainMenuFragment().clickOnNewToursButton();
    }

    @Then("title of newToursPage is correct")
    public void titleOfNewToursPageIsCorrect(){
        assertEquals(newToursFlow.getNewToursPage().getDefaultTitle(), newToursFlow.getNewToursPage().getTitleFromBrowser());
    }

    @Then("main fragment is present")
    public void mainFragmentIsPresent(){
        assertTrue(newToursFlow.isMainFragmentPresent());
    }

    @When("user click on tableDemoLink")
    public void userClickOnTableDemoLink(){
        homeFlow.getMainMenuFragment().clickOnSeleniumDropDown();
        homeFlow.getMainMenuFragment().clickOnTableDemoLink();
    }

    @Then("title of tablePage is correct")
    public void titleOfTablePageIsCorrect(){
        assertEquals(tableFlow.getDefaultTitle(), tableFlow.getTitleFromBrowser());
    }

    @Then("table is present")
    public void tableIsPresent(){
        assertTrue(tableFlow.isTablePresent());
    }
}
