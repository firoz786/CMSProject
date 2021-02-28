/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cms.to.MemberRegistrationTO;
import static com.cms.constants.DatabaseConstants.*;
import java.sql.CallableStatement;

/**
 *
 * @author Rishabh Gupta
 */
public class MemberRegistrationDAO implements IMemberRegistration {

    Connection connection = null;
    DataManager dataManager = null;
    Statement statement = null;
    CallableStatement callableStatement = null;
    /**
     * 
     */
    public static final Logger LOGGER = Logger.getLogger(MemberRegistrationDAO.class);
    /**
     * 
     */
    public MemberRegistrationDAO() {

        try {
            dataManager = DataManagerConnectionDAO.getDriverManager();
            connection = dataManager.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        }

    }

    @Override
    public boolean registerMember(MemberRegistrationTO memberRegistrationTO) {

        return setMemberDetails(memberRegistrationTO);
    }

    private boolean setMemberDetails(MemberRegistrationTO memberRegistrationTO) {

        boolean status = false;
        String query = null;
        try {
            
            callableStatement = connection.prepareCall(MEMBERREGISTRATION);
            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
            callableStatement.setString(2, memberRegistrationTO.getFirstname());
            callableStatement.setString(3, memberRegistrationTO.getLastname());
            callableStatement.setString(4, memberRegistrationTO.getGender());
            callableStatement.setString(5, memberRegistrationTO.getDateofbirth());
            callableStatement.setString(6, memberRegistrationTO.getEmailaddress());
            callableStatement.setString(7, memberRegistrationTO.getContactnumber());
            callableStatement.setString(8, memberRegistrationTO.getPassword());
            callableStatement.execute();
            memberRegistrationTO.setMemberID(callableStatement.getString(1));
            System.out.println(memberRegistrationTO.getMemberID());
            status = true;

        } catch (SQLException e) {
        	
        	LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        	
        }
        return status;

    }
}
