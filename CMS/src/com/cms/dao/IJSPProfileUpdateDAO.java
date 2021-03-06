/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;
import com.cms.to.JSPProfileUpdateTO;


/**
 *
 * @author Rishabh Gupta
 */
public interface IJSPProfileUpdateDAO {

    /**
     * @param jSPProfileUpdateVO
     * @return boolean
     * @throws DatabaseException
     */
    public abstract boolean getProfileUpdateCredentials(JSPProfileUpdateTO jSPProfileUpdateVO) throws DatabaseException;

}
