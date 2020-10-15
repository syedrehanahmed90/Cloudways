package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import General.envGlobals;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class platFormLoginTest extends baseTest {

    @Test(description = "Test the Login Flow")
    public static void loginPlatform() throws InterruptedException {
        logStep("User is logged in successfully");
        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MainCall.PLATFORM_LOGIN_PAGE.enterCredentials(envGlobals.email, envGlobals.password);
        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //MainCall.PLATFORM_LOGIN_PAGE.validateLogin();
        String str = WebDriverFactory.getDriver().findElement(By.xpath("//h1/span")).getText();
        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(str,"SERVERS");
    }
}
