package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static Config.configProperties.*;

public class WebDriverFactory {
    static WebDriver driver;
    static String device = Device; // Change to windows or mac accordingly
    static Boolean headless = Boolean.valueOf(Headless);
    //D:\Objectives\web-automation-framework\driver
    static String chromeDriverPath = device.equals("Windows") ? "driver/chromedriver.exe" : "driver/chromedriver.exe";
    static String geckoDriverPath = device.equals("Windows") ? "driver/geckodriver.exe" : "driver/geckodriver";
    //static String UbuntuChromDriverPath = device.equals("Ubuntu") ? "driver/UbuntuChromedriver" : "driver/chromedriver";
    public static Actions action;
    public static Robot robot;

    public static WebDriver getInstance() throws AWTException {

        ChromeOptions op = new ChromeOptions();
        if (device.equals("Windows")) {
            op.addArguments("--start-maximized");
        }

        else {
            op.addArguments("start-fullscreen");
        }

        if(headless)
            op.addArguments("--headless");

        op.addExtensions(new File("chromeappExtension/chromeapp.crx"));

        switch (Browser)
        {
            case "Chrome":
                //if (device.equals("Windows"))
                //{
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver(op);
                    break;
                //}
                /*else if (device.equals("Ubuntu"))

                {
                    System.setProperty("webdriver.chrome.driver", UbuntuChromDriverPath);
                    driver = new ChromeDriver(op);
                    break;
                }*/
         /*   case "IE":
                driver = new InternetExplorerDriver();
                break;*/
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                driver = new FirefoxDriver();
                break;
        }

        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        action = new Actions(driver);
        robot = new Robot();

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else
        {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static void finishDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
