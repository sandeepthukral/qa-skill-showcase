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

    LoginPage loginPage = new LoginPage();

    @Given("an open browser with login page")
    public void anOpenBrowserWithLoginPage() {
        loginPage.visit();
    }

    @When("I enter a correct username")
    public void iEnterACorectUsername() {
        loginPage.enterUsername(prop.getProperty("username", "blank"));
    }

    @And("I enter a correct password")
    public void iEnterACorrectPassword() {
        loginPage.enterPassword(prop.getProperty("password", "blank"));
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        SearchPage page = new SearchPage();
        assertTrue(page.isPageLoaded());
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        loginPage.submitForm();
    }

    @When("the Forgot Password link is clicked")
    public void theForgotPasswordLinkIsClicked() {
        loginPage.clickForgotPasswordLink();
    }

    @When("the Signup link is clicked")
    public void theSignupLinkIsClicked() {
        loginPage.clickSignupLink();
    }

    @Given("I am logged in to Evra")
    public void iAmLoggedInToEvra() {
        loginPage.visit()
                .login(
                        prop.getProperty("username", "blank"),
                        prop.getProperty("password", "blank")
                );
    }

    @Then("I should be at the login page")
    public void iAmLoggedOut() {
        assertTrue("User did not land at the Login Page", loginPage.isPageDisplayed());
    }
}
