/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.dao;

import com.cms.to.MemberRegistrationTO;

/**
 *
 * @author Rishabh Gupta
 */
public interface IMemberRegistration{
    
    /**
     * @param memberRegistrationVO
     * @return boolean
     */
    public boolean registerMember(MemberRegistrationTO memberRegistrationVO);
    
}
