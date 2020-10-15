package PreReq;

import General.GenericFunctions;
import General.envGlobals;
import dbConnection.dbConn;

import java.sql.SQLException;

import static Config.configProperties.UserName;

public class RequestPayloads {
    public RequestPayloads(){}

    public static String saveAsSystem(String name, String randName, int systemId) throws SQLException
    {
        envGlobals.requestBody =
                "{\n" +
                        "    \"name\": \"" + randName + "\",\n" +
                        "    \"architecture\": {\n" +
                        "        \"id\": "  + 1 + ",\n" +
                        "        \"arch_id\": "  + 2 + ",\n" +
                        "        \"rows\": 64,\n" +
                        "        \"columns\": 44\n" +
                        "    },\n" +
                        "    \"user\": \"" + UserName + "\",\n" +
                        "    \"systemId\": " + systemId + ",\n" +
                        "    \"zcad_system_id\": " + 3 + ",\n" +
                        "    \"ult\": \"\",\n" +
                        "    \"is_sub_system\": false,\n" +
                        "    \"account_id\": 1\n" +
                        "}";

        return envGlobals.requestBody;
    }
}
