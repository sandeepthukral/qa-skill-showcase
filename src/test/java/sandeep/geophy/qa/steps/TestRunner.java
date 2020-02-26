package sandeep.geophy.qa.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sandeep/geophy/qa/test/resources",
        glue = "",
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        stepNotifications = true)
public class TestRunner {
}