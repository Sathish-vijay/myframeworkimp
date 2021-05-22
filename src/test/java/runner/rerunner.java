package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failedrerun.txt",
                 glue = {"classpath:com/aeroweb/stepdefination","classpath:com/aeroweb/runner"} ,
                 plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json",
                		 "json:target/jsonReports/cucumber-report.json",
                		 "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json","rerun:target/failedrerun.txt" },
                //tags ={"@target/failedrerun.txt"} ,
                dryRun=false

                )
public class rerunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
          return super.scenarios();
    }

}
