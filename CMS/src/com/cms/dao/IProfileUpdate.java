/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;
import com.cms.to.ProfileUpdateTO;

/**
 *
 * @author Rishabh Gupta
 */
public interface IProfileUpdate {
    /**
     * @param profileUpdateVO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean updateProfile(ProfileUpdateTO profileUpdateVO) throws DatabaseException;
    /**
     * @param profileUpdateVO
     * @return boolean
     * @throws DatabaseException
     */
    public int isUpdatingFirstTimeProfile(ProfileUpdateTO profileUpdateVO) throws DatabaseException;
    /**
     * @param profileUpdateVO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean updateFirstTimeProfile(ProfileUpdateTO profileUpdateVO) throws DatabaseException;
}
