package com.thor.demo.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {


    public static Connection getConnection() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=projects;user=james;password=123;encrypt=true;trustServerCertificate=true;")) {
            String connectionResult = "SQL Connected";
            System.out.println(connectionResult);
            return connection;


        } catch (SQLException e) {
            String connectionResult = "Connection Failed";
            System.out.println(connectionResult);

        }
        return null;
    }

}
