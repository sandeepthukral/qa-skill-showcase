package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import sandeep.geophy.qa.pages.PasswordResetPage;

import static org.junit.Assert.assertTrue;

public class PasswordResetStepDefinitions {
    @Then("the password reset page should be displayed")
    public void thePasswordResetPageShouldBeVisible() {
        PasswordResetPage page = new PasswordResetPage();
        assertTrue(page.isPageLoaded());
    }

    @And("it should have an email address field")
    public void itShouldHaveAnEmailAddressField() {
        PasswordResetPage page = new PasswordResetPage();
        assertTrue(page.isEmailInputDisplayed());
    }
}
