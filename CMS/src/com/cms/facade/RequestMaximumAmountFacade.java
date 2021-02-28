/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.exception.DatabaseException;
import com.cms.service.RequestMaximumAmountService;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class RequestMaximumAmountFacade {
    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean getMaximumAmount(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException{
        return getAmount(jSPProfileUpdateTO);
    }

    private boolean getAmount(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
      return new RequestMaximumAmountService().getMaximumAmount(jSPProfileUpdateTO);
    }
}
