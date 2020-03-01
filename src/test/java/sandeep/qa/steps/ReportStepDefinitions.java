package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.qa.TestBase;
import sandeep.qa.pages.ReportPage;
import sandeep.qa.utils.Context;

import java.io.File;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.switchTo;

public class ReportStepDefinitions extends TestBase {

    public ReportStepDefinitions(Context context){
        super(context);
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

    @And("I have the sample report displayed")
    public void iHaveTheSampleReportDisplayed() {
        reportPage.visitSampleReport();
        reportPage.isPageLoaded();
    }

    @When("I click the CSV download link")
    public void iClickTheCSVDownloadLink() {
        File csvFile = reportPage.clickDownloadCsvLink();
        context.extra.put("csvFile", csvFile);
    }

    @Then("the file should be downloaded")
    public void theFileShouldBeDownloaded() {
        Assert.assertNotNull(context.extra.get("csvFile"));
    }

    @Then("all important sections of the report should be displayed")
    public void allImportantSectionsOfTheReportShouldBeDisplayed() {
        Assert.assertTrue(reportPage.isSectionTransactionPriceDisplayed());
        Assert.assertTrue(reportPage.isSectionPropertyDisplayed());
        Assert.assertTrue(reportPage.isSectionNeighbourhoodDisplayed());
        Assert.assertTrue(reportPage.isSectionValueDriversDisplayed());
    }

    @When("I save the report")
    public void iSaveTheReport() {
        reportPage.saveReport();
    }

    @Then("the report should be saved")
    public void theReportShouldBeSaved() {
        Assert.assertTrue("Report is not saved", reportPage.isReprotSaved());
    }

    @When("I scroll down")
    public void iScrollDown() {
        reportPage.scrollToNeighbouthoodSection();
    }

    @Then("the static header should be visible")
    public void theStaticHeaderShouldBeVisible() {
        Assert.assertTrue("Static header is not displayed", reportPage.isStaticHeaderDisplayed());
    }

    @When("I scroll the sticky header into view")
    public void iScrollTheStickyHeaderIntoView() {
        reportPage.scrollToNeighbouthoodSection();
        Assert.assertTrue("Static header is not displayed", reportPage.isStaticHeaderDisplayed());
    }

    @And("I save the report from the sticky header")
    public void iSaveTheReportFromTheStickyHeader() {
        reportPage.saveReprotFromStickyHeader();
    }

    @When("I click the CSV download link from the sticky header")
    public void iClickTheCSVDownloadLinkFromTheStickyHeader() {
        File csvFile = reportPage.clickDownloadCsvLinkFromStickyHeader();
        context.extra.put("csvFile", csvFile);
    }
}
