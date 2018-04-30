package com.recmgmt.daoImpl;

import com.recmgmt.model.Court;
import com.recmgmt.util.CommonDataUtil;
import com.recmgmt.util.DatabaseFactory;
import com.recmgmt.dao.ICourtDao;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CourtDaoImpl implements ICourtDao {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<Court> courtList;
    Connection dbConnection;
    
    public CourtDaoImpl() {
    	courtList = new ArrayList<Court>();
    	dbConnection = DatabaseFactory.getConnection(CommonDataUtil.DatabaseType.MySQL);
    	
    }
	public void insertCourt(Court crt) {
		int courtID = crt.getCourtID();
		String name = crt.getName();
		String resType = crt.getResType();
		try {
			preparedStatement = dbConnection
					.prepareStatement("insert into  Rec_Center_Mgmt_System.Court values ( ?, ?, ?)");
			preparedStatement.setInt(1, courtID);
	        preparedStatement.setString(2, name);
	        preparedStatement.setString(3, resType);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteCourt(int courtID) {
		try {
			preparedStatement = dbConnection
					.prepareStatement("delete Rec_Center_Mgmt_System.Court where courtID = ( ?)");
			preparedStatement.setInt(1, courtID);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private Court extractUserFromResultSet(ResultSet rs) throws SQLException {
	    Court crt = new Court();
	    crt.setCourtID(resultSet.getInt("courtID"));
	    crt.setName(resultSet.getString("courtName"));
		crt.setResType(resultSet.getString("courtType"));
	    return crt;
	}
	public List<Court> fetchCourts(){
		try {
			preparedStatement = dbConnection
					.prepareStatement("select courtID,name,resType from Rec_Center_Mgmt_System.Court");
			resultSet = preparedStatement.executeQuery();
			
			//Clear the ArrayList
			courtList.clear();
			while(resultSet.next()) {
				Court crt = extractUserFromResultSet(resultSet);
				//Adding Court to List
				courtList.add(crt);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return courtList;

	}

}
