/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.exception.DatabaseException;
import com.cms.service.NomineeNameRemovalService;
import com.cms.to.NomineeNameRemovalTO;

/**
 *
 * @author Rishabh Gupta
 */
public class NomineeNameRemovalFacade {
    /**
     * @param nameRemovalTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean removeNomiee(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException{
        return removeNomineeName(nameRemovalTO);
    }

    private boolean removeNomineeName(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException {
        return new NomineeNameRemovalService().removeNominee(nameRemovalTO);
    }
}
