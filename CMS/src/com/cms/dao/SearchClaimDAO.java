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

import com.cms.to.SearchClaimTO;

/**
 * @author Aeishwary Gupta
 *
 */
public class SearchClaimDAO {

	Connection connection = null;
	DataManager dataManager = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

/**
 * 
 */
public static final Logger LOGGER = Logger.getLogger(SearchClaimDAO.class);
	/**
	 * 
	 */
	public SearchClaimDAO() {
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

	/**
	 * @param searchclaimDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public boolean searchClaim(SearchClaimTO searchclaimDTO) throws DatabaseException {

		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(SELECTCLAIMDATA);
			preparedStatement.setString(1, searchclaimDTO.getMemberID());
			preparedStatement.setString(2, searchclaimDTO.getRequestDate());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				searchclaimDTO.setClaimId(resultSet.getString(1));
				searchclaimDTO.setMemberID(resultSet.getString(2));
				searchclaimDTO.setInsurancetypeId(resultSet.getString(3));
				searchclaimDTO.setClaimreason(resultSet.getString(4));
				searchclaimDTO.setDateofapproval(resultSet.getString(5));
				searchclaimDTO.setRequestDate(resultSet.getString(6));
				searchclaimDTO.setFinalclaimamount(resultSet.getInt(7));
				searchclaimDTO.setStatus(resultSet.getString(8));
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages("230"));
		}
		return status;
	}
}
