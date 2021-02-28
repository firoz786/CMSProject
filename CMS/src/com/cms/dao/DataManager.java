package com.cms.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cms.util.PropertyUtil;

/**
 * @author Rishabh Gupta
 *
 */
public class DataManager {

    private Connection connection = null;
    
    private static  Driver driver = new oracle.jdbc.OracleDriver();

    /**
     * @throws SQLException
     */
    public void createConnection() throws SQLException {

       
        DriverManager.registerDriver(driver);
        setConnection(DriverManager.getConnection(PropertyUtil.getUrl(), PropertyUtil.getUserName(),
                PropertyUtil.getPassword()));

    }

    /**
     * @param connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return boolean
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
    	createConnection();
        return connection;
    }

    /**
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if (getConnection() != null) {
            getConnection().close();
        }

    }

    
}
