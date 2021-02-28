/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.exception.DatabaseException;


/**
 *
 * @author Rishabh Gupta
 */
public interface ICheckEmailAddress {

    /**
     * @param emailAddress
     * @return int
     * @throws DatabaseException
     */
    public int isEmailAddressPresent(String emailAddress) throws DatabaseException;
}
