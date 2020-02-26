package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class PasswordResetPage {
    public boolean isPageLoaded() {
        return $("form[action='https://evra.geophy.com/password/email']")
                .shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return $("form[action='https://evra.geophy.com/password/email']").isDisplayed();
    }
}
