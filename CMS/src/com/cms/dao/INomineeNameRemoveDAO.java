/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;
import com.cms.to.NomineeNameRemovalTO;

/**
 *
 * @author Rishabh Gupta
 */
interface INomineeNameRemoveDAO {
 
    public boolean removeNomineeName(NomineeNameRemovalTO nameRemovalTO) throws DatabaseException;
}
