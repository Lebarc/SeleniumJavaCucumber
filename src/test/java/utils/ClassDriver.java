package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ClassDriver {
    private static ClassDriver classDriver;
    private static WebDriver driver;

    public WebDriver Driver() {
        return driver;
    }

    public static ClassDriver GetInstance() {
        if (classDriver == null) {
            classDriver = new ClassDriver();
        }
        return classDriver;
    }

    public static void StartDriver() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Galaxy S5");

        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver.exe");

            //Options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--window-size=1366,768");
            options.addArguments("no-sandbox");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            //options.addArguments("headless");

            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver");

            //Options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("no-sandbox");
            //options.addArguments("headless");
            //options.setExperimentalOption("mobileEmulation", mobileEmulation);

            driver = new ChromeDriver(options);
        }
    }

    public static void QuitDriver() {
        driver.close();
    }
}
