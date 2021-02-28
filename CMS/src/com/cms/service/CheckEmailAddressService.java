/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;

import org.apache.log4j.Logger;

import com.cms.dao.CheckEmailAddressDAO;
import com.cms.util.PropertyUtil;

/**
 *
 * @author Rishabh Gupta
 */
public class CheckEmailAddressService {
	
    /**
     * @param emailAddress
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean isEmailAddressPresent(String emailAddress) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        int statusValue = new CheckEmailAddressDAO().isEmailAddressPresent(emailAddress);
        if (statusValue == 0) {
            status = true;
        } else {
        	
            throw new CMSBusinessException(PropertyUtil.getCMSMessages("225"));
        }
        return status;
    }
}
