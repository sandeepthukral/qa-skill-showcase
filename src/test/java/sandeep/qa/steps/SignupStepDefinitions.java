package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sandeep.qa.TestBase;
import sandeep.qa.pages.SignupPage;
import sandeep.qa.utils.Context;

import static org.junit.Assert.assertTrue;
import static sandeep.qa.utils.RandomGenerator.*;

public class SignupStepDefinitions extends TestBase {

    SignupPage page = new SignupPage();

    public SignupStepDefinitions(Context context){
        super(context);
    }

    @Then("the signup page should be displayed")
    public void theSignupPageShouldBeDisplayed() {

        assertTrue("Signup page is not displayed", page.isPageLoaded());
    }

    @Given("I am on the user signup page")
    public void iAmOnTheUserSignupPage() {
        page.visit();
    }

    @And("I signup with random required values")
    public void iSignupWithRandomRequiredValues() {
        page.submitFormWithData(getRandomName(), getRandomName(), getRandomEmail(), getRandomPassword());
    }
}
