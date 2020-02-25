package sandeep.geophy.qa.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.geophy.qa.pages.GooglePage;
import sandeep.geophy.qa.pages.SearchResultsPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchStepDefinitions {
    private String keyword;

    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        Configuration.reportsFolder = "build/surefire-reports";
        open("https://google.com/ncr");
    }

    @When("a keyword {word} is entered in input field")
    public void enterKeyword(String keyword) {
        this.keyword = keyword;
        new GooglePage().searchFor(keyword);
    }

    @Then("at least top {int} matches should be shown")
    public void topTenMatchesShouldBeShown(int resultsCount) {
        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThanOrEqual(1));
    }

    @Then("the first one should contain {word}")
    public void theFirstOneShouldContainKeyword(String expectedText) {
        SearchResultsPage results = new SearchResultsPage();
        results.getResult(0).shouldHave(text(expectedText));
    }
}
