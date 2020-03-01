package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selenide.$;

public class PasswordResetPage {

    SelenideElement
            pageForm=$("form[action='https://evra.geophy.com/password/email']"),
            emailInput=$("input#email"),
            submitButton=$("button[type='submit']");

    public boolean isPageLoaded() {
        return pageForm.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isEmailInputDisplayed() {
        return emailInput.isDisplayed();
    }

    public void visit() {
        open("password/reset");
    }

    public PasswordResetPage enterEmailAddress(String email) {
        emailInput.val(email);
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
