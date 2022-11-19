package stepDefinitions;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import testRunner.TestRun;

import static org.junit.Assert.assertTrue;

public class CucumberHook extends TestRun {

    @BeforeTest
    public void BeforeFeature(Feature feature) {

    }

    @After
    public void AfterMethod(Scenario scenario) {
        assertTrue(utils.ClassInfo.GetInstance().getLogMessage(), utils.ClassInfo.GetInstance().getResultScenario());

        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) utils.ClassDriver.GetInstance().Driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());

            utils.ClassDriver.QuitDriver();
        } else {
            utils.ClassDriver.QuitDriver();
        }
    }
}