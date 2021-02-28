/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;
import com.cms.to.NomineeAdditionTO;

/**
 *
 * @author Rishabh Gupta
 */
public interface INomineeAdditionDAO {

    /**
     * @param nomineeAdditionTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean addNominee(NomineeAdditionTO nomineeAdditionTO) throws DatabaseException ;
     
}
