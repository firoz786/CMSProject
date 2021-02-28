/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.service.RequestClaimService;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class RequestClaimFacade {
    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws DatabaseException
     * @throws CMSBusinessException
     */
    public boolean getDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException, CMSBusinessException{
        return new RequestClaimService().getDetails(jSPProfileUpdateTO);
    }
}
