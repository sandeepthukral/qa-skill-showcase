package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.geophy.qa.pages.LoginPage;
import sandeep.geophy.qa.pages.SearchPage;

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
        org.junit.Assert.assertTrue(page.isPageLoaded());
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        LoginPage page = new LoginPage();
        page.submitForm();
    }
}
