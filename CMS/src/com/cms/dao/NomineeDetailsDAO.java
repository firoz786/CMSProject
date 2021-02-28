/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.to.JSPProfileUpdateTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static com.cms.constants.DatabaseConstants.*;
import com.cms.exception.DatabaseException;
import com.cms.util.PropertyUtil;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 *
 * @author Rishabh Gupta
 */
public class NomineeDetailsDAO implements INomineeDetailsDAO {

    Connection connection = null;
    DataManager dataManager = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    /**
     * 
     */
    public static final Logger LOGGER = Logger.getLogger(NomineeDetailsDAO.class);
    /**
     * 
     */
    public NomineeDetailsDAO() {

        try {
            dataManager =  DataManagerConnectionDAO.getDriverManager();
            connection = dataManager.getConnection();
            statement = connection.createStatement();

        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        }
    }

    @Override
    public boolean getNomineeDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        return getNomineeNames(jSPProfileUpdateTO);
    }

    private boolean getNomineeNames(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        boolean status = false;
        try {
            preparedStatement = connection.prepareStatement(GETNOMINEENAMECOUNT);
            preparedStatement.setString(1, jSPProfileUpdateTO.getMemberID());
            preparedStatement.setString(2, jSPProfileUpdateTO.getInsuranceType());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            preparedStatement = connection.prepareStatement(GETNOMINEEDETAILS);
            preparedStatement.setString(1, jSPProfileUpdateTO.getMemberID());
            preparedStatement.setString(2, jSPProfileUpdateTO.getInsuranceType());
            resultSet = preparedStatement.executeQuery();
            switch (count) {
                case 1:
                    resultSet.next();
                    jSPProfileUpdateTO.setNomineename1(resultSet.getString(1));
                    break;
                case 2:
                    resultSet.next();
                    jSPProfileUpdateTO.setNomineename1(resultSet.getString(1));
                    resultSet.next();
                    jSPProfileUpdateTO.setNomineename2(resultSet.getString(1));
                    break;
                case 3:
                    resultSet.next();
                    jSPProfileUpdateTO.setNomineename1(resultSet.getString(1));
                    resultSet.next();
                    jSPProfileUpdateTO.setNomineename2(resultSet.getString(1));
                    resultSet.next();
                    jSPProfileUpdateTO.setNomineename3(resultSet.getString(1));
                    break;
            }
            status = true;

        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
            throw new DatabaseException(PropertyUtil.getCMSMessages("230"));
        }
        return status;
    }

}
