package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testRunner.TestRun;

public class CucumberHook extends TestRun {

    @After
    public void AfterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) utils.ClassDriver.GetInstance().Driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());

            utils.ClassDriver.QuitDriver();
        } else {
            utils.ClassDriver.QuitDriver();
        }
    }
}
