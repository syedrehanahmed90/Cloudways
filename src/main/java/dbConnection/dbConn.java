package dbConnection;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Config.configProperties.*;
import static utils.LogHelper.logStep;

public class dbConn {
    //DB Credentials
    private static String url = dbUrl;
    private static String username = dbUsername;
    private static String password = dbPassword;

    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;
    private static String query = "";


    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // load postgresql driver
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static void dbConnection() {
        try {
            connectDb(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }

}

