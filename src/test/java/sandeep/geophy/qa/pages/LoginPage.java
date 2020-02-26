package sandeep.geophy.qa.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public void visit() {
        open("https://evra.geophy.com/login");
    }
    public void enterUsername(String username)  {
        $(By.id("email")).val(username);
    }

    public void enterPassword(String password)  {
        $(By.id("password")).val(password);
    }

    public void submitForm() {
        $(By.cssSelector("button[type='submit']")).click();
    }

    public void login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.submitForm();
    }

    public void clickForgotPasswordLink() {
        $("a[href='https://evra.geophy.com/password/reset']").click();
    }

    public void clickSignupLink() {
        $("a[href='https://evra.geophy.com/signup']").click();
    }
}
