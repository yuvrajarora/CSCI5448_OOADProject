import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements IUserDao{
	
    //private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<User> userList; 
    ConnectionFactory dbConnection;
    
    public UserDaoImpl() {
    	userList = new ArrayList<User>();
    	dbConnection = ConnectionFactory.getConnectionFactoryInstance();
    	
    }
    
	public void insertUser(User user) {
		Integer userID = user.getUserID();
	    String userName = user.getUserName(); 
	    String userPw = user.getUserPw();
	    String usrType = user.getUserType();
	    String address = user.getUserAddress();
	    String phoneNum = user.getPhoneNum();
	    String emailID  = user.getEmailID();
	    String trainerType = user.getTrainerSport();
	    
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("insert into  Rec_Center_Mgmt_System.User values ( ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, userID);
	        preparedStatement.setString(2, userName);
	        preparedStatement.setString(3, userPw);
	        preparedStatement.setString(4, usrType);
	        preparedStatement.setString(5, address);
	        preparedStatement.setString(6, phoneNum);
	        preparedStatement.setString(7, emailID);
	        preparedStatement.setString(8, trainerType);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(Integer userID) {
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("delete Rec_Center_Mgmt_System.User where userID = ( ?)");
			preparedStatement.setInt(1, userID);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		Integer userID = user.getUserID();
	    String userName = user.getUserName(); 
	    String userPw = user.getUserPw();
	    String usrType = user.getUserType();
	    String address = user.getUserAddress();
	    String phoneNum = user.getPhoneNum();
	    String emailID  = user.getEmailID();
	    String trainerType  = user.getTrainerSport();
	    
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("update Rec_Center_Mgmt_System.User set userID=?, userName=?, userPw=?, userType=?, address=?, phoneNum=?, email=?, trainerType=?");
			preparedStatement.setInt(1, userID);
	        preparedStatement.setString(2, userName);
	        preparedStatement.setString(3, userPw);
	        preparedStatement.setString(4, usrType);
	        preparedStatement.setString(5, address);
	        preparedStatement.setString(6, phoneNum);
	        preparedStatement.setString(7, emailID);
	        preparedStatement.setString(8, trainerType);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	
	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
	    User user = new User();
		user.setUserID(resultSet.getInt("userID"));
		user.setUserName(resultSet.getString("userName"));
		user.setUserPw(resultSet.getString("userPw"));
		user.setUserType(resultSet.getString("userType"));
		user.setUserAddress(resultSet.getString("address"));
		user.setPhoneNum(resultSet.getString("phoneNum"));
		user.setEmailID(resultSet.getString("email"));
		user.setTrainerSport(resultSet.getString("trainerType"));
	    return user;
	}
	
	public List<User> getUserDetails(Integer userID) {
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("select userName,userPw,userType,address,phoneNum,email,trainerType from Rec_Center_Mgmt_System.User where userID=?");
			preparedStatement.setInt(1, userID);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				User user = extractUserFromResultSet(resultSet);
				//Clear the list
				userList.clear();
				//Adding User to List
				userList.add(user);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
	  }
		return userList;
	}
	
	public List<User> getAllUsersOfType(String _usrType){
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("select userName,userPw,userType,address,phoneNum,email,trainerType from Rec_Center_Mgmt_System.User where userType=?");
			preparedStatement.setString(1, _usrType);
			resultSet = preparedStatement.executeQuery();
			
			//Clear the ArrayList
			userList.clear();
			while(resultSet.next()) {
				User user = extractUserFromResultSet(resultSet);
				//Adding User to List
				userList.add(user);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
	  }
		return userList;
	}
}
