/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import static com.cms.constants.DatabaseConstants.*;
import com.cms.exception.DatabaseException;
import com.cms.to.NomineeAdditionTO;
import com.cms.util.PropertyUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 * @author Rishabh Gupta
 *
 */
public class NomineeAdditionDAO implements INomineeAdditionDAO {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(NomineeAdditionDAO.class);

	/**
	 * 
	 */
	public NomineeAdditionDAO() {
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
	public boolean addNominee(NomineeAdditionTO nomineeAdditionTO) throws DatabaseException {
		return addNomineeName(nomineeAdditionTO);
	}

	private boolean addNomineeName(NomineeAdditionTO nomineeAdditionTO) throws DatabaseException {
		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(GETINSURANCETYPEID);
			preparedStatement.setString(1, nomineeAdditionTO.getInsuranceType());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int insuranceTypeId = resultSet.getInt(1);
			preparedStatement = connection.prepareStatement(GETMEMBERFROMMEMBERINSURANCETYPE);
			preparedStatement.setString(1, nomineeAdditionTO.getMemberid());
			preparedStatement.setInt(2, insuranceTypeId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int countMemberClaim = resultSet.getInt(1);
			if (countMemberClaim == 0) {

				throw new DatabaseException(PropertyUtil.getCMSMessages("162"));
			}

			preparedStatement = connection.prepareStatement(GETMEMBERNOMINEECOUNT);
			preparedStatement.setString(1, nomineeAdditionTO.getMemberid());
			preparedStatement.setInt(2, insuranceTypeId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int count = resultSet.getInt(1);
			if (count != 3) {
				preparedStatement = connection.prepareStatement(INSERTNOMINEENAME);
				preparedStatement.setInt(1, insuranceTypeId);
				preparedStatement.setString(2, nomineeAdditionTO.getMemberid());
				preparedStatement.setString(3, nomineeAdditionTO.getNomineeName());
				preparedStatement.execute();
				status = true;
			} else {
				throw new DatabaseException(PropertyUtil.getCMSMessages("150"));
			}

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages("230"));
		}
		return status;
	}

}
