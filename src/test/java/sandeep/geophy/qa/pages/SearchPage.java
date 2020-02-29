package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    SelenideElement
            pageForm=$("form[action='https://evra.geophy.com/search']"),
            addressInput=$(By.id("address_input")),
            firstAddressSuggested=$(".pac-container > .pac-item", 0),
            noiInput=$(By.id("noi")),
            numberOfUnitsInput=$(By.name("number_of_units")),
            yearBuiltInput=$(By.name("year_built")),
            occupancyInput=$(By.name("occupancy")),
            submitButton=$("button[type='submit']"),
            logoutLink=$("a[href='https://evra.geophy.com/logout'"),
            firstRecentSearchSaveLink=$("table#tblValuationHistory tr", 1).find("a", 0),
            firstRecentSearchAddressLink=$("table#tblValuationHistory tr", 1).find("a", 1),
            getFirstRecentSearchSavedIcon=$("table#tblValuationHistory tr", 1).find("a", 0).find("i"),
            sampleReportLink=$("#introjsSampleReport>a");


    public boolean isPageLoaded() {
        return pageForm.shouldBe(Condition.visible).exists();
    }

    public SearchPage enterAddress(String address) {
        addressInput.val(address);
        firstAddressSuggested.click();
        return this;
    }

    public SearchPage enterAddressWithoutSelectingSuggestion(String address) {
        addressInput.val(address);
        return this;
    }

    public SearchPage enterNOI(String noi) {
        noiInput.val(noi);
        return this;
    }

    public SearchPage enterNumberOfUnits(String no_of_units) {
        numberOfUnitsInput.val(no_of_units);
        return this;
    }

    public SearchPage enterYearOfConstruction(String year) {
        yearBuiltInput.val(year);
        return this;
    }

    public SearchPage enterPercentageOccupancy(String percentage) {
        occupancyInput.val(percentage);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public boolean isSubmitButtonEnabled() {
        String classes = submitButton.getAttribute("class");
        return !classes.contains("button--disabled");
    }

    public void logout() {
        logoutLink.click();
    }

    public Map<String, String> getRecentSearchInformation() {
        HashMap<String, String> recentSearchInfo = new HashMap<String, String>();
        SelenideElement row = $("table#tblValuationHistory tr", 1);
        String address = row.find("td", 2).innerText().strip();
        String numberOfUnits = row.find("td", 5).innerText().strip();
        String yearConstruction = row.find("td", 4).innerText().strip();
        recentSearchInfo.put("address", address);
        recentSearchInfo.put("numberOfUnits", numberOfUnits);
        recentSearchInfo.put("yearOfConstruction", yearConstruction);
        return recentSearchInfo;
    }

    public void clickFirstRecentSearch() {
        firstRecentSearchAddressLink.click();
    }

    public void saveFirstRecentSearch() {
        firstRecentSearchSaveLink.click();
    }

    public boolean isFirstRecentSearchSaved() {
        String classes = getFirstRecentSearchSavedIcon.getAttribute("class");
        return classes.contains("fas");
    }

    public void clickSampleReportLink() {
        sampleReportLink.click();
    }
}
