package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sandeep.qa.TestBase;
import sandeep.qa.pages.PasswordResetPage;
import sandeep.qa.utils.Context;

import static org.junit.Assert.assertTrue;
import static sandeep.qa.utils.RandomGenerator.getRandomEmail;

public class PasswordResetStepDefinitions extends TestBase {

    public PasswordResetStepDefinitions(Context context){
        super(context);
    }

    PasswordResetPage page = new PasswordResetPage();

    @Then("the password reset page should be displayed")
    public void thePasswordResetPageShouldBeVisible() {
        assertTrue("Password Reset Page is not displayed", page.isPageLoaded());
    }

    @And("it should have an email address field")
    public void itShouldHaveAnEmailAddressField() {
        assertTrue("Email input was not displayed", page.isEmailInputDisplayed());
    }

    @Given("I am on the password reset page")
    public void iAmOnThePasswordResetPage() {
        page.visit();
    }

    @And("I request password reset for a random email")
    public void iRequestPasswordResetForARandomEmail() {
        page.enterEmailAddress(getRandomEmail()).submit();
    }
}
