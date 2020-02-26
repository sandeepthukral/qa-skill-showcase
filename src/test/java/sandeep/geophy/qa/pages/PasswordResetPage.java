package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PasswordResetPage {

    SelenideElement
            pageForm=$("form[action='https://evra.geophy.com/password/email']"),
            emailInput=$("form[action='https://evra.geophy.com/password/email']");

    public boolean isPageLoaded() {
        return pageForm.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isEmailInputDisplayed() {
        return emailInput.isDisplayed();
    }
}
