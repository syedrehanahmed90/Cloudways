package General;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.Url;
import static General.GenericFunctions.generateAlphaNumeric;
import static General.GenericFunctions.generateRandomString;

public class envGlobals {

    public static StringBuilder Differnce = new StringBuilder() ;
    public static RequestSpecification requestSpecification;
    public static Response response;
    public static String requestBody = "";

    public static String memberEmail = "testmember"+generateRandomString(3)+"@test.com";
    public static String name = "Team Member 1";
    public static String email = "syedrehanahmed90@gmail.com";
    public static String password = "Rehan123@";
    public static String company = "";
}
