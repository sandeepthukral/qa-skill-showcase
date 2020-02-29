package sandeep.geophy.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.geophy.qa.TestBase;
import sandeep.geophy.qa.pages.ReportPage;
import sandeep.geophy.qa.pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

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
        searchPage.enterPercentageOccupancy(percentage);
    }

    @And("I run valuation")
    public void iClickTheRunValuation() {
        searchPage.submitForm();
    }

    @Then("I should see the report page")
    public void iShouldSeeTheReportPage() {
        ReportPage page = new ReportPage();
        Assert.assertTrue("Report page was not loaded", page.isPageLoaded());
    }

    @And("the valuation should be the static value")
    public void theValuationShouldBeTheStaticValue() {
        String expectedValuation = prop.getProperty("default_data.search.expected.valuation");
        ReportPage page = new ReportPage();
        Assert.assertTrue("Valuation displayed did not match", expectedValuation.equals(page.getValuation()));
    }

    @And("the cap rate should be the default value")
    public void theCapRateShouldBeTheDefaultValue() {
        String expectedCapRate = prop.getProperty("default_data.search.expected.cap_rate");
        ReportPage page = new ReportPage();
        Assert.assertTrue("Cap rate displayed did not match", expectedCapRate.equals(page.getCapRate()));
    }

    @When("I enter all required fields with static data without validating address")
    public void iEnterAllRequiredFieldsWithStaticDataWithoutValidatingAddress() {
        searchPage.enterAddressWithoutSelectingSuggestion(prop.getProperty("default_data.search.address"))
                .enterNOI(prop.getProperty("default_data.search.noi"))
                .enterNumberOfUnits(prop.getProperty("default_data.search.no_of_units"))
                .enterYearOfConstruction(prop.getProperty("default_data.search.year_built_input"));
    }

    @Then("the Run Valuation button should be disabled")
    public void theRunValuationButtonShouldBeDisabled() {
        Assert.assertFalse("Run Valuation button is enabled when it should not be",
                searchPage.isSubmitButtonEnabled());
        sleep(3000);
    }

    @When("I click the logout link")
    public void iClickTheLogoutLink() {
        searchPage.logout();
    }

    @And("the confidence indicator should be green")
    public void theConfidenceIndicatorShouldBeGreen() {
        ReportPage page = new ReportPage();
        Assert.assertTrue("Confidence indicator is not green", page.isConfidenceIndicatorGreen());
    }
}
