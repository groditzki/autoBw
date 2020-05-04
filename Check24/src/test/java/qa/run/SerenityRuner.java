package qa.run;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

        @RunWith(CucumberWithSerenity.class)
        @CucumberOptions(
                plugin = {"pretty"}
                ,features="src/test/resources"
                ,glue = {"qa.run.steps"}
                ,tags = {"@active"}
                )

public class SerenityRuner {

}
