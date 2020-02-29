package sandeep.geophy.qa.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import sandeep.geophy.qa.pages.ReportPage;
import sandeep.geophy.qa.utils.Context;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.switchTo;

public class ReportStepDefinitions {

    private Context context;

    public ReportStepDefinitions(Context context){
        this.context = context;
    }

    ReportPage reportPage = new ReportPage();

    @Then("the report is displayed")
    public void theReportIsDisplayed() {
        Assert.assertTrue("The report page was not loaded", reportPage.isPageLoaded());
        HashMap<String, String> expectedDetails = (HashMap<String,String>)context.extra.get("recentSearchDetails");
        Assert.assertEquals("Report address mismatch",
                expectedDetails.get("address"), reportPage.getAddress() );
        Assert.assertEquals("Report Year of Construction mismatch",
                expectedDetails.get("yearOfConstruction"), reportPage.getYearOfConstruction() );
        Assert.assertEquals("Report Number of Units mismatch",
                expectedDetails.get("numberOfUnits"), reportPage.getNumberOfUnits() );
    }

    @Then("the sample report should be displayed in a new tab")
    public void theSampleReportShouldBeDisplayed() {
        switchTo().window(1);
        Assert.assertTrue("The sample report is not loaded", reportPage.isPageLoaded());
    }
}
