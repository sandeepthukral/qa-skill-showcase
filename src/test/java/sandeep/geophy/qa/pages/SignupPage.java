package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignupPage {

    SelenideElement firstName = $("#first-name"),
            lastName = $("#last-name"),
            email = $("#email"),
            password = $("input[type='password']"),
            checkBox = $(".checkmark"),
            submitButtom = $("button[type='submit']");

    public boolean isPageLoaded() {
        return $("form#form_signup").shouldBe(Condition.visible).exists();
    }

    public SignupPage visit() {
        open("signup");
        return this;
    }

    public void submitFormWithData(String firstName, String lastName, String email, String password) {
        this.firstName.val(firstName);
        this.lastName.val(lastName);
        this.email.val(email);
        this.password.val(password);
        this.checkBox.click();
        this.submitButtom.click();
    }
}
