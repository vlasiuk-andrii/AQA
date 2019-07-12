package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.core.annotation.Parameters;
import test.ui.flow.HomeFlow;
import test.ui.flow.NewToursFlow;
import test.ui.flow.TableFlow;
import test.ui.pages.HomePage;
import test.ui.pages.NewToursPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmokeNavigationSteps extends BaseSteps {

    HomeFlow homeFlow = new HomeFlow();
    NewToursFlow newToursFlow = new NewToursFlow();
    TableFlow tableFlow = new TableFlow();

    @When("user navigate to homePage")
    public void userNavigateToHomePage(){
        homeFlow.navigate(HomePage.class);
    };

    @Then("title of homePage is correct")
    public void titleOfHomePageIsCorrect(){
        assertEquals(homeFlow.getHomePage().getClass().getAnnotation(Parameters.class).title(), homeFlow.getHomePage().getTitleFromBrowser());
    };

    @Then("login form is present")
    public void loginFormIsPresent(){
        assertTrue(homeFlow.isLoginFormPresent());
    }

    @Given("user is on homePage")
    public void userIsOnHomePage(){
        homeFlow.navigate(HomePage.class);
        assertEquals(homeFlow.getExpectedUrl(NewToursPage.class), getCurrentUrl());
    }

    @When("user click on newToursButton")
    public void userClickOnNewToursButton(){
        homeFlow.getMainMenuFragment().clickOnNewToursButton();
    }

    @Then("title of newToursPage is correct")
    public void titleOfNewToursPageIsCorrect(){
        assertEquals(newToursFlow.getNewToursPage().getClass().getAnnotation(Parameters.class).title(), newToursFlow.getNewToursPage().getTitleFromBrowser());
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
        assertEquals(tableFlow.getTablePage().getClass().getAnnotation(Parameters.class).title(), tableFlow.getTablePage().getTitleFromBrowser());
    }

    @Then("table is present")
    public void tableIsPresent(){
        assertTrue(tableFlow.isTablePresent());
    }
}
