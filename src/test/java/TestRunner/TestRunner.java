package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"AllFeatureFile"},
		glue= {"StepDefination"},
		dryRun=false
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
