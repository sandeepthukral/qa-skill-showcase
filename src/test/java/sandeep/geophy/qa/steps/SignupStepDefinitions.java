package sandeep.geophy.qa.steps;

import io.cucumber.java.en.Then;
import sandeep.geophy.qa.TestBase;
import sandeep.geophy.qa.pages.SignupPage;
import sandeep.geophy.qa.utils.Context;

import static org.junit.Assert.assertTrue;

public class SignupStepDefinitions extends TestBase {

    private Context context;

    public SignupStepDefinitions(Context context){
        super(context);
    }

    @Then("the signup page should be displayed")
    public void theSignupPageShouldBeDisplayed() {
        SignupPage page = new SignupPage();
        assertTrue("Signup page is not displayed", page.isPageLoaded());
    }
}
