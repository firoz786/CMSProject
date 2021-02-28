/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

import static com.cms.constants.DatabaseConstants.*;
import com.cms.util.PropertyUtil;
import java.sql.PreparedStatement;

/**
 *
 * @author Rishabh Gupta
 */
public class CheckEmailAddressDAO implements ICheckEmailAddress {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	ResultSet resultSet;
	PreparedStatement preparedStatement = null;
	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(CheckEmailAddressDAO.class);
	/**
	 * 
	 */
	public CheckEmailAddressDAO() {
		try {
			dataManager = DataManagerConnectionDAO.getDriverManager();
			connection = dataManager.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int isEmailAddressPresent(String emailAddress) throws DatabaseException {

		return checkEmailAddress(emailAddress);
	}

	private int checkEmailAddress(String emailAddress) throws DatabaseException {

		int statusValue = 0;
		String query = null;
		try {
			preparedStatement = connection.prepareStatement(GETEMAILADDRESS);
			preparedStatement.setString(1, emailAddress);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			statusValue = resultSet.getInt(1);

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
		}
		return statusValue;
	}

}
