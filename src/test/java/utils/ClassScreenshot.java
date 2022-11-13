package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ClassScreenshot {

    public static void captureScreenshot(String StepName) {
        String data = ClassUtilities.GerarDataEHora().replace(":", "_").replace(" ", "_");

        File srcFile = ((TakesScreenshot) ClassDriver.GetInstance().Driver()).getScreenshotAs(OutputType.FILE);
        final String path = System.getProperty("user.dir");

        try {
            FileUtils.copyFile(srcFile, new File(path + "/src/screenshots/" + data + "_" + StepName + ".png"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}