/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import static com.cms.constants.DatabaseConstants.*;
import com.cms.exception.DatabaseException;
import com.cms.to.JSPProfileUpdateTO;
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
public class RequestMaximumAmountDAO implements IRequestMaximumAmountDAO {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(RequestMaximumAmountDAO.class);

	/**
	 * 
	 */
	public RequestMaximumAmountDAO() {
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
	public boolean getAmount(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
		return getMaximumAmount(jSPProfileUpdateTO);
	}

	private boolean getMaximumAmount(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(GETMAXIMUMCLAIMABLEAMOUNT);
			preparedStatement.setString(1, jSPProfileUpdateTO.getMemberID());
			preparedStatement.setString(2, jSPProfileUpdateTO.getInsuranceType());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				jSPProfileUpdateTO.setMaximumClaimableAmount(resultSet.getDouble(1));
				status = true;
			}
		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages("230"));

		}
		return status;
	}

}
