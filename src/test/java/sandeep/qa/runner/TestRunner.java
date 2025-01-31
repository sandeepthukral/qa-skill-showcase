package sandeep.qa.runner;

import com.codeborne.selenide.junit.ScreenShooter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sandeep/qa/features",
        glue = "",
        plugin = {"pretty",
                "de.monochromata.cucumber.report.PrettyReports:test-reports/cucumber",
                "rerun:test-reports/rerun.txt"},
        strict = true
        )
public class TestRunner {
    @Rule
    public ScreenShooter makeScreenshotOnEveryTest = ScreenShooter.failedTests().succeededTests();
}