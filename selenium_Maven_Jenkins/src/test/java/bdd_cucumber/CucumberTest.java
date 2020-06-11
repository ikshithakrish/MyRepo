package bdd_cucumber;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

@CucumberOptions(
		features="src/test/resources/feature_cucumber/REGISTRATION", 
		glue= {"step_def_REGISTRATION"}, 
		tags= {"@registration"}
		)

public class CucumberTest {
	TestNGCucumberRunner cucumberRunner;
	
  @Test(dataProvider = "dp")
  public void test(CucumberFeatureWrapper cucumberFeature) {
	  cucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
  }

  @DataProvider
  public Object[][] dp() {
     return cucumberRunner.provideFeatures();
  }
  @BeforeClass
  public void beforeClass() {
	  cucumberRunner = new TestNGCucumberRunner(CucumberTest.class);
  }

  @AfterClass
  public void afterClass() {
	  cucumberRunner.finish();
  }

}

