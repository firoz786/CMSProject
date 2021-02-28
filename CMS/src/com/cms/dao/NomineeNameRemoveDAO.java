/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import static com.cms.constants.DatabaseConstants.*;
import com.cms.exception.DatabaseException;
import com.cms.to.NomineeNameRemovalTO;
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
public class NomineeNameRemoveDAO implements INomineeNameRemoveDAO {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(NomineeNameRemoveDAO.class);

	/**
	 * 
	 */
	public NomineeNameRemoveDAO() {
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
	public boolean removeNomineeName(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException {
		return removeNominee(nameRemovalTO);

	}

	private boolean removeNominee(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException {
		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(GETINSURANCETYPEID);
			preparedStatement.setString(1, nameRemovalTO.getInsuranceType());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int insuranceTypeid = resultSet.getInt(1);
			preparedStatement = connection.prepareStatement(ISNOMINEEPRESENT);
			preparedStatement.setString(1, nameRemovalTO.getMemberid());
			preparedStatement.setInt(2, insuranceTypeid);
			preparedStatement.setString(3, nameRemovalTO.getNomineeName());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int count = resultSet.getInt(1);
			if (count != 0) {
				preparedStatement = connection.prepareStatement(REMOVENOMINEE);
				preparedStatement.setString(1, nameRemovalTO.getMemberid());
				preparedStatement.setInt(2, insuranceTypeid);
				preparedStatement.setString(3, nameRemovalTO.getNomineeName());
				preparedStatement.executeQuery();
				status = true;
			} else {
				throw new DatabaseException(PropertyUtil.getCMSMessages("160"));
			}

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages("230"));
		}
		return status;

	}
}