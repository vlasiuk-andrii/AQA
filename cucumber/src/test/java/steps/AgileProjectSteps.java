package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.driver.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import test.ui.pages.AgileProjectPage;
import test.ui.pages.HomePage;

import static org.junit.Assert.assertEquals;

public class AgileProjectSteps {

    protected static WebDriver webDriver = CustomWebDriverManager.getWebDriver();

    HomePage homePage = new HomePage();
    AgileProjectPage agileProjectPage = new AgileProjectPage();

    @Before
    public void initialization(){
        System.out.println("Before suite");
    }

    @After
    public void tearDown(){
        webDriver.close();
        System.out.println("After suite");
    }

    @Given("^user is on home page$")
    public void user_is_on_homepage() {
        homePage.navigate();
    }

    @When("^user navigates to agile page$")
    public void user_navigates_to_agile_page() {
       homePage.getMainMenuFragment().clickOnAgileProjectButton();
    }

    @When("^user enters username and password$")
    public void user_enters_username_and_password() {
        agileProjectPage.logIn("1303", "Guru99");
    }

    @When("^click login button$")
    public void click_login_button() {
    }

    @Then("^welcome message is correct$")
    public void welcome_message_is_correct() {
        String expectedMessage = "Welcome To Customer's Page of Guru99 Bank";
        assertEquals(expectedMessage, agileProjectPage.getWelcomeMessage());
    }
}
