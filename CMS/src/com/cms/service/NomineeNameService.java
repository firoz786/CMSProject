/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.dao.NomineeDetailsDAO;
import com.cms.exception.DatabaseException;
import com.cms.to.JSPProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public class NomineeNameService {

    /**
     * @param jSPProfileUpdateTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean getNomineeDetailsFromDAO(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        return getNomineeNamesFromDAO(jSPProfileUpdateTO);
    }

    private boolean getNomineeNamesFromDAO(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException {
        return new NomineeDetailsDAO().getNomineeDetails(jSPProfileUpdateTO);
    }
}
