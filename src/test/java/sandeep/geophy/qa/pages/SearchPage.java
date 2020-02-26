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

    public void enterAddress() {
        addressInput.val("555 N. College Avenue, Tempe, AZ, 85281");
        firstAddressSuggested.click();
    }

    public void enterNOI() {
        noiInput.val("2000000");
    }

    public void enterNumberOfUnits() {
        numberOfUnitsInput.val("200");
    }

    public void enterYearOfConstruction() {
        yearBuiltInput.val("2000");
    }

    public void enterPercentageOccupancy(String percentage) {
        occupancyInput.val(percentage);
    }

    public void submitForm() {
        submitButton.click();
    }
}
