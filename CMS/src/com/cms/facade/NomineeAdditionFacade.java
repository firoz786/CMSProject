/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.service.NomineeAdditionService;
import com.cms.to.NomineeAdditionTO;

/**
 *
 * @author Rishabh Gupta
 */
public class NomineeAdditionFacade {

    /**
     * @param nomineeAdditionTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean addNominee(NomineeAdditionTO nomineeAdditionTO) throws CMSBusinessException, DatabaseException {
        return addNomineename(nomineeAdditionTO);
    }

    private boolean addNomineename(NomineeAdditionTO nomineeAdditionTO) throws CMSBusinessException, DatabaseException {
        return new NomineeAdditionService().addNominee(nomineeAdditionTO);
    }

}
