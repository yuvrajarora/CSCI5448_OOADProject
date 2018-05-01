package com.recmgmt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFactory {
	private static DatabaseFactory databaseFactory = null;

    private static Connection connect = null;
    private DatabaseFactory(CommonDataUtil.DatabaseType type) {
    	if (connect == null) {
    		if(type == CommonDataUtil.DatabaseType.MySQL) {
				try {
					connect = getMySQLConnection();
				} catch (SQLException ex) {
					throw new RuntimeException("Error connecting to the database", ex);
				}
			}
    	}
    }

    private static Connection getMySQLConnection() throws SQLException {
    	return MySQLConnection.getConnection();
	}
    public static Connection getConnection(CommonDataUtil.DatabaseType type) {
    		if(databaseFactory == null) {
    			databaseFactory = new DatabaseFactory(type);
    		}
		return getConnection();
    }

    private static Connection getConnection() {
    	return connect;
    }
}
