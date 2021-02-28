package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

import static com.cms.constants.DatabaseConstants.*;

import com.cms.exception.DatabaseException;
import com.cms.to.ClaimProcessTO;
import com.cms.util.PropertyUtil;

/**
 * @author Aeishwary Gupta
 *
 */
public class ClaimProcessDAO {

	private Connection connection = null;
	private DataManager dataManager = null;
	private Statement statement = null;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement = null;
	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(ClaimProcessDAO.class);
	/**
	 * 
	 */
	public ClaimProcessDAO() {
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
	 * @param claimprocessDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public boolean processClaim(ClaimProcessTO claimprocessDTO) throws DatabaseException {

		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(GETPROCESSCLAIMDATA);
			preparedStatement.setString(1, claimprocessDTO.getMemberID());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			claimprocessDTO.setClaimId(resultSet.getString(1));
			claimprocessDTO.setMemberID(resultSet.getString(2));
			claimprocessDTO.setInsurancetypeId(resultSet.getString(3));
			claimprocessDTO.setClaimreason(resultSet.getString(4));
			claimprocessDTO.setDateofapproval(resultSet.getString(6));
			claimprocessDTO.setRequestDate(resultSet.getString(5));
			claimprocessDTO.setFinalclaimamount(Integer.parseInt(resultSet.getString(7)));
			claimprocessDTO.setStatus(resultSet.getString(8));
			status = true;

		} catch (SQLException e) {
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages(""));

		}
		return status;
	}

	/**
	 * @param claimProcessDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public boolean updatestatus(ClaimProcessTO claimProcessDTO) throws DatabaseException {

		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(UPDATESTATUS);
			preparedStatement.setString(1, claimProcessDTO.getStatus());
			preparedStatement.setString(2, claimProcessDTO.getClaimId());
			preparedStatement.execute();
			status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
			throw new DatabaseException(PropertyUtil.getCMSMessages(""));
		}
		return status;
	}

}
