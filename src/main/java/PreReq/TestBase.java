package PreReq;

import General.GenericFunctions;
import General.envGlobals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestBase {
    public TestBase(){}

    static int sysCount = 7;
    static  List<Integer> randList = new ArrayList<>();
    static  List<String> sysNames = new ArrayList<>();
    static  List<Integer> sysId = new ArrayList<>();


    public static void setup() throws SQLException {
        randList = GenericFunctions.generateRandomNumSystem(5, sysCount);
        String name = "";

        TestPage.getSystems();

        data();

        for (int i=0 ; i<sysCount ; i++) {
            name = "AutoSystem" + i;
            sysNames.add(name + "_" + randList.get(i));

            TestPage.saveAsSystems(name, sysNames.get(i), sysId.get(i));
        }
    }

    public static void data(){
        String name = "";
        int systemsSize = envGlobals.response.body().path("systems.size()");

        for (int i=0 ; i<systemsSize ; i++) {
            name = envGlobals.response.body().path("systems[" + i + "].name");

            for (int j=0 ; j<sysCount ; j++) {
                if (name.equals("AutoSystem" + j)){
                    sysId.add(envGlobals.response.body().path("systems["+ i +"].id"));
                    break;
                }
            }
        }
    }
}
