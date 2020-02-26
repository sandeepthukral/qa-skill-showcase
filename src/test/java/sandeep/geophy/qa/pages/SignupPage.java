package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class SignupPage {

    public boolean isPageLoaded() {
        return $("form#form_signup").shouldBe(Condition.visible).exists();
    }
}
