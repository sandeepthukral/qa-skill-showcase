package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import sandeep.geophy.qa.pages.PasswordResetPage;
import sandeep.geophy.qa.utils.Context;

import static org.junit.Assert.assertTrue;

public class PasswordResetStepDefinitions {

    private Context context;

    public PasswordResetStepDefinitions(Context context){
        this.context = context;
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
}
