/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.dao.UserLoginDAO;
import com.cms.exception.DatabaseException;
import com.cms.to.ProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class ProfileUpdateCheckService {
    
    /**
     * @param profileUpdateTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean isProfileUpdate(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
        return checkProfileUpdation(profileUpdateTO);
    }
    
    private boolean checkProfileUpdation(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
        boolean status = false;
        new UserLoginDAO().isProfileUpdates(profileUpdateTO);
        if (profileUpdateTO.getZipcode().equals("1")) {
            status = true;
        }
        return status;
    }
}
