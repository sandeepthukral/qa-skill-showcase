package sandeep.geophy.qa.runner;

import com.codeborne.selenide.junit.ScreenShooter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sandeep/geophy/qa/features",
        glue = "",
        plugin = {"de.monochromata.cucumber.report.PrettyReports:test-reports/cucumber"},
        strict = true
        )
public class TestRunner {
    @Rule
    public ScreenShooter makeScreenshotOnEveryTest = ScreenShooter.failedTests().succeededTests();
}