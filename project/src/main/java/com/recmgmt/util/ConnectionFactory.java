package com.recmgmt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory = null;
	public static final String DBURL= "jdbc:mysql://localhost/recmgmt?";
	public static final String USERNAME = "root";
    public static final String PASSWORD = "macbook12";
    private static Connection connect = null;

    private ConnectionFactory() {
    	if (connect == null) {
    		try {
        		connect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        	} catch (SQLException ex) {
        		throw new RuntimeException("Error connecting to the database", ex);
        	}
    	}
    }
    
    public static ConnectionFactory getConnectionFactoryInstance() {
    	if(connectionFactory == null) {
    		connectionFactory = new ConnectionFactory();
    	}
    	return connectionFactory;
    }
    // method to create MySQL connection
    public Connection getConnection() {
    	return connect;
    }
}
