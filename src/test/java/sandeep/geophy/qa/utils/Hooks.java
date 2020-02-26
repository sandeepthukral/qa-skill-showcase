package sandeep.geophy.qa.utils;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {
    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "build/surefire-reports";
    }
    @After
    public void tearDown() {
        closeWebDriver();
    }
}
