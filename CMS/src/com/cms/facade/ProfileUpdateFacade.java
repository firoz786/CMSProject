/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.dao.ProfileUpdateDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.service.ProfileUpdateService;
import com.cms.to.ProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class ProfileUpdateFacade {

    /**
     * @param profileUpdateTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean updateProfile(ProfileUpdateTO profileUpdateTO) throws CMSBusinessException, DatabaseException {
        return new ProfileUpdateService().updateProfileDetails(profileUpdateTO);
    }
}
