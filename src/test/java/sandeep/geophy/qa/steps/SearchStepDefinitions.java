package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.geophy.qa.TestBase;
import sandeep.geophy.qa.pages.ReportPage;
import sandeep.geophy.qa.pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;

public class SearchStepDefinitions extends TestBase {

    SearchPage searchPage = new SearchPage();

    @And("I am on the Evra search page")
    public void iAmOnTheEvraSearchPage() {
        //TODO make this URL relative, giving the domain in a config file
        open("https://evra.geophy.com/search");
    }

    @When("I enter all required fields with static data")
    public void iEnterAllRequiredFieldsWithStaticData() {
        searchPage.enterAddress(prop.getProperty("default_data.search.address"))
                .enterNOI(prop.getProperty("default_data.search.noi"))
                .enterNumberOfUnits(prop.getProperty("default_data.search.no_of_units"))
                .enterYearOfConstruction(prop.getProperty("default_data.search.year_built_input"));
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
        org.junit.Assert.assertTrue(page.isPageLoaded());
    }

    @And("the valuation should be the static value")
    public void theValuationShouldBeTheStaticValue() {
        String expectedValuation = prop.getProperty("default_data.search.expected.valuation");
        ReportPage page = new ReportPage();
        assert expectedValuation.equals(page.getValuation());
    }

    @And("the cap rate should be the default value")
    public void theCapRateShouldBeTheDefaultValue() {
        String expectedCapRate = prop.getProperty("default_data.search.expected.cap_rate");
        ReportPage page = new ReportPage();
        assert expectedCapRate.equals(page.getCapRate());
    }
}
