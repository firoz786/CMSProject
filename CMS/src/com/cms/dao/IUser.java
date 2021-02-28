package com.cms.dao;

import com.cms.exception.DatabaseException;
import com.cms.to.ProfileUpdateTO;

import com.cms.to.UserTO;

/**
 * @author Rishabh Gupta
 *
 */
public interface IUser {
	/**
	 * @param userTO
	 * @return int
	 * @throws DatabaseException
	 */
	public abstract int isValidUser(UserTO userTO) throws DatabaseException;
        
        /**
         * @param userTO
         * @return int
         * @throws DatabaseException
         */
        public abstract int checkUserCredentials(UserTO userTO) throws  DatabaseException;
        
        /**
         * @param profileUpdateTO
         * @return boolean
         * @throws DatabaseException
         */
        public abstract boolean isProfileUpdates(ProfileUpdateTO profileUpdateTO) throws DatabaseException;

}
