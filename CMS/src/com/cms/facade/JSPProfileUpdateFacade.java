/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.service.JSPProfileUpdateService;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class JSPProfileUpdateFacade {

    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean getmemberCredentials(JSPProfileUpdateTO jSPProfileUpdateTO) throws CMSBusinessException, DatabaseException {
        return getMemberProfileUpdateDetails(jSPProfileUpdateTO);
    }

    private boolean getMemberProfileUpdateDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws CMSBusinessException, DatabaseException {
        return new JSPProfileUpdateService().getMemberProfileDetails(jSPProfileUpdateTO);
    }
}
