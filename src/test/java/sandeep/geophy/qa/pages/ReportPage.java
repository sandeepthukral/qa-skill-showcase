package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ReportPage {
    public boolean isPageLoaded(){
        // Using waitUntil because report generation can take longer than normal
        return $("section.report-section")
                .waitUntil(Condition.appear, 10000)
                .exists();
    }

    public String getValuation() {
        return this.transformTransactionPrice($("h1[data-transaction-price]").text());
    }

    public String getCapRate() {
        return $("h1[data-cap-rate]").text();
    }

    private String transformTransactionPrice(String input) {
        String number = input.substring(2);
        String[] numbers = number.split(",");
        return String.join("", numbers);
    }
}
