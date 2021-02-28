/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.dao.JSPProfileUpdateDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.to.JSPProfileUpdateTO;
import com.cms.util.PropertyUtil;

/**
 *
 * @author Rishabh Gupta
 */
public class JSPProfileUpdateService {

    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean getMemberProfileDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws CMSBusinessException, DatabaseException {

        boolean status = false;
        if (isMemberLogedIn(jSPProfileUpdateTO)) {
            status = getProfileDetails(jSPProfileUpdateTO);
        }
        return status;
    }

    private boolean getProfileDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws CMSBusinessException, DatabaseException {
        return new JSPProfileUpdateDAO().getProfileUpdateCredentials(jSPProfileUpdateTO);
    }

    private boolean isMemberLogedIn(JSPProfileUpdateTO jSPProfileUpdateTO) throws CMSBusinessException {
        boolean status = false;
        if (jSPProfileUpdateTO.getMemberID() != null) {
            status = true;
        } else {
            throw new CMSBusinessException(PropertyUtil.getCMSMessages("229"));
        }
        return status;
    }

}
