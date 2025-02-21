package org.tuya.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/pruebasapi.feature",
        glue = "org.tuya.stepdefinitions", //steps
        plugin = "pretty",
        snippets = CucumberOptions.SnippetType.CAMELCASE//como se escriben los test
)

public class RunnerPruebaApi {
}
