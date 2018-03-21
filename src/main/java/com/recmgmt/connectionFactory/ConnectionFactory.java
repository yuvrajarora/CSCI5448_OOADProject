import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String DBURL= "jdbc:mysql://localhost/Rec_Center_Mgmt_System?";
	public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    private static Connection connect = null;

    // method to create MySQL connection
    public static Connection getConnection() {
    	try {
    		connect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
    		return connect;
    	} catch (SQLException ex) {
    		throw new RuntimeException("Error connecting to the database", ex);
    	}
    }
}
