package testRunner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions
(

		features=".//Features",
		glue="stepDefinitions",
		dryRun= false

		)
public class TestRun extends AbstractTestNGCucumberTests{

}
