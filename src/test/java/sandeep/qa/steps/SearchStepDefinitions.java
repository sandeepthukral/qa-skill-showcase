package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.qa.TestBase;
import sandeep.qa.pages.ReportPage;
import sandeep.qa.pages.SearchPage;
import sandeep.qa.utils.Context;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchStepDefinitions extends TestBase {

    public SearchStepDefinitions(Context context){
        super(context);
    }

    SearchPage searchPage = new SearchPage();

    @And("I am on the Evra search page")
    public void iAmOnTheEvraSearchPage() {
        //TODO make this URL relative, giving the domain in a config file
        open("https://evra.geophy.com/search");
    }

    @When("I enter all required fields with static data")
    public void iEnterAllRequiredFieldsWithStaticData() {
        searchPage.enterAddress(config.get("default_data.search.address"))
                .enterNOI(config.get("default_data.search.noi"))
                .enterNumberOfUnits(config.get("default_data.search.no_of_units"))
                .enterYearOfConstruction(config.get("default_data.search.year_built_input"));
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
        String expectedValuation = config.get("default_data.search.expected.valuation");
        ReportPage page = new ReportPage();
        Assert.assertTrue("Valuation displayed did not match", expectedValuation.equals(page.getValuation()));
    }

    @And("the cap rate should be the default value")
    public void theCapRateShouldBeTheDefaultValue() {
        String expectedCapRate = config.get("default_data.search.expected.cap_rate");
        ReportPage page = new ReportPage();
        Assert.assertTrue("Cap rate displayed did not match", expectedCapRate.equals(page.getCapRate()));
    }

    @When("I enter all required fields with static data without validating address")
    public void iEnterAllRequiredFieldsWithStaticDataWithoutValidatingAddress() {
        searchPage.enterAddressWithoutSelectingSuggestion(config.get("default_data.search.address"))
                .enterNOI(config.get("default_data.search.noi"))
                .enterNumberOfUnits(config.get("default_data.search.no_of_units"))
                .enterYearOfConstruction(config.get("default_data.search.year_built_input"));
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

    @When("I click on the first report in recent searches list")
    public void iClickOnTheFirstReportInRecentSearchesList() {
        context.extra.put("recentSearchDetails", searchPage.getRecentSearchInformation());
        searchPage.clickFirstRecentSearch();
    }

    @When("I save the first report in recent searches list")
    public void iSaveTheFirstReportInRecentSearchesList() {
        searchPage.saveFirstRecentSearch();
    }

    @Then("the first report in the recent searches should be saved")
    public void theFirstReportInTheRecentSearchesIsSaved() {
        Assert.assertTrue("The first report is not saved", searchPage.isFirstRecentSearchSaved());
    }

    @And("I run valuation with static data")
    public void iRunValuationWithStaticData() {
        this.iEnterAllRequiredFieldsWithStaticData();
        this.iClickTheRunValuation();
        this.iShouldSeeTheReportPage();
    }

    @When("I click on the sample report")
    public void iClickOnTheSampleReport() {
        searchPage.clickSampleReportLink();
    }
}
