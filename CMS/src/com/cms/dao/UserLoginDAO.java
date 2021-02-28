package com.cms.dao;

import com.cms.util.PropertyUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cms.exception.DatabaseException;
import com.cms.to.UserTO;
import static com.cms.constants.DatabaseConstants.*;
import com.cms.to.ProfileUpdateTO;
import java.sql.PreparedStatement;

/**
 * @author Rishabh Gupta
 *
 */
public class UserLoginDAO implements IUser {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(UserLoginDAO.class);

	/**
	 * 
	 */
	public UserLoginDAO() {

		try {
			dataManager = DataManagerConnectionDAO.getDriverManager();
			connection = dataManager.getConnection();
			statement = connection.createStatement();

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		}

	}

	@Override
	public int isValidUser(UserTO userTO) throws DatabaseException {
		return checkValidUserMemberId(userTO);
	}

	@Override
	public int checkUserCredentials(UserTO userTO) throws DatabaseException {
		return checkValidUserPassword(userTO);
	}

	private int checkValidUserMemberId(UserTO userVO) throws DatabaseException {

		int loginCount = 0;
		String query = null;

		try {

			preparedStatement = connection.prepareStatement(GETUSERMEMBERID);
			preparedStatement.setString(1, userVO.getUserMemberID());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			loginCount = resultSet.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		}
		return loginCount;
	}

	private int checkValidUserPassword(UserTO userVO) throws DatabaseException {

		int loginCount = 0;
		String query = null;

		try {

			preparedStatement = connection.prepareStatement(GETUSERDETAILS);
			preparedStatement.setString(1, userVO.getUserMemberID());
			preparedStatement.setString(2, userVO.getUserPassword());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			loginCount = resultSet.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		}
		return loginCount;
	}

	@Override
	public boolean isProfileUpdates(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
		return checkProfileUpdate(profileUpdateTO);
	}

	private boolean checkProfileUpdate(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(GETPROFILEUPDATES);
			preparedStatement.setString(1, profileUpdateTO.getMemberid());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			profileUpdateTO.setZipcode(Integer.toString(resultSet.getInt(1)));
			status = true;
		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		}
		return status;
	}

}
