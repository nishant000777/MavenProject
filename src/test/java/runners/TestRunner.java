package runners;

import VOXIBrowser.ExcelHandler;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/Feature/",
        glue = {"StepDefination"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-reports/CucumberTestReport.json", "io.qameta.allure.cucumberjvm.AllureCucumberJvm"})

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
public class TestRunner extends ExcelHandler {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {

        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}