package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.geophy.qa.TestBase;
import sandeep.geophy.qa.pages.LoginPage;
import sandeep.geophy.qa.pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions extends TestBase {
    @Given("an open browser with login page")
    public void anOpenBrowserWithLoginPage() {
        LoginPage page = new LoginPage();
        page.visit();
    }

    @When("I enter a corect username")
    public void iEnterACorectUsername() {
        LoginPage page = new LoginPage();
        page.enterUsername(prop.getProperty("username", "blank"));
    }

    @And("I enter a correct password")
    public void iEnterACorrectPassword() {
        LoginPage page = new LoginPage();
        page.enterPassword(prop.getProperty("password", "blank"));
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

    @When("the Signup link is clicked")
    public void theSignupLinkIsClicked() {
        LoginPage page = new LoginPage();
        page.clickSignupLink();
    }
}
