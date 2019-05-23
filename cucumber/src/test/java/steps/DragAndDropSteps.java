package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.ui.pages.DragAndDropPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DragAndDropSteps {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Given("^user is on dragAndDrop page$")
    public void user_is_on_dragAndDrop_page() {
        dragAndDropPage.navigate();
    }

    @Given("^success message is not shown$")
    public void success_message_is_not_shown() {
        assertFalse(dragAndDropPage.successMessageIsShown());
    }

    @When("^user drop debit account \"([^\"]*)\"$")
    public void user_drop_debit_account(String debitAccount) {
        dragAndDropPage.putDebitAccount(debitAccount);
    }

    @When("^user drop debit amount \"([^\"]*)\"$")
    public void user_drop_debit_amount(String debitAmount) {
        dragAndDropPage.putDebitAmount(debitAmount);
    }

    @When("^user drop credit account \"([^\"]*)\"$")
    public void user_drop_credit_account(String creditAccount) {
        dragAndDropPage.putCreditAccount(creditAccount);
    }

    @When("^user drop credit amount \"([^\"]*)\"$")
    public void user_drop_credit_amount(String creditAmount) {
        dragAndDropPage.putCreditAmount(creditAmount);
    }

    @Then("^success message is shown$")
    public void success_message_is_shown() {
        assertTrue(dragAndDropPage.successMessageIsShown());
    }
}
