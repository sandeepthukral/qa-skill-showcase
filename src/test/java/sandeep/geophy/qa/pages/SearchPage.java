package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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
            submitButton=$("button[type='submit']");


    public boolean isPageLoaded() {
        return pageForm.shouldBe(Condition.visible).exists();
    }

    public SearchPage enterAddress(String address) {
        addressInput.val(address);
        firstAddressSuggested.click();
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
}
