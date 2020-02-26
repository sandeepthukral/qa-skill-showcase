package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.geophy.qa.pages.LoginPage;
import sandeep.geophy.qa.pages.PasswordResetPage;
import sandeep.geophy.qa.pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {
    @Given("an open browser with login page")
    public void anOpenBrowserWithLoginPage() {
        LoginPage page = new LoginPage();
        page.visit();
    }

    @When("I enter a corect username")
    public void iEnterACorectUsername() {
        LoginPage page = new LoginPage();
        //TODO move username to a config file
        page.enterUsername("qaskillschallenge@geophy.com");
    }

    @And("I enter a correct password")
    public void iEnterACorrectPassword() {
        LoginPage page = new LoginPage();
        //TODO move password to a config file
        page.enterPassword("qaskillschallenge@geophy.com");
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        SearchPage page = new SearchPage();
        assertTrue(page.isPageLoaded());
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        LoginPage page = new LoginPage();
        page.submitForm();
    }

    @When("the Forgot Password link is clicked")
    public void theForgotPasswordLinkIsClicked() {
        LoginPage page = new LoginPage();
        page.clickForgotPasswordLink();
    }

    @Then("the password reset page should be visible")
    public void thePasswordResetPageShouldBeVisible() {
        PasswordResetPage page = new PasswordResetPage();
        assertTrue(page.isPageLoaded());
    }

    @And("it should have an email address field")
    public void itShouldHaveAnEmailAddressField() {
        PasswordResetPage page = new PasswordResetPage();
        assertTrue(page.isEmailFieldDisplayed());
    }
}
