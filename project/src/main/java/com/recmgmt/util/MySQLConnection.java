package com.recmgmt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Dixit Patel
 */
public class MySQLConnection {

    public static final String DBURL= "jdbc:mysql://localhost/recmgmt?";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    private static Connection connect = null;

    public static Connection getConnection() throws SQLException {
        connect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        return connect;
    }
}
