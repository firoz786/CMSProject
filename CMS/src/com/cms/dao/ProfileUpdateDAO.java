/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import static com.cms.constants.DatabaseConstants.*;
import com.cms.exception.DatabaseException;
import com.cms.to.ProfileUpdateTO;
import com.cms.util.PropertyUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 *
 * @author Rishabh Gupta
 */
public class ProfileUpdateDAO implements IProfileUpdate {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(ProfileUpdateDAO.class);

	/**
	 * 
	 */
	public ProfileUpdateDAO() {
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
	public boolean updateProfile(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
		return updateMember(profileUpdateTO);
	}

	@Override
	public int isUpdatingFirstTimeProfile(ProfileUpdateTO profileUpdateVO) throws DatabaseException {
		return isFirstTimeUpdating(profileUpdateVO);
	}

	private int isFirstTimeUpdating(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
		int countValue = 0;
		try {
			preparedStatement = connection.prepareStatement(GETPROFILEUPDATES);
			preparedStatement.setString(1, profileUpdateTO.getMemberid());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			countValue = resultSet.getInt(1);

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages("230"));

		}
		return countValue;
	}

	private boolean updateMemberFirstTime(ProfileUpdateTO profileUpdateTO) {
		boolean status = false;
		try {

			preparedStatement = connection.prepareStatement(UPDATEFIRSTTIMEPROFILE);
			preparedStatement.setString(1, profileUpdateTO.getMemberid());
			preparedStatement.setString(2, profileUpdateTO.getFirstname());
			preparedStatement.setString(3, profileUpdateTO.getLastname());
			preparedStatement.setString(4, profileUpdateTO.getGender());
			preparedStatement.setString(5, profileUpdateTO.getDateofbirth());
			preparedStatement.setString(6, profileUpdateTO.getEmailaddress());
			preparedStatement.setString(7, profileUpdateTO.getContactnumber());
			preparedStatement.setString(8, profileUpdateTO.getAddress());
			preparedStatement.setString(9, profileUpdateTO.getZipcode());
			preparedStatement.setString(10, profileUpdateTO.getCity());
			preparedStatement.setString(11, profileUpdateTO.getState());
			preparedStatement.setString(12, profileUpdateTO.getInsuranceType());
			preparedStatement.setDouble(13, profileUpdateTO.getMaximumclaimableamount());
			preparedStatement.execute();
			status = true;
		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		}
		return status;

	}

	@Override
	public boolean updateFirstTimeProfile(ProfileUpdateTO profileUpdateVO) throws DatabaseException {
		return updateMemberFirstTime(profileUpdateVO);
	}

	private boolean updateMember(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
		boolean status = false;
		try {

			preparedStatement = connection.prepareStatement(UPDATEPROFILE);
			preparedStatement.setString(1, profileUpdateTO.getMemberid());
			preparedStatement.setString(2, profileUpdateTO.getFirstname());
			preparedStatement.setString(3, profileUpdateTO.getLastname());
			preparedStatement.setString(4, profileUpdateTO.getGender());
			preparedStatement.setString(5, profileUpdateTO.getDateofbirth());
			preparedStatement.setString(6, profileUpdateTO.getEmailaddress());
			preparedStatement.setString(7, profileUpdateTO.getContactnumber());
			preparedStatement.setString(8, profileUpdateTO.getAddress());
			preparedStatement.setString(9, profileUpdateTO.getZipcode());
			preparedStatement.setString(10, profileUpdateTO.getCity());
			preparedStatement.setString(11, profileUpdateTO.getState());
			preparedStatement.setString(12, profileUpdateTO.getInsuranceType());
			preparedStatement.setDouble(13, profileUpdateTO.getMaximumclaimableamount());
			preparedStatement.execute();
			status = true;

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages("230"));
		}
		return status;
	}

}
