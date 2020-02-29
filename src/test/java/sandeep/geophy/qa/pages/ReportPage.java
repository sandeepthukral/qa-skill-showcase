package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReportPage {

    SelenideElement
            reportSection=$("section.report-section"),
            transactionPrice=$("h1[data-transaction-price]"),
            dataCapRate=$("h1[data-cap-rate]"),
            confidneceIndicator=$("#confidenceIndicator > span > div"),
            address=$("section.report-section h4"),
            numberOfUnits=$("section.report-section table tr", 0).find("td", 1),
            yearOfConstrution=$("section.report-section table tr", 1).find("td", 1);

    public boolean isPageLoaded(){
        // Using waitUntil because report generation can take longer than normal
        return reportSection
                .waitUntil(Condition.appear, 20000)
                .exists();
    }

    public String getValuation() {
        return this.transformTransactionPrice(transactionPrice.text());
    }

    public String getCapRate() {
        return dataCapRate.text();
    }

    private String transformTransactionPrice(String input) {
        String number = input.substring(2);
        String[] numbers = number.split(",");
        return String.join("", numbers);
    }

    public boolean isConfidenceIndicatorGreen() {
        return confidneceIndicator.getAttribute("class").contains("bg-green");
    }

    public String getAddress(){
        return address.innerText();
    }

    public String getYearOfConstruction() {
        return yearOfConstrution.innerText();
    }

    public String getNumberOfUnits() {
        return numberOfUnits.innerText();
    }

}
