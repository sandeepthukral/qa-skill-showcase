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

    public void enterAddress(String address) {
        addressInput.val(address);
        firstAddressSuggested.click();
    }

    public void enterNOI(String noi) {
        noiInput.val(noi);
    }

    public void enterNumberOfUnits(String no_of_units) {
        numberOfUnitsInput.val(no_of_units);
    }

    public void enterYearOfConstruction(String year) {
        yearBuiltInput.val(year);
    }

    public void enterPercentageOccupancy(String percentage) {
        occupancyInput.val(percentage);
    }

    public void submitForm() {
        submitButton.click();
    }
}
