package General;

import Objects.*;
import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;
import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;


    public static ExtentReports startReport()
    {
        //ExtentReports(String filePath,Boolean replaceExisting)
        //filepath - path of the file, in .htm or .html format - path where your report needs to generate.
        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);

        //extent.addSystemInfo("Environment","Environment Name")
        extent.addSystemInfo("Environment", Environment);

        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));

        return extent;
    }

    public static ExtentReports getExtentReport()
    {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }


    public final static commonLocators commonLocators = new commonLocators();
    public final static platformLoginPage PLATFORM_LOGIN_PAGE = new platformLoginPage();
    public final static TeamPage TEAM_PAGE = new TeamPage();

}
