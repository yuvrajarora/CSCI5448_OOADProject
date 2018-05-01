package com.recmgmt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Dixit Patel
 */
public class MySQLConnection {

    private static final String DBURL= "jdbc:mysql://localhost/recmgmt?";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection mysqlConnection = null;

    public static Connection getConnection() throws SQLException {
        mysqlConnection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        return mysqlConnection;
    }
}
