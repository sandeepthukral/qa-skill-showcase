package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import sandeep.qa.pages.SignupSuccessPage;

public class SignupSuccessStepDefinitions {

    SignupSuccessPage page = new SignupSuccessPage();

    @Then("I should be redirected to the signup success page")
    public void iShouldBeRedirectedToTheSignupSuccessPage() {
        Assert.assertTrue("The Signup Success Page was not loaded", page.isPageLoaded());
    }

    @And("I should see the continue button")
    public void iShouldSeeTheContinueButton() {
        Assert.assertTrue("Continue button was not found", page.isContinueButtonDisplayed());
    }
}
