package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.geophy.qa.pages.LoginPage;
import sandeep.geophy.qa.pages.ReportPage;
import sandeep.geophy.qa.pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;

public class SearchStepDefinitions {
    @Given("I am logged in to Evra")
    public void iAmLoggedInToEvra() {
        LoginPage page = new LoginPage();
        page.visit();
        page.login("qaskillschallenge@geophy.com", "qaskillschallenge@geophy.com");
    }

    @And("I am on the Evra search page")
    public void iAmOnTheEvraSearchPage() {
        //TODO make this URL relative, giving the domain in a config file
        open("https://evra.geophy.com/search");
    }

    @When("I enter all required fields with static data")
    public void iEnterAllRequiredFieldsWithStaticData() {
        SearchPage page = new SearchPage();
        page.enterAddress();
        page.enterNOI();
        page.enterNumberOfUnits();
        page.enterYearOfConstruction();
    }

    @And("I enter an occupancy of {word} percent")
    public void iEnterAnOccupancyOfPercent(String percentage) {
        SearchPage page = new SearchPage();
        page.enterPercentageOccupancy(percentage);
    }

    @And("I click the run validation")
    public void iClickTheRunValidation() {
        SearchPage page = new SearchPage();
        page.submitForm();
    }

    @Then("I should see the report page")
    public void iShouldSeeTheReportPage() {
        ReportPage page = new ReportPage();
        org.junit.Assert.assertTrue(page.isReportLoaded());
    }

    @And("the valuation should be the static value")
    public void theValuationShouldBeTheStaticValue() {
        String expectedValuation = "35626200";
        ReportPage page = new ReportPage();
        assert expectedValuation.equals(page.getValuation());
    }

    @And("the cap rate should be the default value")
    public void theCapRateShouldBeTheDefaultValue() {
        String expectedCapRate = "5.61%";
        ReportPage page = new ReportPage();
        assert expectedCapRate.equals(page.getCapRate());
    }
}
