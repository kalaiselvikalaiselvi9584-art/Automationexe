package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources",
		glue ="com.flipkartstepdefinition",
		plugin= {
				"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

				
		},
		monochrome=true,
		tags = "@Homepage or @samsung",
		dryRun=false
		
		)



public class TestRunner {
	

}
