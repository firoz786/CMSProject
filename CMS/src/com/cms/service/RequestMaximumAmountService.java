/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.dao.RequestMaximumAmountDAO;
import com.cms.exception.DatabaseException;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class RequestMaximumAmountService {
    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean getMaximumAmount(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException{
        return maximumAmountFromDAO(jSPProfileUpdateTO);
        
    }

    private boolean maximumAmountFromDAO(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        return new RequestMaximumAmountDAO().getAmount(jSPProfileUpdateTO);
    }
    
}
