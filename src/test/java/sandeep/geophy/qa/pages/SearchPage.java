package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public boolean isPageLoaded() {
        $(By.cssSelector("form[action='https://evra.geophy.com/search']")).waitUntil(Condition.appear, 10000);
        return $(By.cssSelector("form[action='https://evra.geophy.com/search']")).exists();
    }

    public void enterAddress() {
        $(By.id("address_input")).val("555 N. College Avenue, Tempe, AZ, 85281");
        $(".pac-container > .pac-item", 0).waitUntil(Condition.visible, 2000);
        $(".pac-container > .pac-item", 0).click();
    }

    public void enterNOI() {
        $(By.id("noi")).val("2000000");
    }

    public void enterNumberOfUnits() {
        $(By.name("number_of_units")).val("200");
    }

    public void enterYearOfConstruction() {
        $(By.name("year_built")).val("2000");
    }

    public void enterPercentageOccupancy(String percentage) {
        $(By.name("occupancy")).val(percentage);
    }

    public void submitForm() {
        $("button[type='submit']").click();
    }
}
