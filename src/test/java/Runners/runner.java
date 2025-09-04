package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"Steps"},
        plugin = {"pretty", "html:Reports/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true,

        publish = true
)

public class runner extends AbstractTestNGCucumberTests {
}
