/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.dao.NomineeNameRemoveDAO;
import com.cms.exception.DatabaseException;
import com.cms.to.NomineeNameRemovalTO;

/**
 *
 * @author Rishabh Gupta
 * 
 */
public class NomineeNameRemovalService {
    /**
     * @param nameRemovalTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean removeNominee(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException{
        return removeNomineeFromDatabase(nameRemovalTO);
    }

    private boolean removeNomineeFromDatabase(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException {
        return new NomineeNameRemoveDAO().removeNomineeName(nameRemovalTO);
    }
}
