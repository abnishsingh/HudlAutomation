package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"stepdefs"},
        monochrome = true,
        tags = "@login",
        plugin = {"json:target/cucumber-report-composite.json", "pretty", "html:target/cucumber/",
        "rerun: target/rerun.txt" }
)
public class TestRunner {
}
