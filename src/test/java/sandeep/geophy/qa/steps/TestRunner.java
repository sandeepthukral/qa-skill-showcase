package sandeep.geophy.qa.steps;

import com.codeborne.selenide.junit.ScreenShooter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sandeep/geophy/qa/test/resources",
        glue = "",
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        strict = true
        )
public class TestRunner {
    @Rule
    public ScreenShooter makeScreenshotOnEveryTest = ScreenShooter.failedTests().succeededTests();
}