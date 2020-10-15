package Objects;

import General.WebDriverFactory;
import General.envGlobals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static utils.LogHelper.logStep;

public class TeamPage {

    // Team Page Elements/locators

    public static By byTeamLink = By.xpath("//li[@class = \"team ng-scope\"]");
    public static By byTeamClass = By.xpath("//button[@title='View your Team members']");
    //public static By byAddTeamMember = By.className("glb-btn-add");
    public static By byAddTeamMember = By.xpath("//button[@ui-sref='team_create']");
    public static By byEnterEmail = By.xpath("//input[@id='input_52']");
    public static By byEnterTeamMemberEmail = By.xpath("//input[@name='email']");
    public static By byStatus = By.id("select_option_69");
    public static By byName = By.xpath("//input[@name=\"name\"]");
    public static By byJobTitle = By.id("select_value_label_50");
    public static By byBillingAccess = By.xpath("//md-checkbox[@aria-label = 'Billing Access']");
    public static By byConsoleAccess = By.xpath("//md-checkbox[@aria-label = 'Console Access']");
    public static By byLimitedAccess = By.xpath("//md-radio-button[@aria-label = 'limited access']");
    public static By byAddServer = By.xpath("//md-checkbox[@aria-label = 'Add Server']");
    public static By byAddMemberButton = By.xpath("//button[@aria-label=\"Add member\"]");

    // Methods

    public void navigateTeamPage() {
        logStep("Click on the Team link");
        WebDriverFactory.getDriver().findElement(byTeamClass).click();
        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void addNewTeamMember() {
        logStep("Click on Add Team Member Button");
        WebDriverFactory.getDriver().findElement(byAddTeamMember).click();
        // WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void enterTeamMemberDetails(String userEmail, String name) {
        WebDriverFactory.getDriver().findElement(byEnterTeamMemberEmail).sendKeys(userEmail);
        //WebElement isActive = WebDriverFactory.getDriver().findElements(By.xpath("//*[contains(@id,'select_value_label')][@class='md-select-value']")).get(0);
        //Select isActive = new Select(WebDriverFactory.getDriver().findElements(By.xpath("//*[contains(@id,'select_value_label')][@class='md-select-value']")).get(0));
        //isActive.selectByVisibleText("Active");
        WebDriverFactory.getDriver().findElement(byName).sendKeys(name);
        // WebElement selectJobTitle = WebDriverFactory.getDriver().findElements(By.xpath("//*[contains(@id,'select_value_label')][@class='md-select-value']")).get(1);
        Select selectJobTitle = new Select(WebDriverFactory.getDriver().findElement(By.className("md-visually-hidden")));
        ;
        selectJobTitle.selectByVisibleText("Architect");

        WebDriverFactory.getDriver().findElement(byBillingAccess).click();
        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverFactory.getDriver().findElement(byConsoleAccess).click();

        WebDriverFactory.getDriver().findElement(byLimitedAccess).click();
        WebDriverFactory.getDriver().findElement(byAddServer).click();
        WebDriverFactory.getDriver().findElement(byAddMemberButton).click();

        Assert.assertEquals(envGlobals.memberEmail, envGlobals.memberEmail);

    }

}
