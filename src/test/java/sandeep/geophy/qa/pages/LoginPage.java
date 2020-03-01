package sandeep.geophy.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage{

    SelenideElement
            username=$(By.id("email")),
            password=$(By.id("password")),
            submitButton=$("button[type='submit']"),
            forgotPasswordLink=$("a[href='https://evra.geophy.com/password/reset']"),
            signupLink=$("a[href='https://evra.geophy.com/signup']"),
            form=$("#form_login"),
            successAlert=$(".alert--success");

    public LoginPage visit() {
        open("login");
        return this;
    }

    public void enterUsername(String username)  {
        this.username.val(username);
    }

    public void enterPassword(String password)  {
        this.password.val(password);
    }

    public void submitForm() {
        this.submitButton.click();
    }

    public LoginPage login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.submitForm();
        return this;
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void clickSignupLink() {
        signupLink.click();
    }

    public boolean isPageDisplayed() {
        //TODO not very happy with this. Need to find an alternative
        form.shouldBe(Condition.visible);
        return true;
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }
}
