/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;
import static com.cms.constants.DatabaseConstants.*;
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
public class JSPProfileUpdateDAO implements IJSPProfileUpdateDAO {

    Connection connection = null;
    DataManager dataManager = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    /**
     * 
     */
    public static final Logger LOGGER = Logger.getLogger(JSPProfileUpdateDAO.class);

    /**
     * 
     */
    public JSPProfileUpdateDAO() {
        try {
            dataManager = DataManagerConnectionDAO.getDriverManager();
            connection = dataManager.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        }

    }

    @Override
    public boolean getProfileUpdateCredentials(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        boolean status = false;
        status = getCredentials(jSPProfileUpdateTO);
        if (status) {
            status = getInsuranceDetails(jSPProfileUpdateTO);
        }
     
        return status;
    }

    private boolean getCredentials(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {

        boolean status = false;
        try {
            preparedStatement = connection.prepareStatement(GETJSPQUERYWITHMEMBERID);
            preparedStatement.setString(1, jSPProfileUpdateTO.getMemberID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                jSPProfileUpdateTO.setFirstname(resultSet.getString(1));
                jSPProfileUpdateTO.setLastname(resultSet.getString(2));
                jSPProfileUpdateTO.setDateofbirth(resultSet.getString(3));
                jSPProfileUpdateTO.setContactnumber(resultSet.getString(4));
                jSPProfileUpdateTO.setEmailaddress(resultSet.getString(5));
                jSPProfileUpdateTO.setGender(resultSet.getString(6));
                jSPProfileUpdateTO.setAddress(resultSet.getString(7));
                jSPProfileUpdateTO.setCity(resultSet.getString(8));
                jSPProfileUpdateTO.setState(resultSet.getString(9));
                jSPProfileUpdateTO.setZipcode(resultSet.getString(10));
            }

            status = true;
        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
            throw new DatabaseException(PropertyUtil.getCMSMessages("230"));

        }
        return status;
    }

    private boolean getInsuranceDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        boolean status = false;
  
        try {
            preparedStatement = connection.prepareStatement(GETINSURANCETYPES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jSPProfileUpdateTO.putInsuranceTypeValue(resultSet.getString(1), resultSet.getDouble(2));
            }
       
            status = true;
        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
            throw new DatabaseException(PropertyUtil.getCMSMessages("230"));

        }
        return status;
    }
}
