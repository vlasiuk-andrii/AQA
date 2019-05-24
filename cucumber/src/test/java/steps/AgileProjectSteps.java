package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.ui.flow.AgileProjectFlow;
import test.ui.flow.HomeFlow;

import static org.junit.Assert.assertEquals;

public class AgileProjectSteps {

    HomeFlow homeFlow = new HomeFlow();
    AgileProjectFlow agileProjectFlow = new AgileProjectFlow();

    @Given("^user is on home page$")
    public void user_is_on_homepage() {
        homeFlow.navigate();
    }

    @When("^user navigates to agile page$")
    public void user_navigates_to_agile_page() {
       homeFlow.getMainMenuFlow().clickOnAgileProjectButton();
    }

    @When("^user enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_and_password(String user, String password) {
        agileProjectFlow.logIn(user, password);
    }

    @When("^click login button$")
    public void click_login_button() {
    }

    @Then("^welcome message is correct$")
    public void welcome_message_is_correct() {
        String expectedMessage = "Welcome To Customer's Page of Guru99 Bank";
        assertEquals(expectedMessage, agileProjectFlow.getWelcomeMessage());
    }
}
