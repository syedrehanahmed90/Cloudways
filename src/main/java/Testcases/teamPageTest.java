package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import General.envGlobals;
import org.testng.Assert;
import org.testng.annotations.Test;



public class teamPageTest extends baseTest {


    @Test(description = "Navigate to Team Page")
    public static void navigateTeamPage() {
        logStep("User is navigated successfully");
        MainCall.TEAM_PAGE.navigateTeamPage();
    }

    @Test(description = "Navigate to Team Page")
    public static void enterDetailsOnTeamPage() {
        logStep("Enter Team Members details");
        MainCall.TEAM_PAGE.addNewTeamMember();
        MainCall.TEAM_PAGE.enterTeamMemberDetails(envGlobals.memberEmail, envGlobals.name);
    }

}
