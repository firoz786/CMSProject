/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import static com.cms.constants.PatternConstants.CONTACT;
import static com.cms.constants.PatternConstants.EMAIL;
import static com.cms.constants.PatternConstants.NAME;
import com.cms.dao.MemberRegistrationDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.to.MemberRegistrationTO;
import com.cms.util.PropertyUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rishabh Gupta
 */
public class MemberRegistrationService {

    /**
     * @param memberRegistrationTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean isValidMemberDetails(MemberRegistrationTO memberRegistrationTO) throws CMSBusinessException, DatabaseException {

        boolean status = false;
        if (isValidRegistrationDetails(memberRegistrationTO)) {
            status = true;
        }
        return status;
    }

    /**
     * @param memberRegistrationTO
     * @return boolean
     */
    public boolean registerNewMember(MemberRegistrationTO memberRegistrationTO) {
        return new MemberRegistrationDAO().registerMember(memberRegistrationTO);
    }

    private boolean isValidRegistrationDetails(MemberRegistrationTO memberRegistrationVO) throws CMSBusinessException {
        boolean status = false;
        Pattern pattern = Pattern.compile(NAME);
        Matcher matcher = pattern.matcher(memberRegistrationVO.getFirstname());
        if (matcher.matches()) {
            matcher = pattern.matcher(memberRegistrationVO.getLastname());
            if (matcher.matches()) {
                pattern = Pattern.compile(EMAIL);
                matcher = pattern.matcher(memberRegistrationVO.getEmailaddress());
                if (matcher.matches()) {
                    pattern = Pattern.compile(CONTACT);
                    matcher = pattern.matcher(memberRegistrationVO.getContactnumber());
                    if (matcher.matches()) {
                        if (memberRegistrationVO.getPassword().length() > 3) {
                            status = true;
                        } else {
                            throw new CMSBusinessException(PropertyUtil.getCMSMessages("226"));
                        }
                    } else {
                        throw new CMSBusinessException(PropertyUtil.getCMSMessages("203"));
                    }
                } else {
                    System.out.println(memberRegistrationVO.getEmailaddress());
                    throw new CMSBusinessException(PropertyUtil.getCMSMessages("202"));
                }
            } else {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("208"));
            }
        } else {
            throw new CMSBusinessException(PropertyUtil.getCMSMessages("201"));
        }
        return status;
    }

}
