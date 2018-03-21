package com.recmgmt.dao;
import java.util.List;

public interface IUserDao {
    // all are the abstract methods.
	public void insertUser (User user);
	public void deleteUser(Integer userID);
	public void updateUser(User user);
	public List<User> getUserDetails(Integer userID);
	public List<User> getAllUsersOfType(String _usrType);
}