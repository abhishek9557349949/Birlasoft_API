package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String url = "jdbc:mysql://localhost:3306/hix_bms_data";
    private static final String user = "root";
    private static final String password = "#Bhushan2002";

    public static Connection getNewConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) throws SQLException{
        try{
            if(!connection.isClosed()){
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
