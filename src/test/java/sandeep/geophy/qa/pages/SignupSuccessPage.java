package sandeep.geophy.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

public class SignupSuccessPage {

    SelenideElement continueButton = $(".button--primary");

    public boolean isPageLoaded() {
        return WebDriverRunner.url().contains("signup-success");
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }
}
