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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 *
 * @author Rishabh Gupta
 */
public class RequestClaimDAO {

    Connection connection = null;
    DataManager dataManager = null;
    Statement statement = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;

/**
 * 
 */
public static final Logger LOGGER = Logger.getLogger(RequestClaimDAO.class);
    /**
     * 
     */
    public RequestClaimDAO() {
        try {
            dataManager =  DataManagerConnectionDAO.getDriverManager();
            connection = dataManager.getConnection();
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean getDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {

        boolean status = false;
        
        try {
            callableStatement = connection.prepareCall(REQUESTCLAIM);
            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
            callableStatement.setString(2, jSPProfileUpdateTO.getMemberID());
            callableStatement.setString(3, jSPProfileUpdateTO.getInsuranceType());
            callableStatement.setString(4, jSPProfileUpdateTO.getSubInsuranceType());
            callableStatement.setString(5, jSPProfileUpdateTO.getDateofbirth());
            callableStatement.setString(6, jSPProfileUpdateTO.getDateofapproval());
            callableStatement.setDouble(7, jSPProfileUpdateTO.getFinalClaimableAmount());
            callableStatement.setString(8, "pending");
            callableStatement.execute();
            jSPProfileUpdateTO.setClaimiID(callableStatement.getString(1));
            
            status = true;
        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
            throw new DatabaseException(PropertyUtil.getCMSMessages("230"));
        }
        return status;
    }
}
