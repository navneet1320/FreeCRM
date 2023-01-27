package Runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\QA\\Selenium_Workspace\\FreeCRMBDDFramework\\src\\main\\java\\Features\\deals.feature"
		,glue= {"stepDefinitions"},
		dryRun = false
	//	tags = {"@SmokeTest","@SanityTest"}//AND tag
		//tags = {"@SmokeTest , @SanityTest"}// OR tag
		//tags = {"~@SmokeTest" , "@SanityTest"} // ignore tag
        // OR :tags ={"@SmokeTest , @RegressionTest"} --execute all tests tagged  as @smoketest or @regressiontest
 
		
		)

public class TestRunner {

}
