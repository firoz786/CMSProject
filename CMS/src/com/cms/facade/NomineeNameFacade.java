/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.exception.DatabaseException;
import com.cms.service.NomineeNameService;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class NomineeNameFacade {
    
    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean getNomineeDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException{
        return getNomineeNames(jSPProfileUpdateTO);
    }

    private boolean getNomineeNames(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        return new NomineeNameService().getNomineeDetailsFromDAO(jSPProfileUpdateTO);
    }
}
