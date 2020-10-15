package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static utils.LogHelper.logStep;

public class platformLoginPage {

    public platformLoginPage(){}

    // Login Page Elements/locators

    public static By byEmail = By.id("userEmail");
    public static By byPassword = By.name("password");
    public static By bySubmit = By.xpath("//body/div[@id='angular-app']/div[@id='page-ctrl']/div[@id='cw-app_container']/section[1]/div[1]/div[1]/div[3]/form[1]/div[10]/button[1]");
    public static By byLoader = By.xpath("//h3[contains(text(),'DEPLOY YOUR MANAGED APPLICATION')]");
    // Methods

    public void enterCredentials(String userMail, String pwd) {
        logStep("User enters email and password");
        WebDriverFactory.getDriver().manage().deleteAllCookies();
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
        WebDriverFactory.getDriver().findElement(bySubmit).click();
        //WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

/*
   public void validateLogin(){
        logStep("Check if the user login successfully");
        String str = WebDriverFactory.getDriver().findElement(byLoader).getText();
        Assert.assertEquals(str,"DEPLOY YOUR MANAGED APPLICATION");
    }
*/

}
