/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.service.CheckEmailAddressService;
import com.cms.service.PasswordCryptoService;
import com.cms.dao.MemberRegistrationDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.util.PropertyUtil;
import com.cms.to.MemberRegistrationTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.cms.constants.PatternConstants.*;
import com.cms.service.MemberRegistrationService;

/**
 *
 * @author Rishabh Gupta
 */
public class MemberRegistrationFacade {

    /**
     * @param memberRegistrationTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean registerMember(MemberRegistrationTO memberRegistrationTO) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        MemberRegistrationService memberRegistrationService = new MemberRegistrationService();
        if (memberRegistrationService.isValidMemberDetails(memberRegistrationTO)) {
            if (checkEmail(memberRegistrationTO)) {
                encryptPassword(memberRegistrationTO);
                status = memberRegistrationService.registerNewMember(memberRegistrationTO);

            }
        }
        return status;
    }

    private void encryptPassword(MemberRegistrationTO memberRegistrationTO) {
        memberRegistrationTO.setPassword(new PasswordCryptoService().getEncryptedPassword(memberRegistrationTO.getPassword()));
    }

    private boolean checkEmail(MemberRegistrationTO memberRegistrationTO) throws CMSBusinessException, DatabaseException {
        return new CheckEmailAddressService().isEmailAddressPresent(memberRegistrationTO.getEmailaddress());
    }

}
