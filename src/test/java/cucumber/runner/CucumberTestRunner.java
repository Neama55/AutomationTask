package cucumber.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featuresFiles/ItemsHomePage.feature"},
        glue = {
                "cucumber.stepdefs",
                "cucumber.hooks"
        },

       plugin={
                "json:target/reports/cucumber/cucumber.json",
               "html:target/reports/cucumber/cucumber.html"
       }
)
public class CucumberTestRunner {

}