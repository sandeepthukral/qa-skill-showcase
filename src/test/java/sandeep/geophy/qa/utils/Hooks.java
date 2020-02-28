package sandeep.geophy.qa.utils;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sandeep.geophy.qa.TestBase;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks extends TestBase {

    @BeforeEach
    void setUpEach() {
        if (REMOTE_DRIVER) {
            Configuration.driverManagerEnabled = false;
            Configuration.remote = "http://localhost:4444/wd/hub";
        }
    }

    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "build/surefire-reports";

    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            WebDriver driver = getWebDriver();
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "Failure Screenshot");
        }
        closeWebDriver();
    }
}
