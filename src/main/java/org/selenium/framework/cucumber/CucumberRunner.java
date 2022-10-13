package org.selenium.framework.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"org.selenium.framework.stepdefinitions"},
        features = {"src/test/resources/features"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "junit:target/junitreports.xml",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber/cucumber.json"
        },

        monochrome = true

)
public class CucumberRunner {
}
