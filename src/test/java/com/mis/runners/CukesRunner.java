package com.mis.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                  "json:target/cucumber.json",
                  "html:target/default-html-reports.html",
        },
        features = "src/test/resources/features",
        glue = "com/mis/step_definitions",
        dryRun = false,
        tags = "@checkout"
)

public class CukesRunner {
}
